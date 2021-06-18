package com.itchina.hystrix.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Date: 2021/5/5 14:16
 * @Desc: HystrixRequestContext  hsytrix的请求上下文
 */
public class HystrixRequestContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hystrixRequestContext.shutdown();
        }

    }

    @Override
    public void destroy() {

    }
}
