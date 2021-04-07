package com.itchina.filter;

import com.itchina.commonfilter.AbstractPreZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2021/4/7 21:24
 * @Desc: token过滤器
 */
@Component
public class TokenFilter extends AbstractPreZuulFilter {

    @Override
    protected Object cRun() {
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            return fail(401,"token为空");
        }
        return success();
    }
    /**
     * 数值越小，越先执行
     * */
    @Override
    public int filterOrder() {
        return 1;
    }
}
