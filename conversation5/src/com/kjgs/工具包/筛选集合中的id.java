package com.kjgs.工具包;

import com.alibaba.fastjson.JSONArray;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 筛选集合中的id {
    public static List<String> method(List<Document> jsonArray){
        if(CollectionUtils.isEmpty(jsonArray)){
            return null;
        }
        List<String> resultArr = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            resultArr.add(jsonArray.get(i).getString(Cons._id));
        }
        resultArr = resultArr.stream().distinct().collect(Collectors.toList());
        return resultArr;
    }
}
