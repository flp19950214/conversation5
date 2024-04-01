package com.kjgs.常用工具;

import java.util.ArrayList;
import java.util.List;

public class 获取词语在句子中的所有位置 {
    public static List<Integer> 词语在句子中的所有位置(String 句子,String 词语){
        List<Integer> indexs = new ArrayList<>();
        int index = 句子.indexOf(词语);
        while (index != -1){
            indexs.add(index);
            index = 句子.indexOf(词语, index+1);
        }
        return indexs;
    }
}
