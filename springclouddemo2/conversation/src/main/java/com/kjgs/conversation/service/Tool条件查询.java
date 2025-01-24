package com.kjgs.conversation.service;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Tool条件查询 {

    public static List<Document> 过滤键值对(List<Document> filterResult, Pair 查询条件Pair){
        Object key = 查询条件Pair.getKey();
        Object value = 查询条件Pair.getValue();
        if(key!=null){
            String keyStr = key.toString();
            if(StringUtils.isNotEmpty(keyStr)){
                filterResult = filterResult.stream()
                        .filter(m -> m.keySet().contains(key))
                        .collect(Collectors.toList());
            }
        }
        if(value !=null){
            filterResult = filterResult.stream()
                    .filter(m -> m.containsValue(value))
                    .collect(Collectors.toList());
        }
        return filterResult;
    }
}
