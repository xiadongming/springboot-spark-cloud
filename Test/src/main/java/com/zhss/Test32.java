package com.zhss;

import com.zhss.entity.AreaMappingPO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Date: 2021/8/3 11:48
 * @Desc:
 */
public class Test32 {

    private static  final String  SEPARATOR= "\",\"";

    public static void main(String[] args) {

        String str = "abc";

        String abc = "\"" + str + "\"" +",";
        System.out.println(abc);

        AreaMappingPO areaMappingPO = new AreaMappingPO();
        areaMappingPO.setAreaCode("1000");

        areaMappingPO.setAreaName("北京市");
        areaMappingPO.setAreaLevel("40");
        areaMappingPO.setAreaTreePath("1-2-100-");
        areaMappingPO.setParentCode("100");


        List<AreaMappingPO> objects = new ArrayList<>();
        objects.add(areaMappingPO);

        handleData(objects);

        System.out.println(objects);

        // "1000","北京市","100","1-2-100-","40"

        Iterator<AreaMappingPO> iterator = objects.iterator();
        while (iterator.hasNext()){
            StringBuilder stringBuilder = new StringBuilder();
            AreaMappingPO next = iterator.next();
            String s = next.toString();
            stringBuilder.append(s).append(SEPARATOR);

            System.out.println("stringBuilder= "+stringBuilder);



        }

    }
    private static  void handleData(List<AreaMappingPO> areaMappingPOS) {
        //将数据中的各个字段，拼接上双引号
        for (AreaMappingPO areaMappingPO : areaMappingPOS) {
            StringBuilder stringBuilder = new StringBuilder();
           /* areaMappingPO.setAreaCode("\"" + areaMappingPO.getAreaCode() + "\"" + ",");
            areaMappingPO.setAreaName("\"" + areaMappingPO.getAreaName() + "\"" + ",");
            areaMappingPO.setAreaTreePath("\"" + areaMappingPO.getAreaTreePath() + "\"" + ",");
            areaMappingPO.setParentCode("\"" + areaMappingPO.getParentCode() + "\"" + ",");
            areaMappingPO.setAreaLevel("\"" + areaMappingPO.getAreaLevel() + "\"");*/

            stringBuilder.append(areaMappingPO.getAreaCode()).append(SEPARATOR);
            /*stringBuilder.append(areaMappingPO.getAreaName()).append(SEPARATOR);
            stringBuilder.append(areaMappingPO.getAreaTreePath()).append(SEPARATOR);
            stringBuilder.append(areaMappingPO.getParentCode()).append(SEPARATOR);
            stringBuilder.append(areaMappingPO.getAreaLevel()).append(SEPARATOR);
            */

            System.out.println(stringBuilder);
        }
    }

}
