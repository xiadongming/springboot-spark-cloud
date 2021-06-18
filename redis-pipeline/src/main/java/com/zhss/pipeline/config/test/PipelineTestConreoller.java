package com.zhss.pipeline.config.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/6/18 15:15
 * @Desc:
 */
@RestController
public class PipelineTestConreoller {

    /**
     * sync()  是一次性发给redis进行执行的
     * hgetAll()  使用PIPE封装需要取值的key,此时还停留在客户端，并未真正执行查询请求
     * syncAndReturnAll() 并将操作结果以list返回
     */
    @Autowired
    private JedisPool jedisPool;

    @RequestMapping(value = "/pipeline")
    public Object getTest() {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();

        //造1000条数据
        for (int i = 0; i < 1000; i++) {
            pipeline.set("num" + i, "100");
        }
        pipeline.sync();
        jedis.close();
        return "successful";
    }
    @RequestMapping(value = "/pipelineQuery")
    public Object getTestQuery() {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();

        //造1000条数据
        for (int i = 0; i < 1000; i++) {
            pipeline.get("num" + i);
        }
        List<Object> objects = pipeline.syncAndReturnAll();
        jedis.close();
        return objects;
    }
    //批量 减1
    @RequestMapping(value = "/pipelineUpdate")
    public Object getTestUpdate() throws Exception {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000; i++) {
            pipeline.decrBy("num" + i, 1L);
        }
        pipeline.sync();
        jedis.close();
        return "successful";
    }
    //批量 减1  抛异常
    @RequestMapping(value = "/pipelineUpdate3")
    public Object getTestUpdate3() throws Exception {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000; i++) {
            pipeline.decrBy("num" + i, 1L);
        }
        pipeline.sync();
        throw new Exception(); //reids数量已经修改，不会回滚
    }



    //批量修改
    @RequestMapping(value = "/pipelineUpdate2")
    public Object getTestUpdate2() {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000; i++) {
            pipeline.decrBy("num" + i, 1L);
        }
        List<Object> objects = pipeline.syncAndReturnAll();
        jedis.close();
        return objects;
    }

    //批量删除
    @RequestMapping(value = "/pipelineDelete")
    public Object getTestDelete() {
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000; i++) {
            pipeline.del("num" + i);
        }
        List<Object> objects = pipeline.syncAndReturnAll();

        jedis.close();
        return objects;
    }
    //批量删除  exec是用来提交事务的，
    @RequestMapping(value = "/pipelineExec")
    public Object getTestExec() {
        return null;
    }
}
