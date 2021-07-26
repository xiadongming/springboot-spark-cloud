package com.zhss.canal.handler;

import com.zhss.canal.entity.Student;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @Date: 2021/7/26 15:29
 * @Desc:
 */
@Component
@CanalTable(value = "student")
public class CanalStudentHandler implements EntryHandler<Student> {


    @Override
    public void insert(Student student) {
        System.out.println("插入数据：" + student);
    }

    @Override
    public void update(Student before, Student after) {

        System.out.println("修改数据，之前：" + before);
        System.out.println("修改数据，之后：" + after);

    }

    @Override
    public void delete(Student student) {

        System.out.println("删除数据：" + student);

    }
}
