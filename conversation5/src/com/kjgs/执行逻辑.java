package com.kjgs;

import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 执行逻辑 {
    @Test
    public void test1(){
        String sen = "ss\\nsdf";
        System.out.println(sen);
        System.out.println(Arrays.toString(sen.split("\n")));
    }

    public static String 保存逻辑0="保存的对象《是》小明\n保存的属性《是》名字\n保存的属性值《是》小明\n《执行保存方法》";
    public static String 更新逻辑0="更新的主键《是》ObjectId(\"66514c96e5d2a40c245040fe\")\n更新的属性《是》名字\n更新的属性值《是》小明\n《执行更新方法》";
    public static String 查询逻辑1="查询条件的键《是》对象\n查询条件的值《是》你\n《执行查询方法》\n过滤对象是${查询结果}\n过滤条件的键《是》年龄\n《执行过滤大于方法》";
    public static String 查询更新逻辑="查询条件的键《是》对象\n查询条件的值《是》你\n《执行查询方法》\n过滤对象是${查询结果}\n过滤条件的键《是》年龄\n《执行过滤大于方法》"
            +"循环对象《是》${过滤结果}\n循环动作《是》执行更新方法\n更新的主键《是》ObjectId(\"66514c96e5d2a40c245040fe\")\n更新的属性《是》名字\n更新的属性值《是》小明\n《执行循环方法》"
            +"更新的主键《是》";
    @Test
    public void test(){
        //分割逻辑
        List<String> 逻辑集合 = Arrays.asList(保存逻辑0.split("\n"));
        List<Document> 所有逻辑对象 = new ArrayList<>();
        //提取动作
        for (int i = 0; i <逻辑集合.size() ; i++) {
            String 当前逻辑句子 = 逻辑集合.get(i);
            String 动作 = StringUtils.substringBetween(当前逻辑句子, Cons.左尖括号, Cons.右尖括号);

            //执行动作
            try {
                功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 动作).newInstance();
                功能抽象对象.执行流程(所有逻辑对象, 当前逻辑句子, 动作);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
