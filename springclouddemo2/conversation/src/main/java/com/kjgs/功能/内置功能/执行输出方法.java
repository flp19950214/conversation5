package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

@Service
public class 执行输出方法 extends 功能抽象 {

    public static String 输出的内容 = "输出的内容";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(输出的内容);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    //直接分割句子
    public void 功能(){
        String 输出的内容 = 获取最近的属性值(所有逻辑对象, this.输出的内容);
        System.out.println(输出的内容);
    }

}
