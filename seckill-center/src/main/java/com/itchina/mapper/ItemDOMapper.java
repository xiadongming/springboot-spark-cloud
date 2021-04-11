package com.itchina.mapper;

import com.itchina.entity.ItemDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDOMapper {
    List<ItemDO> listItem();
    int deleteByPrimaryKey(Integer id);
    int insert(ItemDO record);
    int insertSelective(ItemDO record);
    ItemDO selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(ItemDO record);
    int updateByPrimaryKey(ItemDO record);
    int increaseSales(@Param("id")Integer id,@Param("amount")Integer amount);
}