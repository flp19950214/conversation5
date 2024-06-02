package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行输出方法 extends 功能抽象 {

    public static String 输出的内容 = "输出的内容";
    //直接分割句子
    public void 功能(){
        String 输出的内容 = 获取最近的属性值(所有逻辑对象, this.输出的内容);
        System.out.println(输出的内容);
    }

}
