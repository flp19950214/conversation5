package com.kjgs.conversation4;

import org.apache.commons.collections4.MapUtils;
import org.bson.Document;

import java.util.*;

public class Tool {

    public static List<String> printLog(String log) {
        System.out.println(log);
        TalkController4.logList.add(log);
        return TalkController4.logList;
    }

    public static Map<String, Set<String>> 分组词语的处理逻辑(List<Document> 逻辑集合){
        Map<String, Set<String>> result = new HashMap<>();
        for(Document document: 逻辑集合){
            String 逻辑名 = document.getString(Cons.逻辑名);
            String 逻辑 = document.getString(Cons.逻辑);
            if(result.containsKey(逻辑名)){
                result.get(逻辑名).add(逻辑);
            }else{
                Set<String> set = new HashSet<>();
                set.add(逻辑);
                result.put(逻辑名, set);
            }
        }
        return result;
    }
}
