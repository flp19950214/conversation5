package com.kjgs.算法;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class 组装句子中由词性组成的句子Service {
    @Test
    public void test() {
        组装句子中由词性组成的句子Service obj = new 组装句子中由词性组成的句子Service();
        Map<String, List<String>> 词语词性集合 = new HashMap<>();
//        词语词性集合.put("1",Arrays.asList(new String[]{"数字"}));
//        词语词性集合.put("1",Arrays.asList(new String[]{"数字"}));
//        词语词性集合.put("1",Arrays.asList(new String[]{"数字"}));
//        obj.组装句子中由词性组成的句子("111", 词语词性集合);

        // test2
        词语词性集合.put("1",Arrays.asList(new String[]{"数字"}));
        词语词性集合.put("11",Arrays.asList(new String[]{"数字"}));
        词语词性集合.put("111",Arrays.asList(new String[]{"数字"}));
        obj.组装句子中由词性组成的句子("111", 词语词性集合);
        System.out.println(res);
    }

    public void 组装句子中由词性组成的句子(String 句子, Map<String, List<String>> 词语词性集合) {
        Set<String> result = new HashSet<>();
        sub(句子, 词语词性集合, 0,  result);
    }
    public static List<String> res = new ArrayList<>();
    public void sub(String 句子, Map<String, List<String>> 词语词性集合, int index,Set<String> 词性句子集合) {
        if(index>=句子.length()){
            res.addAll(词性句子集合);
            return;
        }
        String sub句子 = 句子.substring(index);
        for (Map.Entry<String, List<String>> entry : 词语词性集合.entrySet()){
            Set<String> 新逻辑集合2 = new HashSet<>();
            if(sub句子.startsWith(entry.getKey())){
                entry.getValue().stream()
                        .forEach(k -> {
                            if(!CollectionUtils.isEmpty(词性句子集合)){
                                for(String 词性句子:词性句子集合){
                                    String 新逻辑 = String.format("%s|%s", 词性句子, k);
                                    新逻辑集合2.add(新逻辑);
                                }
                            }else{
                                新逻辑集合2.add(k);
                            }
                        });
                sub(句子, 词语词性集合, index+entry.getKey().length(),新逻辑集合2);
            }else{
                if(!CollectionUtils.isEmpty(词性句子集合)){
                    for(String 词性句子:词性句子集合){
                        String 新逻辑 = String.format("%s|%s", 词性句子, 句子.substring(index,index+1));
                        新逻辑集合2.add(新逻辑);
                    }
                }else{
                    新逻辑集合2.add(句子.substring(index,index+1));
                }
                sub(句子, 词语词性集合, index+1,新逻辑集合2);
            }
        }
    }

}
