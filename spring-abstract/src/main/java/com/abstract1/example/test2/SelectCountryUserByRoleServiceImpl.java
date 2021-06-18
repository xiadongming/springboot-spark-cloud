package com.abstract1.example.test2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/6/4 21:55
 * @Desc:
 */
@Service("selectCountryUserByRoleService")
public class SelectCountryUserByRoleServiceImpl extends  SelectUserByRoleAbstractService{

    @Override
    public List<String> doExecuteQuery(String name) {
        List<String> objects = new ArrayList<>();
        RoleUserInfoBaseBO roleUserInfoBaseBO = new RoleUserInfoBaseBO();
        roleUserInfoBaseBO.setRoleLevel("01");
        roleUserInfoBaseBO.setStatus("1");
        roleUserInfoBaseBO.setUserLevel("01");

        validStatue(roleUserInfoBaseBO);
        validUserLevel(roleUserInfoBaseBO);
        validRoleLevel(roleUserInfoBaseBO);

        System.out.println(roleUserInfoBaseBO);

        objects.add("selectCountryUserByRoleService");
        return objects;
    }
}
