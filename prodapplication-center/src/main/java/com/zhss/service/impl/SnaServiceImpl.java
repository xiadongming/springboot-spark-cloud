package com.zhss.service.impl;

import com.zhss.service.SnaService;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/30 16:14
 * @Desc:
 */
@Service
public class SnaServiceImpl implements SnaService {

    @Override
    public String doExecute() throws InterruptedException {
        Thread.sleep(100);
        return "good";
    }
}
