package com.itchina.template.handler;

import com.itchina.common.constant.CodeBaseEnum;

/**
 * @Date: 2021/4/11 10:17
 * @Desc:
 */
public class CodeEnumUtil {
    public  static  <E  extends  Enum<?> & CodeBaseEnum> E codeOf(Class<E> enumClass, int  code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for  (E e : enumConstants) {
            if  (e.code() == code)
                return  e;
        }
        return  null ;
    }
}
