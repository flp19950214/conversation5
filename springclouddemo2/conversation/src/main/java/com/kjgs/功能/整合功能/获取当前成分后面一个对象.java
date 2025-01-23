package com.kjgs.功能.整合功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.lang.model.element.VariableElement;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class 获取当前成分后面一个对象 extends 功能抽象 {
    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        Document 下一个成分 = 下一个成分();
        静态变量.添加执行层级集合(String.format("%s %s", level, " 当前成分后面一个对象："+ JSON.toJSONString(下一个成分)));
        动作结果 = 下一个成分;
    }

    public Document 下一个成分(){
        int 当前句子成分的结束下标 = ToolService.获取当前句子成分的结束下标();
        List<Document> 获取句子成分集合 = ToolService.获取句子成分集合();
        List<Document> collect = 获取句子成分集合.stream()
                .filter(m -> m.containsKey(Cons.在句子中的下标)
                        && m.getInteger(Cons.在句子中的下标) == 当前句子成分的结束下标
                ).collect(Collectors.toList());
        Document 获取集合中结束下标最大的一条 = ToolService.获取集合中结束下标最大的一条(collect);
        return 获取集合中结束下标最大的一条;
    }
}
