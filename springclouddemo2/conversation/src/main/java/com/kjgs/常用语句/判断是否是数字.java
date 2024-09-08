package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.常用语句.抽象.逻辑抽象;
import com.kjgs.逻辑流程.执行逻辑;
import org.junit.Test;
import org.springframework.stereotype.Service;

@Service
public class 判断是否是数字 extends 逻辑抽象 {
    /**
     * 判断条件和判断结果要分开处理     */
    String 判断是否是数字 = "￥{查询这个词的类型}\n被判断的对象《是》￥{查询的结果}\n判断的对象《是》数字\n《执行判断等于方法》" +
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    @Test
    public void test(){
        执行逻辑.执行逻辑(判断是否是数字, "2");
    }

    @Override
    public void 初始化记录常用逻辑() {
        逻辑实体 obj = new 逻辑实体();
        obj.set逻辑名(功能抽象.getClasName()).set逻辑(判断是否是数字);
        异步初始化类.初始化记录内置功能属性(obj);
    }
}
