package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行更新对象属性方法 extends 功能抽象 {
    public static final String 查询的对象的键 = "查询的对象的键";
    public static final String 查询的对象的值 = "查询的对象的值";
    public static final String 更新的对象类型 = "更新的对象类型";
    public static final String 更新的属性 = "更新的属性";
    public static final String 更新的属性值 = "更新的属性值";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的对象的键).set参数名2(查询的对象的值)
                .set参数名3(更新的属性).set参数名3(更新的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 查询的对象的键 = 获取最近的属性值(所有逻辑对象, this.查询的对象的键);
        String 查询的对象的值 = 获取最近的属性值(所有逻辑对象, this.查询的对象的值);
        String 更新的对象类型 = 获取最近的属性值(所有逻辑对象, this.更新的对象类型);
        Document 更新的对象Doc;
        if (StringUtils.isNotEmpty(查询的对象的键) && StringUtils.isNotEmpty(查询的对象的值)) {
            更新的对象Doc = 获取最近的对象(所有逻辑对象, 查询的对象的键, 查询的对象的值, 更新的对象类型);
            String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
            String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
            try {
                更新的对象Doc.put(更新的属性, 更新的属性值);
                更新的对象Doc.put(Cons.level, level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
            更新的对象Doc = 获取最近的对象(所有逻辑对象, 更新的属性);
            String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
            try {
                更新的对象Doc.put(更新的属性, 更新的属性值);
                更新的对象Doc.put(Cons.level, level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
