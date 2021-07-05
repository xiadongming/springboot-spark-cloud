package com.itchina.seckill.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2021/6/21 6:10
 * @Desc:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceBImpl {

    public  void updateB(String id){

    }
}
