package com.itchina.commonfilter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Date: 2021/4/7 21:18
 * @Desc:
 */
public abstract  class AbstractPreZuulFilter extends AbstractZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
}
