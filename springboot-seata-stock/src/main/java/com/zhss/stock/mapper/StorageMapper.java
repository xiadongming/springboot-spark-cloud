package com.zhss.stock.mapper;

import com.zhss.stock.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/4/8 22:37
 * @Desc:
 */
@Mapper
public interface StorageMapper {

    List<Storage> selectAll();

    void saveTemplate(Storage template);

}
