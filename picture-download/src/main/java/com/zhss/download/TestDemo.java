package com.zhss.download;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Date: 2021/7/20 15:23
 * @Desc:
 */
public class TestDemo {


    public static void main(String[] args) {

        String urlPath = "http://prod-sale-retail.oss-cn-beijing.aliyuncs.com/resfile/mst/pictures/APIFILE_aca33bc8-840f-4944-aebb-929cf4e358dc.jpg";

        String downloadDir = "D:\\1_music\\";
        downloadFile(urlPath,  downloadDir);
    }
    public static File downloadFile(String urlPath, String downloadDir) {
        File file = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            //设置超时
            httpURLConnection.setConnectTimeout(1000 * 5);
            //设置请求方式，默认是GET
            httpURLConnection.setRequestMethod("GET");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();
            // 建立链接从请求中获取数据
            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
            // 指定文件名称(有需求可以自定义)
            String fileFullName = "aaa.jpg";

            // 指定存放位置(有需求可以自定义)
            String path = downloadDir + File.separatorChar + fileFullName;
            file = new File(path);
            // 校验文件夹目录是否存在，不存在就创建一个目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(file);
            int size = 0;
            long len = 0;
            byte[] buf = new byte[2048];
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
            }
            // 关闭资源
            bin.close();
            out.close();
            System.out.println("文件下载成功,文件大小：");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件下载失败！");
        } finally {
            return file;
        }
    }
}
