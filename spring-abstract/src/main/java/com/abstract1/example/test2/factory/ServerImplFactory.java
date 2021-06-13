package com.abstract1.example.test2.factory;

import com.abstract1.example.test2.SelectCountryUserByRoleServiceImpl;
import com.abstract1.example.test2.SelectProvinceUserByRoleServiceImpl;
import com.abstract1.example.test2.SelectUserByRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/4 22:01
 * @Desc:
 */
@Service
public class ServerImplFactory implements ServerFactory {

    @Autowired
    SelectProvinceUserByRoleServiceImpl selectProvinceUserByRoleService;

    @Autowired
    SelectCountryUserByRoleServiceImpl selectCountryUserByRoleService;

    @Override
    public SelectUserByRoleService create(String id) {
        if ("1".equals(id)) {
            return selectProvinceUserByRoleService;
        }
        if ("2".equals(id)) {
            return selectCountryUserByRoleService;
        }
        return null;
    }
}
