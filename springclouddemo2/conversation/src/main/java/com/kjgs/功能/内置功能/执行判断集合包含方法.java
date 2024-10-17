package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class 执行判断集合包含方法 extends 功能抽象 {
    public static final String 被判断的对象 = "被判断的对象";
    public static final String 判断的对象 ="判断的对象";
    public static final String 判断的结果 ="判断的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被判断的对象).set参数名2(判断的对象).set结果名(判断的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List 被判断的对象 =  (List)获取最近的属性值(所有逻辑对象, this.被判断的对象, List.class);
        String 判断的对象 = 获取最近的属性值(所有逻辑对象, this.判断的对象);
        boolean 判断的结果 = false;
        for(Object obj:被判断的对象){
            if(StringUtils.equals(obj.toString(), 判断的对象)){
                判断的结果 = true;
                break;
            }
        }

//        Document 判断的结果的对象 = new Document();
//        判断的结果的对象.put(this.判断的结果, 判断的结果);
//        判断的结果的对象.put(Cons.level,level);
//        所有逻辑对象.add(判断的结果的对象);

        动作结果=判断的结果;
    }
}
