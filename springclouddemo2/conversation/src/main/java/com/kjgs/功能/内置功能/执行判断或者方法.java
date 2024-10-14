package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.sun.org.apache.regexp.internal.RE;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class 执行判断或者方法 extends 功能抽象 {
    public static final String 判断的结果 ="判断的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set结果名(判断的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {//找到最近的两个判断结果 执行并方法
        List 判断的结果集合 = 获取所有的属性值(所有逻辑对象, this.判断的结果);
        if(判断的结果集合.size()>=2){
            boolean 倒数第二个判断结果 = Boolean.parseBoolean(判断的结果集合.get(判断的结果集合.size()-2).toString());
            boolean 倒数第一个判断结果 = Boolean.parseBoolean(判断的结果集合.get(判断的结果集合.size()-2).toString());
            Document 判断的结果的对象 = new Document();
            boolean 判断的结果 = 倒数第二个判断结果 || 倒数第一个判断结果;
            判断的结果的对象.put(this.判断的结果, 判断的结果);
            所有逻辑对象.add(判断的结果的对象);

            动作结果=判断的结果;
        }
    }
}
