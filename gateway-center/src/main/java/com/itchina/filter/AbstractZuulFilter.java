package com.itchina.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Date: 2021/4/7 8:47
 * @Desc: 自定义抽象过滤器
 */
public abstract class AbstractZuulFilter extends ZuulFilter {
    /**
     * RequestContext 用于在过滤器之间传递消息，数据保存在ThreadLocal中
     */
    RequestContext requestContext;


    private final static String nextFilter = "next";

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        return (Boolean) context.getOrDefault(nextFilter,true);
    }


    /**
     * shouldFilter 返回true时，run()方法才执行
     */
    @Override
    public Object run() throws ZuulException {
        requestContext = RequestContext.getCurrentContext();
        return cRun();
    }

    protected abstract Object cRun();

    Object fail(int code,String msg){
        requestContext.set(nextFilter,false);
        requestContext.setSendZuulResponse(false);
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        requestContext.setResponseStatusCode(code);
        requestContext.setResponseBody(String.format("{\"result\":\"%s!\"}",msg));
        return null;
    }
    Object success(){
        requestContext.set(nextFilter,true);
        return null;
    }

}
