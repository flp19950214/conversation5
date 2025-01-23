package com.kjgs.conversation.service;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolService {

    @Autowired
    功能对象 功能对象Impl;

    public static boolean 是否存在逻辑对象(String uuidLevel, String 词语, int 下标){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型),Cons.逻辑句子成分))
                .filter(m -> m.containsKey(Cons.uuidLevel)
                        && m.getString(Cons.uuidLevel).equals(uuidLevel))
                .filter(m -> m.containsKey(Cons.在句子中的下标)
                        && 下标==m.getInteger(Cons.在句子中的下标))
                .filter(m -> m.containsKey(Cons.词语)
                        && StringUtils.equals(m.getString(Cons.词语), 词语))
                .count()>0;
    }

    public static boolean 是否存在逻辑句子(String uuidLevel, String 句子){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.uuidLevel)
                        && m.getString(Cons.uuidLevel).equals(uuidLevel))
                .filter(m -> m.containsKey(Cons.当前处理的逻辑句子)
                        && StringUtils.equals(m.getString(Cons.当前处理的逻辑句子), 句子))
                .count()>0;
    }

    public static Document 获取当前逻辑句子对象(String uuidLevel){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.uuidLevel)
                        && m.getString(Cons.uuidLevel).equals(uuidLevel))
                .filter(m -> m.containsKey(Cons.当前处理的逻辑句子)
//                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的逻辑句子))
                )
                .reduce((a,b) -> b).orElse(null);
    }
    public static String 获取当前逻辑句子(String uuidLevel){
        Document 当前逻辑句子对象 = 获取当前逻辑句子对象(uuidLevel);
        if(当前逻辑句子对象 == null){
            return null;
        }
        return 当前逻辑句子对象.getString(Cons.当前处理的逻辑句子);
    }

    public static void 是否执行判断结果设置为true(){
        for (int i = 执行逻辑.所有逻辑对象.size() - 1; i >= 0; i--) {
            Document document = 执行逻辑.所有逻辑对象.get(i);
            if (document.containsKey(Cons.是否执行判断结果)) {
                document.put(Cons.是否执行判断结果, true);
            }
        }
    }

    public static List<Document> 获取句子成分集合(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型),Cons.句子成分))
                .collect(Collectors.toList());
    }

    public static List<Document> 获取逻辑句子的成分集合(String uuidLevel){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型),Cons.逻辑句子成分))
                .filter(m -> m.containsKey(Cons.uuidLevel)
                        && m.getString(Cons.uuidLevel).equals(uuidLevel))
                .collect(Collectors.toList());
    }
    public static Document 获取当前句子成分(){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型), Cons.句子成分))
                .filter(m -> m.containsKey(Cons.是否是当前处理的句子成分)
                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的句子成分)))
                .reduce((a,b) -> b).orElse(null);
    }
    public static Document 获取当前逻辑句子成分(String uuidLevel){
        return 执行逻辑.所有逻辑对象.stream()
                .filter(m -> m.containsKey(Cons.uuidLevel)
                        && m.getString(Cons.uuidLevel).equals(uuidLevel))
                .filter(m -> m.containsKey(Cons.对象类型)
                        && StringUtils.equals(m.getString(Cons.对象类型), Cons.逻辑句子成分))
                .filter(m -> m.containsKey(Cons.是否是当前处理的句子成分)
                        && BooleanUtils.isTrue(m.getBoolean(Cons.是否是当前处理的句子成分))
                )
                .reduce((a,b) -> b).orElse(null);
    }
    public static String 获取当前逻辑句子成分的词语(String uuidLevel){
        Document 获取当前逻辑句子成分 = 获取当前逻辑句子成分(uuidLevel);
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getString(Cons.词语);
        }
        return null;
    }

    public static String 获取当前逻辑句子的句型(String uuidLevel){
        Document 当前逻辑句子对象 = 获取当前逻辑句子对象(uuidLevel);
        if(当前逻辑句子对象 != null){
            return 当前逻辑句子对象.getString(Cons.句型);
        }
        return null;
    }

    public static int 获取当前逻辑句子成分的结束下标(String uuidLevel){
        Document 获取当前逻辑句子成分 = 获取当前逻辑句子成分(uuidLevel);
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getInteger(Cons.在句子中的结束下标);
        }
        return -1;
    }

    public static int 获取当前句子成分的结束下标(){
        Document 获取当前逻辑句子成分 = 获取当前句子成分();
        if(获取当前逻辑句子成分 != null){
            return 获取当前逻辑句子成分.getInteger(Cons.在句子中的结束下标);
        }
        return -1;
    }

    public static Document 获取集合中结束下标最大的一条(List<Document> 集合){
        if(CollectionUtils.isEmpty(集合)){
            return null;
        }
        int max=0;
        Document result=集合.get(0);
        for(Document document:集合){
            if(!document.containsKey(Cons.在句子中的结束下标)){
                continue;
            }
            if(document.getInteger(Cons.在句子中的结束下标)>max){
                max = document.getInteger(Cons.在句子中的结束下标);
                result = document;
            }
        }
        return result;
    }
}
