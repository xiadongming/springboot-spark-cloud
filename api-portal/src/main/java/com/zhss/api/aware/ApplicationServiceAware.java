package com.zhss.api.aware;

import com.alibaba.fastjson.JSONArray;
import com.zhss.api.entry.application.InvokeInfo;
import com.zhss.api.registry.RegistryContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/7/21 14:56
 * @Desc: 启动的时候，获取扫描网关下配置的服务
 */
@Component
public class ApplicationServiceAware implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceAware.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            String jsonString = transFerJsonStringFromFile();
            List<InvokeInfo> invokeInfos = doCreateInvokeInfos(jsonString);
            for (InvokeInfo invokeInfo : invokeInfos) {
                //从spring容器中获取bena数据
                //Object bean = applicationContext.getBean(invokeInfo.getService_name());
                //invokeInfo.setServiceBean(bean);
                RegistryContent.setRegistry(invokeInfo.getService(), invokeInfo);
                Map<String, ?> beansOfType = applicationContext.getBeansOfType(Class.forName(invokeInfo.getService_name()));
                invokeInfo.setServiceBean(beansOfType.values().iterator().next());
            }
        } catch (Exception e) {
            logger.error("解析json文件异常：", e);
        }
    }

    private List<InvokeInfo> doCreateInvokeInfos(String jsonString) {
        List<InvokeInfo> invokeInfos = JSONArray.parseArray(jsonString, InvokeInfo.class);
        return invokeInfos;
    }

    private String transFerJsonStringFromFile() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/auth.json");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String jsonString = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((jsonString = br.readLine()) != null) {
            stringBuilder.append(jsonString);
        }
        br.close();
        isr.close();
        return String.valueOf(stringBuilder);
    }

    /**
     * {
     * service='authority/area/selectAreaTree',
     * service_name='com.ohaotian.authority.area.service.SelectAreaTreeByParentIdService',
     * service_version='AUTHORITY_VERSION',
     * group_name='AUTHORITY_GROUP',
     * method_name='selectAreaTree',
     * client_timeout='30000'
     * }
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream is = ApplicationServiceAware.class.getResourceAsStream("/auth.json");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder stringBuilder = new StringBuilder();
        String jsonString = null;
        while ((jsonString = br.readLine()) != null) {
            stringBuilder.append(jsonString);
        }
        System.out.println(stringBuilder);
        br.close();
        isr.close();
        List<InvokeInfo> invokeInfos = JSONArray.parseArray(String.valueOf(stringBuilder), InvokeInfo.class);
        System.out.println("invokeInfos= " + invokeInfos);
    }
}
