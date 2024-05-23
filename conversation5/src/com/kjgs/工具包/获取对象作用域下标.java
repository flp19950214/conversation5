package com.kjgs.工具包;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public class 获取对象作用域下标 {
    public static void main(String[] args) {

    }

    public static int 开始下标(Document document){
        Integer 开始下标 = document.getInteger(Cons.下标);
        return 开始下标 == null ? 0:开始下标;
    }

    public static int 结束下标(Document document){
        Integer 结束下标 = document.getInteger(Cons.结束下标);
        Integer 开始下标 = document.getInteger(Cons.下标);
        String 对象 = document.getString(Cons.对象);
        return 结束下标 == null ? 开始下标+对象.length() : 结束下标;
    }
}
