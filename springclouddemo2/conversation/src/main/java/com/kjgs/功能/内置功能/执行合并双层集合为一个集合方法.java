package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 执行合并双层集合为一个集合方法 extends 功能抽象 {
    public static final String 被合并的集合 = "被合并的集合";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被合并的集合);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List 被判断的对象 =  (List)获取最近的属性值(所有逻辑对象, this.被合并的集合, List.class);
        List result = new ArrayList();
        for(Object obj:被判断的对象){
            if(obj instanceof List){
                result.addAll((List)obj);
            }else{
                result.add(obj);
            }
        }

        动作结果=result;
    }
}
