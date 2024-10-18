package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// 只查数据库对象  区别于  执行查询指定属性值方法
public class 执行查询内存集合方法 extends 功能抽象 {
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的属性值 = "查询的属性值";
    public static final String 查询的结果= "查询的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的属性).set参数名2(查询的属性值)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        String 查询的属性值 = 获取最近的属性值(所有逻辑对象, this.查询的属性值);
        List<Document> 查询的结果 = new ArrayList<>();
        for (int i = 0; i <所有逻辑对象.size() ; i++) {
            Document document = (Document) 所有逻辑对象.get(i);
            if(document.containsKey(查询的属性)){
                if(查询的属性值!=null){
                    if(StringUtils.equals(document.getString(查询的属性), 查询的属性值)){
                        查询的结果.add(document);
                    }
                }else{
                    查询的结果.add(document);
                }
            }
        }
        动作结果=查询的结果;
    }
}
