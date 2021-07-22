package com.zhss.api.entry.application;

import java.io.Serializable;

/**
 * @Date: 2021/7/21 15:24
 * @Desc:
 */
public class InvokeInfo implements Serializable {

    private String service;
    private String service_name;
    private Object serviceBean;
    private String service_version;
    private String group_name;
    private String method_name;
    private String client_timeout;


    public Object getServiceBean() {
        return serviceBean;
    }

    public void setServiceBean(Object serviceBean) {
        this.serviceBean = serviceBean;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_version() {
        return service_version;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getClient_timeout() {
        return client_timeout;
    }

    public void setClient_timeout(String client_timeout) {
        this.client_timeout = client_timeout;
    }

    @Override
    public String toString() {
        return "InvokeInfo{" +
                "service='" + service + '\'' +
                ", service_name='" + service_name + '\'' +
                ", serviceBean=" + serviceBean +
                ", service_version='" + service_version + '\'' +
                ", group_name='" + group_name + '\'' +
                ", method_name='" + method_name + '\'' +
                ", client_timeout='" + client_timeout + '\'' +
                '}';
    }
}
