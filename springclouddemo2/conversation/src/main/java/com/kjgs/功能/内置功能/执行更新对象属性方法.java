package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行更新对象属性方法 extends 功能抽象 {
    public static final String 更新的对象 = "更新的对象";
    public static final String 更新的属性 = "更新的属性";
    public static final String 更新的属性值 = "更新的属性值";
    @Override
    public void 功能() {
        Document 更新的对象 = (Document) 获取最近的属性值(所有逻辑对象, this.更新的对象,Document.class);
        String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
        String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
        try{
            更新的对象.put(更新的属性, 更新的属性值);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
