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

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/7/23 17:28
 * @Desc:
 */
@Component
public class ApplicationRpcServiceAware implements ApplicationContextAware {


    private static final Logger logger = LoggerFactory.getLogger(ApplicationRpcServiceAware.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("rpc服务开始加载");
        try {
            String jsonString = FileLoadUtils.transFerJsonStringFromFile("rpc.json");
            List<InvokeInfo> invokeInfos = doCreateInvokeInfos(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<InvokeInfo> doCreateInvokeInfos(String jsonString) {
        List<InvokeInfo> invokeInfos = JSONArray.parseArray(jsonString, InvokeInfo.class);
        return invokeInfos;
    }

}
