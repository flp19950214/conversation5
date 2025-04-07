package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 静态引用 {
    public static Document 输入的句子对象;
    public static Document 逻辑句子对象;

    public static List<Document> 输入句子的成分集合 = new ArrayList<>();
    public static List<Document> 逻辑句子的成分集合 = new ArrayList<>();

    public static Document 输出内容 = null;
    public static Integer 数据表下标 = null;
    public void 全部置空(){
        输入的句子对象=null;
        逻辑句子对象 = null;
        输入句子的成分集合 = new ArrayList<>();
        逻辑句子的成分集合 = new ArrayList<>();
    }

    public static List<String> 所有库 = new ArrayList(){{
        add("数据表");
        add("逻辑表2");
    }};
    public static List<String>  所有方位= new ArrayList(){{
        add("前");
        add("后");
    }};
    public static List<String>  所有单位= new ArrayList(){{
        add("段");
        add("段落");
        add("句子");
        add("字");
        add("词");
    }};
}
