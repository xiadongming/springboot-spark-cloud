package com.zhss.api.aware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Date: 2021/7/23 17:30
 * @Desc:
 */
public class FileLoadUtils {


    public static String transFerJsonStringFromFile(String fileName) throws IOException {
        InputStream is = FileLoadUtils.class.getResourceAsStream("/" + fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String jsonString = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((jsonString = br.readLine()) != null) {
            stringBuilder.append(jsonString);
        }
        br.close();
        isr.close();
        return String.valueOf(stringBuilder);
    }

}
