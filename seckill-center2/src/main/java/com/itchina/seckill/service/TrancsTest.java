package com.itchina.seckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2021/6/21 6:11
 * @Desc:
 */
@Service
public class TrancsTest {

    @Autowired
    private ServiceAImpl ServiceA;

    @Autowired
    private ServiceBImpl ServiceB;

    /**
     * 有问题代码
     * ：因为整体是一个事务，updateA和updateB在一个事务中，
     * 1-updateA此时还没有提交，等待updateB的完成，此处有行锁的存在
     * 2-updateB又有一个事务，等待updateA的释放，updateB才能完成，造成类死锁
     * 解决方案：
     * 方案一：将 updateB的事务去掉
     * 方案二：添加 ypdateA的事务，在updateA刚执行完毕就提交
     */
    @Transactional(rollbackFor = Exception.class)
    public void exception() {
        ServiceA.updateA("100");

        ServiceB.updateB("100");
    }

}
