package com.zhss.pipeline.service.impl;

import com.zhss.pipeline.entity.SysUser;
import com.zhss.pipeline.mapper.SysUserMapper;
import com.zhss.pipeline.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Date: 2021/7/5 17:35
 * @Desc:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 说明：数据库的回滚，不能回滚redis中的数据
     *      数据库能回滚，redis中不会回滚
     * @param key
     * @return
     */
    @Transactional
    @Override
    public List<SysUser> findAllByUserIdAndStatus(String key) {
        //List<SysUser> allByUserIdAndStatus = sysUserMapper.findAllByUserIdAndStatus();
        SysUser sysUser = new SysUser();
        sysUser.setCellPhone("1111");
        sysUser.setLoginName(key);
        sysUser.setUserId("1");
        sysUserMapper.updateUser(sysUser);
        jedisPool.getResource().set(key, "100");

        int a = 100 / 0;

        return null;
    }
}
