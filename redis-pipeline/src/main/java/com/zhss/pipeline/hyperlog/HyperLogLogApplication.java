package com.zhss.pipeline.hyperlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Date: 2021/6/24 18:09
 * @Desc:
 */
@RestController
public class HyperLogLogApplication {

    @Autowired
    private JedisPool jedisPool;

    /**
     * HyperLogLog是用来处理 基数统计 的，
     * ，在输入元素的数量或者体积非常非常大时，计算基数所需的空间总是固定的、并且是很小的
     * 　在 Redis 里面，每个 HyperLogLog 键只需要花费 12 KB 内存，就可以计算接近 2^64 个不同元素的基数
     * 因为 HyperLogLog 只会根据输入元素来计算基数，而不会储存输入元素本身，所以 HyperLogLog 不能像集合那样，返回输入的各个元素。
     * 应用场景：去重计数
     * 一般使用：
     * 　　　　1-统计注册 IP 数
     * 　　　　2-统计每日访问 IP 数
     * 　　　　3-统计页面实时 UV 数
     * 　　　　4-统计在线用户数
     * 　　　　5-统计用户每天搜索不同词条的个数
     */
    @GetMapping("/hyperLogLog")
    public void getTest() {
        Jedis jedis = jedisPool.getResource();
        //给key赋值,如果和基数不同返回1，和基数相同返回0
        Long m1 = jedis.pfadd("m1", "1", "2", "3");
        Long m2 = jedis.pfadd("m2", "4", "5", "1");
        System.out.println("m1= " + m1 + ",m2= " + m2);
        //获取key对应的值的个数
        long m1Value = jedis.pfcount("m1");
        long m2Value = jedis.pfcount("m2");
        long m12Value = jedis.pfcount("m1", "m2");
        System.out.println("m1Value= " + m1Value + ", m2Value= " + m2Value + ", m12Value= " + m12Value);
        //合并
        String pfmerge = jedis.pfmerge("m1", "m2");
        System.out.println("pfmerge= " + pfmerge);
    }
}
