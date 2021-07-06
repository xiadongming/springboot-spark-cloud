package com.zhss.redisson.controller;

import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/7/6 7:00
 * @Desc:
 */
@RestController
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/redisson")
    public void test() {
        RMap<Object, Object> anfMap = redissonClient.getMap("anfMap");
        anfMap.put("abc", "100");
        RMap<Object, Object> anfMap1 = redissonClient.getMap("anfMap");
        System.out.println(anfMap1.get("abc"));
    }

    /**
     * 分布式锁
     * : 只有获取锁的客户端，能够继续运行，没有获取锁的客户端，则会阻塞，等待释放做
     */
    @RequestMapping(value = "/lock")
    public void lock() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock3");
        lock.lock(3000, TimeUnit.HOURS);
        System.out.println(Thread.currentThread().getName() + "获取锁" + " ");
        Thread.sleep(5000);
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }

    @RequestMapping(value = "/trylock")
    public void tryLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock4");
        boolean b = lock.tryLock(2, 10, TimeUnit.SECONDS);
        //需要根据返回值b，自己逻辑判断
        System.out.println(Thread.currentThread().getName() + "获取锁" + " " + b);
        if (b) {
            System.out.println(Thread.currentThread().getName() + "释放锁");
            lock.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获取锁");
        }
    }
}
