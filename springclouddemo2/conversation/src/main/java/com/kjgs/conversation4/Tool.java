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

    /**
     *  找到当前逻辑的下一个词  从末端开始搜索，找到下标=当前逻辑的结束下标即可
     */
    public static Document 倒叙下一个词(List<Document> list, int 结束下标){
        for (int i = list.size()-1; i >=0 ; i--) {
            Document document = list.get(i);
            if (结束下标 == document.getInteger(Cons.下标)) {
                return document;
            }
        }
        return null;
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
