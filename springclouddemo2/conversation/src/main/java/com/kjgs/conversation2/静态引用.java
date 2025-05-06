package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.*;
import java.util.stream.Collectors;

public class 静态引用 {
    public static Document 输入的句子对象;
    public static Document 逻辑句子对象;

    public static List<Document> 输入句子的成分集合 = new ArrayList<>();
    public static List<Document> 逻辑句子的成分集合 = new ArrayList<>();

    public static String 输出内容 = null;
    public static Integer 数据表下标 = null;
    public static int 逻辑执行层级 = 0;
    public static boolean 上个逻辑后面能否跟内置动作 = false;



//    public static Map<Integer, String> 所有逻辑对 = new HashMap<>();
    public static Map<Integer, String> 所有逻辑 = new HashMap<>();
    public static Map<Integer, String> 所有逻辑句子对象 = new HashMap<>();
    public static Map<Integer, String> 所有逻辑句子成分对象 = new HashMap<>();
    public static Map<String, HashSet<Integer>> 关键词与逻辑 = new HashMap<>();

    //在处理“那就”方法时赋值，用于如果在处理陈述方法时，判断结果为false就不做处理了
    public static boolean 是否是陈述部分逻辑=true;

    public void 全部置空(){
        输入的句子对象=null;
        逻辑句子对象 = null;
        输入句子的成分集合 = new ArrayList<>();
        逻辑句子的成分集合 = new ArrayList<>();
    }
    public static List<Document> get输入句子的指向成分集合(){
        List<Document> result = new ArrayList<>();
        for(Document document : 输入句子的成分集合){
            if(document.containsKey(Cons.指向)){
                result.add(Tool.代词的最终指向(document));
            }
        }
        return result;
    }

    //继续完善逻辑  要加内置逻辑间的执行层级：比如先执行“的”
    // 再者是比如 “遇到”作为动词，后面不能再跟内置动作，无论是动作还是非动作的
    //再者是给加是否变化的标识
    //再者是继续加内置功能
    //再者是给每个动作添加区别集合还是单个对象的标识

    public static Map<String, String> 内置词语与词性映射 = new HashMap(){{
        put("假设词","如果");
        put("输出词","输出");
    }};
    public static List<String> 内置词语集合 = new ArrayList(){{
        add("如果");
        add("遇到");
        add("那就");
        add("输出");
    }};

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
