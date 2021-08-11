package com.zhss.snow;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2021/8/5 17:52
 * @Desc:
 */
public class IdGeneratorSnowFlakeUtils {

    private static final Logger logger = LoggerFactory.getLogger(IdGeneratorSnowFlakeUtils.class);
    /**
     * 工作中心(机房) 0-31
     */
    private static long workerId = 0;
    /**
     * 1号机器  0-31
     */
    private static long datacenterId = 1;
    private static Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);


    public static synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

}
