package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 作为 extends 功能抽象 {

    //直接分割句子
    public void 功能(){
        Document document = new Document();
        String key = 当前逻辑句子.substring(0,获取当前动作对象开始下标());
        Object key2 = 获取最近的属性值value(所有逻辑对象, key, Object.class);
        // 找出真正的结果
        String value = 当前逻辑句子.substring(获取当前动作对象结束下标());
        Object value2 = 获取最近的属性值value(所有逻辑对象, value, Object.class);
        document.put(value2.toString(),key2);
        所有逻辑对象.add(document);
    }

}
