package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.算法.工具;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 执行过滤集合元素长度方法 extends 功能抽象 {
    public static final String 过滤的对象 = "过滤的对象";
    public static final String 过滤的长度 = "过滤的长度";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(过滤的对象).set参数名2(过滤的长度);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List 过滤的对象 = (List)获取最近的属性值(所有逻辑对象, this.过滤的对象, List.class);
        int 过滤的长度 = 工具.strDdoubleToInt(获取最近的属性值(所有逻辑对象, this.过滤的长度));
        List 过滤的结果 = new ArrayList();
        for (int i = 0; i <过滤的对象.size() ; i++) {
            if(过滤的对象.get(i).toString().length() == 过滤的长度){
                过滤的结果.add(过滤的对象.get(i));
            }
        }
        动作结果=过滤的结果;
    }
}
