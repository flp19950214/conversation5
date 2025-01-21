package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 获取当前逻辑成分后面最近一个词性是目标词语的值的对象 extends 功能抽象 {
    private String 目标词语 = "目标词语";
    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        String 目标词语 = 获取最近的属性值(所有逻辑对象, this.目标词语);
        int 当前逻辑句子成分的结束下标 = ToolService.获取当前逻辑句子成分的结束下标(uuidLevel);
        Document 当前逻辑后面一个目标成分 = 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型), Cons.逻辑句子成分))
                 .filter(m -> m.containsKey(Cons.在句子中的下标)
                            && m.getInteger(Cons.在句子中的下标) >= 当前逻辑句子成分的结束下标)
                .filter(m -> m.containsKey(Cons.词性)
                        && StringUtils.equals(m.getString(Cons.词性), 目标词语))
                .findFirst().orElse(null);

        静态变量.添加执行层级集合(String.format("%s %s", level, " 当前逻辑后面一个目标成分："+当前逻辑后面一个目标成分));
        动作结果=当前逻辑后面一个目标成分;
    }
}
