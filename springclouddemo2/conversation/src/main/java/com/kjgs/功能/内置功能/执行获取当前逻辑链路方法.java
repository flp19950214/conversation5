package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑层级实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 执行获取当前逻辑链路方法 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List<Document> result = method();
        动作结果 = result;
    }

    public List<Document> method(){
        List<Document> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(静态变量.逻辑实体执行链路)) {
            for (int i = 静态变量.逻辑实体执行链路.size() - 1; i >= 0; i--) {
                逻辑层级实体 model = 静态变量.逻辑实体执行链路.get(i);
                Document document = new Document();
                document.put(Cons.逻辑,model.逻辑);
                document.put(Cons.逻辑名,model.逻辑名);
                document.put(Cons.level, model.level);
                result.add(document);
                if (model.level == 0) {
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
    }
}