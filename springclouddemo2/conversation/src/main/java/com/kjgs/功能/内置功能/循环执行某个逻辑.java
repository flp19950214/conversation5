package com.kjgs.功能.内置功能;

import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.逻辑流程2.新处理逻辑;
import com.kjgs.静态变量;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class 循环执行某个逻辑 extends 功能抽象 {
    public static final String 待循环的逻辑 = "待循环的逻辑";
    public static final String 是否继续循环的判断逻辑 = "是否继续循环的判断逻辑";
    public static final String 循环元素的下标偏移逻辑 = "循环元素的下标偏移逻辑";
    public static final String 循环的结果 = "循环的结果";

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Autowired
    private 逻辑Impl 逻辑impl;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(待循环的逻辑).set参数名2(是否继续循环的判断逻辑)
                .set参数名3(循环的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        String 待循环的逻辑 =  获取最近的属性值(所有逻辑对象, this.待循环的逻辑);
        String 是否继续循环的判断逻辑 = 获取最近的属性值(所有逻辑对象, this.是否继续循环的判断逻辑);
        String 循环元素的下标偏移逻辑 = 获取最近的属性值(所有逻辑对象, this.循环元素的下标偏移逻辑);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 待循环的逻辑："+ 待循环的逻辑));
        静态变量.添加执行层级集合(String.format("%s %s", level, " 是否继续循环的判断逻辑："+ 是否继续循环的判断逻辑));
        boolean 是否继续循环;
        逻辑实体 是否继续循环的判断逻辑Obj = 逻辑impl.根据逻辑名查询单个处理逻辑(是否继续循环的判断逻辑);
        是否继续循环 = (boolean)新处理逻辑Impl.执行逻辑(是否继续循环的判断逻辑Obj, UUID.randomUUID().toString(), level);
        逻辑实体 待循环的逻辑Obj = 逻辑impl.根据逻辑名查询单个处理逻辑(待循环的逻辑);
        逻辑实体 循环元素的下标偏移逻辑Obj = null;
        if(StringUtils.isNotEmpty(循环元素的下标偏移逻辑)){
            循环元素的下标偏移逻辑Obj = 逻辑impl.根据逻辑名查询单个处理逻辑(循环元素的下标偏移逻辑);
        }
        while(是否继续循环){
            this.动作结果 = 新处理逻辑Impl.执行逻辑(待循环的逻辑Obj, UUID.randomUUID().toString(), level);
            是否继续循环 = (boolean)新处理逻辑Impl.执行逻辑(是否继续循环的判断逻辑Obj, UUID.randomUUID().toString(), level);
            if(循环元素的下标偏移逻辑Obj!=null){
                新处理逻辑Impl.执行逻辑(循环元素的下标偏移逻辑Obj, UUID.randomUUID().toString(), level);
            }
        };
    }
}
