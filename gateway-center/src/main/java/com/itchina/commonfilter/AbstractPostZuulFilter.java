package com.itchina.commonfilter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Date: 2021/4/7 21:20
 * @Desc:
 */
public abstract class AbstractPostZuulFilter extends AbstractZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
