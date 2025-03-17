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

    public static String 输出内容 = "";
    public void 全部置空(){
        输入的句子对象=null;
        逻辑句子对象 = null;
        输入句子的成分集合 = new ArrayList<>();
        逻辑句子的成分集合 = new ArrayList<>();
    }
}
