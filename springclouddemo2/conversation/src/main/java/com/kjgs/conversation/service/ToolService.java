package com.kjgs.conversation.service;

import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolService {

    public static Document 获取当前逻辑句子对象(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.当前处理的逻辑句子)
                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的逻辑句子)))
               .findFirst().orElse(null);
    }
    public static String 获取当前逻辑句子(){
        Document 当前逻辑句子对象 = 获取当前逻辑句子对象();
        if(当前逻辑句子对象 == null){
            return null;
        }
        return 当前逻辑句子对象.getString(Cons.当前处理的逻辑句子);
    }

    public static List<Document> 获取句子成分集合(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型),Cons.句子成分))
                .collect(Collectors.toList());
    }

    public static List<Document> 获取逻辑句子的成分集合(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型),Cons.逻辑句子成分))
                .collect(Collectors.toList());
    }
    public static Document 获取当前句子成分(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型), Cons.句子成分))
                .filter(m -> m.containsKey(Cons.是否是当前处理的句子成分)
                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的句子成分)))
                .findFirst().orElse(null);
    }
    public static Document 获取当前逻辑句子成分(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型), Cons.逻辑句子成分))
                .filter(m -> m.containsKey(Cons.是否是当前处理的句子成分)
                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的句子成分)))
                .findFirst().orElse(null);
    }
    public static String 获取当前逻辑句子成分的词语(){
        Document 获取当前逻辑句子成分 = 获取当前逻辑句子成分();
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getString(Cons.词语);
        }
        return null;
    }

    public static String 获取当前逻辑句子成分的句型(){
        Document 获取当前逻辑句子成分 = 获取当前逻辑句子成分();
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getString(Cons.句型);
        }
        return null;
    }

    public static int 获取当前逻辑句子成分的结束下标(){
        Document 获取当前逻辑句子成分 = 获取当前逻辑句子成分();
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getInteger(Cons.在句子中的结束下标);
        }
        return -1;
    }
}
