package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class 执行过滤集合对象方法 extends 功能抽象 {
    public static final String 过滤的对象 = "过滤的对象";
    public static final String 过滤的属性 = "过滤的属性";
    public static final String 过滤的属性值 = "过滤的属性值";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(过滤的对象).set参数名2(过滤的属性)
                .set结果名(过滤的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List<Document> 过滤的对象 = (List<Document>)获取最近的属性值(所有逻辑对象, this.过滤的对象, List.class);
        String 过滤的属性 = 获取最近的属性值(所有逻辑对象, this.过滤的属性);
        String 过滤的属性值 = 获取最近的属性值(所有逻辑对象, this.过滤的属性值);
        if(StringUtils.isEmpty(过滤的属性) && StringUtils.isEmpty(过滤的属性值)){
            动作结果=过滤的对象;
            return;
        }
        List<Document> 过滤的结果 = new ArrayList<>();
        if(StringUtils.isNotEmpty(过滤的属性) && StringUtils.isEmpty(过滤的属性值)){
            for(Document document : 过滤的对象){
                if(document.containsKey(过滤的属性)){
                    过滤的结果.add(document);
                }
            }
        }else if(StringUtils.isEmpty(过滤的属性) && StringUtils.isNotEmpty(过滤的属性值)){
            for(Document document : 过滤的对象){
                if(document.containsValue(过滤的属性值)){
                    过滤的结果.add(document);
                }
            }
        }else if(StringUtils.isNotEmpty(过滤的属性) && StringUtils.isNotEmpty(过滤的属性值)){
            for(Document document : 过滤的对象){
                for(Map.Entry entry: document.entrySet()){
                    if(StringUtils.equals(entry.getKey().toString(),过滤的属性)
                        && StringUtils.endsWith(entry.getValue().toString(), 过滤的属性值)){
                        过滤的结果.add(document);
                        break;
                    }
                }
            }
        }

        动作结果=过滤的结果;
    }
}
