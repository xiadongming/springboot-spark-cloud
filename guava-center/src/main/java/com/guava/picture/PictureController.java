package com.guava.picture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @Date: 2021/5/23 8:25
 * @Desc:
 */
@RestController
@RequestMapping("/picture")
public class PictureController {


    @RequestMapping("/res")
    public void getTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = new File("D:\\z_test_pic\\2.jpg");
        FileInputStream fis;
        fis = new FileInputStream(file);

        long size = file.length();
        byte[] temp = new byte[(int) size];
        fis.read(temp, 0, (int) size);
        fis.close();
        byte[] data = temp;
        OutputStream out = response.getOutputStream();
        response.setContentType("image/png");
        out.write(data);
        out.flush();
        out.close();
    }
}
