package com.zhss.pipeline.service;

import com.zhss.pipeline.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2021/7/5 17:35
 * @Desc:
 */
public interface RedisService {
    List<SysUser> findAllByUserIdAndStatus(String key);
}
