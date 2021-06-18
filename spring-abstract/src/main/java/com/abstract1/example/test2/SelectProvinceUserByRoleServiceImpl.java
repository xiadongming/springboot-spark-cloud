package com.abstract1.example.test2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/6/4 21:54
 * @Desc:
 */
@Service("selectProvinceUserByRoleService")
public class SelectProvinceUserByRoleServiceImpl extends  SelectUserByRoleAbstractService{
    @Override
    public List<String> doExecuteQuery(String name) {
        List<String> objects = new ArrayList<>();
        objects.add("selectProvinceUserByRoleService");
        return objects;
    }
}
