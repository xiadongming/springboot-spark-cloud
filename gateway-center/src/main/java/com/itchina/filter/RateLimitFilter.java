package com.itchina.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.itchina.commonfilter.AbstractPreZuulFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2021/4/7 21:39
 * @Desc: 限流过滤器
 */
@Component
public class RateLimitFilter extends AbstractPreZuulFilter {
    /**
     * 限流过滤器
     * 每秒可以获得2个令牌
     */
    RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Override
    protected Object cRun() {
        HttpServletRequest request = requestContext.getRequest();
        /** 获取令牌成功 */
        if (rateLimiter.tryAcquire()) {
            System.out.println("获取令牌成功");
            return success();
        }else{
            System.out.println("获取令牌失败，requestUrl="+request.getRequestURI());
            return fail(402,"获取令牌失败");
        }
    }
    @Override
    public int filterOrder() {
        return 2;
    }
}
