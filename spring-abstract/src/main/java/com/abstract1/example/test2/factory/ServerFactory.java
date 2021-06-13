package com.abstract1.example.test2.factory;

import com.abstract1.example.test2.SelectUserByRoleService;

/**
 * @Date: 2021/6/4 22:01
 * @Desc:
 */
public interface ServerFactory {

    SelectUserByRoleService create(String id);

}
