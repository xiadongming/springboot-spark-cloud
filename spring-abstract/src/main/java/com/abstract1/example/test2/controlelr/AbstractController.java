package com.abstract1.example.test2.controlelr;

import com.abstract1.example.test2.SelectUserByRoleService;
import com.abstract1.example.test2.factory.ServerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2021/6/4 22:02
 * @Desc:
 */
@RestController
@RequestMapping("/dev")
public class AbstractController {

    @Autowired
    private ServerFactory serverFactory;

    @RequestMapping(value = "/dev")
    public Object getTest(String id) {
        SelectUserByRoleService selectUserByRoleService = serverFactory.create(id);
        List<String> strings = selectUserByRoleService.doExecuteQuery(id);
        return strings;
    }
}
