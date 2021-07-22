package com.zhss.threadlocal.service.impl;

import com.zhss.threadlocal.service.ThreadLocalService;
import com.zhss.threadlocal.utils.GloalThreadLocalUserinfo;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/7/6 17:31
 * @Desc:
 */
@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {

    @Override
    public void test() {

        System.out.println("service= " + GloalThreadLocalUserinfo.getCurrentUser());
    }
}
