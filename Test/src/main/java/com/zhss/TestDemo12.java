package com.zhss;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @Date: 2021/7/16 18:41
 * @Desc:
 */
public class TestDemo12 {

    public static void main(String[] args) {

        String root = "1-2-";

        String trr1 = "1-2-9100000216-";
        String trr2 = "1-2-9100000216-9200086289-";
        String trr3 = "1-2-9100000216-9200086289-9200095874-";
        String trr4 = "1-2-9100000216-9200086289-9200095878-";

        List<String> strings = new ArrayList<>();
        strings.add(trr1);
        strings.add(trr2);
        strings.add(trr3);
        strings.add(trr4);
        //解析成单个的orgId，HashMap<String,List<String>>的结构

        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> childrenOrgIds = new ArrayList<>();

        resultMap.put(root, childrenOrgIds);

        int length_11 = 11;
        int length_22 = 22;
        int length_33 = 33;
        for (String treePathElement : strings) {
            String replace = treePathElement.replace(root, "");
            if (replace.length() == length_11) {
                System.out.println("11长度= " + replace);
                String orgIdIndex1 = replace.substring(0, replace.indexOf("-"));
                System.out.println("       " + orgIdIndex1);

                System.out.println(replace.replace(orgIdIndex1 + "-",""));

            } else if (replace.length() == length_22) {
                System.out.println("22长度= " + replace);
                String orgIdIndex1 = replace.substring(0, replace.indexOf("-"));
                String substring = replace.replace(orgIdIndex1 + "-", "");
                System.out.println("       " + orgIdIndex1);
                String substring1 = substring.substring(0, replace.indexOf("-"));
                System.out.println("       " + substring1);
            } else if (replace.length() == length_33) {
                System.out.println("33长度= " + replace);
                String orgIdIndex1 = replace.substring(0, replace.indexOf("-"));
                System.out.println("       " + orgIdIndex1);
                String replace1 = replace.replace(orgIdIndex1 + "-", "");
                String substring1 = replace1.substring(0, replace.indexOf("-"));
                System.out.println("       " + substring1);
                String replace2 = replace1.replace(substring1 + "-", "");
                String substring2 = replace2.substring(0, replace.indexOf("-"));
                System.out.println("       " + substring2);
            }
        }

    }
}
