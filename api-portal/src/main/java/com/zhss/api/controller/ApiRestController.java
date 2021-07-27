package com.zhss.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhss.api.entry.OrderInfoPO;
import com.zhss.api.entry.application.InvokeInfo;
import com.zhss.api.registry.RegistryContent;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2021/7/21 14:44
 * @Desc: 门户路由转发，同意接收请求
 */
@RestController
public class ApiRestController {

    private static final Logger logger = LoggerFactory.getLogger(ApiRestController.class);

    ConcurrentHashMap<String, InvokeInfo> registry = RegistryContent.getRegistry();

    /**
     * 访问：均可  /portal/**  或者 /portal/  或者  /portal
     */
    @RequestMapping(value = "/portal/**", method = {RequestMethod.GET, RequestMethod.POST})
    public Object portal(HttpServletRequest request, HttpServletResponse response) {
        logger.info("uri= {}", request.getRequestURI()); //    /portal/123/789/abc
        logger.info("url= {}", request.getRequestURL()); //     http://localhost:9123/portal/123/789/abc
        Object restlt = null;
        try {
            JSONObject paramsMap = getParamsJSON(request);
            logger.info("页面入参paramsMap= {}", paramsMap);
            restlt = ApiInvoke(paramsMap, request.getRequestURI());
            logger.info("反射调用结果restlt= {}", restlt);
        } catch (Exception e) {
            logger.error("反射调用失败：", e);
        }
        return restlt;
    }

    private Object ApiInvoke(JSONObject paramsMap, String requestURI) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, IOException {
        String newUri = requestURI.replace("/portal/", "");
        Object result = null;
        if (registry.containsKey(newUri)) {
            result = doInvoke(paramsMap, newUri);
        } else {
            logger.error("未配置服务：{}", newUri);
        }
        return result;
    }

    private Object doInvoke(JSONObject paramsMap, String newUri) throws IllegalAccessException, InstantiationException, IOException, InvocationTargetException {
        InvokeInfo invokeInfo = registry.get(newUri);
        Object serviceBean = invokeInfo.getServiceBean();//是 serviceImpl
        Class<?> aClass = serviceBean.getClass();
        String methodName = invokeInfo.getMethod_name(); //queryOrders
        //getDeclaredMethod 调用任何类型的方法
        // getMethod 只能调用 piublic类型的方法
        Method method = null;
        Object newInstance = aClass.newInstance(); //  OrderServiceImpl
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
                break;
            }
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];  // OrderInfoPO
        Object newInstanceOrderInfoPO = parameterType.newInstance(); // orderInfoPO
        //给入参赋值
        doGetParamsAttributes(paramsMap, newInstanceOrderInfoPO);
        Object[] objects = new Object[]{newInstanceOrderInfoPO};

        Object result = method.invoke(newInstance, objects);//第二个参数表示实际入参
        System.out.println("result= " + result);
        return result;
    }

    //Object[] 中装的是  参数类型 如OrderPO
    private void doGetParamsAttributes(JSONObject paramsMap, Object newInstance1) throws IllegalAccessException {
        for (Map.Entry<String, Object> stringObjectEntry : paramsMap.entrySet()) {
            String paramsMapKey = stringObjectEntry.getKey();
            Object paramsMapValue = stringObjectEntry.getValue();
            Field[] declaredFields = newInstance1.getClass().getDeclaredFields();
            List<Field> fields = Arrays.asList(declaredFields);
            for (Field field : fields) {
                if (field.getName().equals(paramsMapKey)) {
                    field.setAccessible(true);
                    if (field.getType().getName().equals("java.lang.String")) {
                        //相当于  newInstance1.setName(value);  反射调用写法比较尴尬
                        field.set(newInstance1, paramsMapValue);
                    }
                    if (field.getType().getName().equals("java.lang.Integer")) {
                        field.set(paramsMapKey, new Integer(100200));
                    }
                }
            }
        }
    }


    /**
     * 解析json参数
     */
    private JSONObject getParamsJSON(HttpServletRequest request) {

        BufferedReader bReader = null;
        InputStreamReader isr = null;
        try {
            InputStream iis = request.getInputStream();
            isr = new InputStreamReader(iis, "utf-8");
            bReader = new BufferedReader(isr);
            String str = null;
            StringBuffer buffer = new StringBuffer();

            while ((str = bReader.readLine()) != null) {
                buffer.append(str).append("\n");
            }
            JSONObject json = (JSONObject) JSONObject.parseObject(buffer.toString());
            return json;
        } catch (IOException e) {
        } finally {
            try {
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject();
    }


    /**
     * 适合
     * get请求
     * 和
     * post请求参数的key=value
     */
    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> requestParamsMap = new HashMap<>();
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            requestParamsMap.put(entry.getKey(), Arrays.asList(entry.getValue()).get(0));
        }
        return requestParamsMap;
    }

    /**
     * 访问：
     * 只能 /portal2/
     * 不能 /portal2
     * 不能 /portal2/**
     */
    @RequestMapping(value = "/portal2/", method = {RequestMethod.GET, RequestMethod.POST})
    public Object portal2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("uri2= " + request.getRequestURI());
        System.out.println("url2= " + request.getRequestURL());
        return null;
    }

    /**
     * 访问：/portal 和 /portal/ 均可
     * 不能： /portal/**
     */
    @RequestMapping(value = "/portal", method = {RequestMethod.GET, RequestMethod.POST})
    public Object portal3(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("uri3= " + request.getRequestURI());
        System.out.println("url3= " + request.getRequestURL());
        return null;
    }

    /**
     * 直接通过dubbo，泛化调用
     */
    @RequestMapping(value = "/rpc")
    public Object rpcController(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("api-generic-consumer-zjt");
        RegistryConfig registry = new RegistryConfig();

        registry.setAddress("zookeeper://127.0.0.1:2181");
        application.setRegistry(registry);
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        String interfaceName = "com.zhss.api.service.api.OrderSerachService";
        reference.setInterface(interfaceName);
        // 声明为泛化接口
        reference.setGeneric(true);
        reference.setApplication(application);
        GenericService genericService = reference.get();


        //全部方法
        Method[] methods = Class.forName(interfaceName).getMethods();
        Method targetMethos = null;
        for (Method method : methods) {
            if (method.getName().equals("elasticSearchOrders")) {
                targetMethos = method;
            }
        }
        Class<?>[] parameterTypes = targetMethos.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];  // OrderInfoPO
        Object newInstanceOrderInfoPO = parameterType.newInstance(); // orderInfoPO
        //给入参赋值
        JSONObject paramsMap = getParamsJSON(request);
        doGetParamsAttributes(paramsMap, newInstanceOrderInfoPO);

        //Object[] objects = new Object[]{newInstanceOrderInfoPO};

        String target = newInstanceOrderInfoPO.toString();
        String[] strings = {target};

        Map<String, Object> param = new HashMap<String, Object>();
        //param.put("class", target);
        param.put("orderId", "101");
        param.put("orderName", "北京没团");

        Object[] objects = {param};

        Object elasticSearchOrders = genericService.$invoke("elasticSearchOrders", strings, objects);

        System.out.println("响应结果elasticSearchOrders:= " + elasticSearchOrders);

        return "sssss";
    }

}
