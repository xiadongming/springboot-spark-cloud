package com.zhss.two;

import com.zhss.Event;

/**
 * @Date: 2021/8/13 14:19
 * @Desc:
 */
public class EventImpl implements Event {

    @Override
    public String callBackResponse() {
        return "实现类的响应结果";
    }
}
