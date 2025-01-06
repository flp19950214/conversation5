package com.kjgs.conversation.service;

import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolService {

    public static List<Document> 获取句子成分集合(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型) && m.containsValue(Cons.句子成分))
                .peek(m -> m.remove(Cons._id))
                .collect(Collectors.toList());

    }


    public static List<Document> 获取逻辑句子的成分集合(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型) && m.containsValue(Cons.逻辑句子成分))
                .peek(m -> m.remove(Cons._id))
                .collect(Collectors.toList());

    }
}
