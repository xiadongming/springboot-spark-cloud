package com.zhss.pipeline.mapper;


import com.zhss.pipeline.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysUserMapper {

    /**
     * <h2>根据 userId + 状态寻找优惠券记录</h2>
     * */
    List<SysUser> findAllByUserIdAndStatus();
    void updateUser(SysUser sysUser);

}
