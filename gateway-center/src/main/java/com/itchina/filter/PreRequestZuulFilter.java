package com.itchina.filter;

import com.itchina.commonfilter.AbstractPreZuulFilter;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/4/7 21:46
 * @Desc:  在过滤器中存储客户端发起请求的时间戳
 */
//@Component
public class PreRequestZuulFilter extends AbstractPreZuulFilter {
    @Override
    protected Object cRun() {
        requestContext.set("startTime",System.currentTimeMillis());


        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
