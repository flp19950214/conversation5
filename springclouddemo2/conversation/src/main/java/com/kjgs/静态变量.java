package com.kjgs;

import com.kjgs.实体.逻辑层级实体;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class 静态变量 {
    public static List<Document> 上一层句子成分集合 = new ArrayList<>();
    public static List<String> 输出的内容= new ArrayList<>();
    public static int level=0;
    public static String uuidLevel="";
    public static String 上一步结果="";
    public static List<逻辑层级实体> 逻辑实体执行链路=new ArrayList<>();
    public static List<String> 逻辑执行链路=new ArrayList<>();

    public static List<String> 执行层级集合 = new ArrayList<>();

    public static void 添加执行层级集合(String line){
        if(StringUtils.isEmpty(line)){
            return;
        }
        try{
            //前面加\t格式化
            int num = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            line = line.substring(line.indexOf(" ")+1);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <num ; i++) {
                sb.append("  ");
            }
            sb.append(line);
            执行层级集合.add(sb.toString());
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
