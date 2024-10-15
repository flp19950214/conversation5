package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行更新对象属性方法 extends 功能抽象 {
    public static final String 更新的对象 = "更新的对象";
    public static final String 更新的属性 = "更新的属性";
    public static final String 更新的属性值 = "更新的属性值";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(更新的对象).set参数名2(更新的属性).set参数名3(更新的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 更新的对象 = 获取最近的属性值(所有逻辑对象, this.更新的对象);
        Document 更新的对象Doc = 获取最近的对象(所有逻辑对象, 更新的对象);
        String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
        String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
        try{
            更新的对象Doc.put(更新的属性, 更新的属性值);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
