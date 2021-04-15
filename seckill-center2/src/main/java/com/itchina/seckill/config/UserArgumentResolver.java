package com.itchina.seckill.config;

import com.itchina.seckill.entity.SeckillUserInfo;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Method;

/**
 * @Date: 2021/4/13 7:55
 * @Desc:
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * supportsParameter()返回true，才会执行  resolveArgument() 方法
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> parameterType = methodParameter.getParameterType();
        Method method = methodParameter.getMethod();

        System.out.println("methodName= " + method.getName());
        boolean isSeckillUserType = parameterType == SeckillUserInfo.class;
        System.out.println("isSeckillUserType= " + isSeckillUserType);
        return isSeckillUserType;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        SeckillUserInfo seckillUserInfo = new SeckillUserInfo();
        seckillUserInfo.setName("name-在HandlerMethodArgumentResolver进行复制");
        seckillUserInfo.setAge("age-在HandlerMethodArgumentResolver进行复制");
        seckillUserInfo.setAddRess("address-在HandlerMethodArgumentResolver进行复制");
        return seckillUserInfo;
    }
}
