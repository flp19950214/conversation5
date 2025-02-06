package com.kjgs.conversation2;

import com.kjgs.功能.功能抽象;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class 调用逻辑 {
    @Autowired
    private ApplicationContext context;

    public void 执行逻辑(String 动作, Document 逻辑成分){
        try {
            FuncAbstract funcAbstract = (FuncAbstract)
                    context.getBean(Class.forName("com.kjgs.conversation2.func." + 动作));
            funcAbstract.执行流程(逻辑成分);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
