package com.zhss.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Date: 2021/7/28 11:10
 * @Desc:
 */
public class NioDemo {

    public static void main(String[] args) throws IOException {


        File file = new File("");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);

        File dst = new File("");

        FileOutputStream  fileOutputStream  = new FileOutputStream(dst);

        FileChannel channel1 = fileOutputStream.getChannel();

        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        channel1.write(buffer2);



    }
}
