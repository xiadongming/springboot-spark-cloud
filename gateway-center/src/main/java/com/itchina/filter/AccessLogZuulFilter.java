package com.itchina.filter;

import com.itchina.commonfilter.AbstractPostZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2021/4/7 21:48
 * @Desc:
 */
//@Component
public class AccessLogZuulFilter extends AbstractPostZuulFilter {
    @Override
    protected Object cRun() {
        HttpServletRequest request = requestContext.getRequest();

        Long startTime = (Long) requestContext.get("startTime");
        String requestURI = request.getRequestURI();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("请求时间间隔time = " + time);
        return success();
    }

    @Override
    public int filterOrder() {
        /**
         * FilterConstants.SEND_RESPONSE_FILTER_ORDER 即1000，在1000之后的过滤器不再执行
         * FilterConstants.SEND_RESPONSE_FILTER_ORDER-1  表示在最后执行
         * */
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }
}
