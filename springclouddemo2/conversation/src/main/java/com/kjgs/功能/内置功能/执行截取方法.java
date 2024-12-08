package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.静态变量;
import org.springframework.stereotype.Service;

@Service
public class 执行截取方法 extends 功能抽象 {
    public static final String 被截取的对象 = "被截取的对象";
    public static final String 截取的开始下标 ="截取的开始下标";
    public static final String 截取的结束下标 ="截取的结束下标";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被截取的对象).set参数名2(截取的开始下标)
                .set结果名(截取的结束下标);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被截取的对象 = 获取最近的属性值(所有逻辑对象, this.被截取的对象);
        String 截取的开始下标 = 获取最近的属性值(所有逻辑对象, this.截取的开始下标);
        String 截取的结束下标 = 获取最近的属性值(所有逻辑对象, this.截取的结束下标);
        int 截取的开始下标int = 0;
        int 截取的结束下标int = 被截取的对象.length();
        if(截取的开始下标!=null){
            截取的开始下标int=(int)Double.parseDouble(截取的开始下标);
        }
        if(截取的结束下标!=null){
            截取的结束下标int=(int)Double.parseDouble(截取的结束下标);
        }
        Object result = 被截取的对象.substring(截取的开始下标int, 截取的结束下标int);
        动作结果=result;
    }
}
