package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 作为 extends 功能抽象 {
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }
    //直接分割句子
    public void 功能(){
        Document document = new Document();
        String key = 当前逻辑句子.substring(0,获取当前动作对象开始下标(getClasName()));
        Object key2 = 获取最近的属性值value(所有逻辑对象, key, Object.class);
        // 找出真正的结果
        String value = 当前逻辑句子.substring(获取当前动作对象结束下标(getClasName()));
        Object value2 = 获取最近的属性值value(所有逻辑对象, value, Object.class);
        document.put(value2.toString(),key2);
        document.put(Cons.level,level);
        所有逻辑对象.add(document);
    }

}
