package com.itchina.common.advice;

import com.itchina.common.annotation.IgnoreResponseAdvice;
import com.itchina.common.vo.CommonResopnse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Date: 2021/4/7 22:25
 * @Desc: adview增强
 * RestControllerAdvice 是对restController的增强
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 判断是否需要对响应进行处理
     * false 不需要处理
     * true  需要处理,执行 beforeBodyWrite()方法
     * <p>
     * 如果有自定义注解IgnoreResponseAdvice，则返回false，不需要处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        /**
         * 如果当前类被IgnoreResponseAdvice 所标记，
         * */
        boolean annotationPresent = methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class);
        if (annotationPresent) {
            return false;
        }
        boolean annotationPresent1 = methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class);
        if (annotationPresent1) {
            return false;
        }
        return true;
    }

    /**
     * 响应返回之前的处理
     * Object：是controller中方法的返回内容，如果是null，则没有返回值
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {


        CommonResopnse<Object> resopnse = new CommonResopnse(0, "");
        // 如果是void，则不需要设置resopnse的data
        if (null == o) {
            return resopnse;
        } else if (o instanceof CommonResopnse) {
            resopnse = (CommonResopnse<Object>) o;
            /**
             * 如果不属于，则作为data返回
             * */
        } else {
            resopnse.setData(o);
        }
        return resopnse;
    }
}
