package com.kjgs.conversation2.method;

import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.给输入的句子生成内置格式化逻辑;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class 生成句子成分归属逻辑 {

    @Autowired
    private 给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    /**
     * 根据以后的句子成分集合
     * 从词性、词语、句型的维度生成句子的归属逻辑
     */
    public void method(List<Document> 成分集合) {
        List<Document> 获取干净的句子成分 = Tool.获取干净的句子成分(成分集合);
        找到句子间成分的归属逻辑关系(获取干净的句子成分);
    }



    public void 找到句子间成分的归属逻辑关系(List<Document> 成分集合) {
        //依次找每个成分的属性是否是对象，如果是，再判断对象id是否是当前句子的哪个成分id
        List<String> objectIdList = 成分集合.stream().map(m -> m.getObjectId(Cons._id).toString()).collect(Collectors.toList());
        for (Document document : 成分集合) {
            for (Map.Entry entry : document.entrySet()) {
                if (!(entry.getValue() instanceof Document)) {
                    continue;
                }
                Document document1 = (Document) entry.getValue();
                String objectId = document1.getObjectId(Cons._id).toString();
                if (objectIdList.contains(objectId)) {
                    //满足 形成逻辑
                    String 词语 = Tool.优先获取词性(document);
                    String 句子词性组成 = Tool.获取句子词性组成(成分集合);
                    String 给对象添加属性的键 = entry.getKey().toString();

                    //判断向前 还是向后 根据id
                    int index1 = document.getInteger(Cons.下标);
                    int index2 = document1.getInteger(Cons.下标);
                    String 前或后面第某个成分=null;
                    if (index1 < index2) {
                        int 两个成分的相间的个数 = 计算两个成分的相间的个数(成分集合, document, document1);
                        前或后面第某个成分 = String.format("后面第%s个成分", 两个成分的相间的个数);
                    }else if(index1 > index2){
                        int 两个成分的相间的个数 = 计算两个成分的相间的个数(成分集合, document1, document);
                        前或后面第某个成分 = String.format("前面第%s个成分", 两个成分的相间的个数);
                    }
                    if(StringUtils.isEmpty(前或后面第某个成分)){
                        continue;
                    }
                    String 逻辑 = String.format(Cons.归属逻辑format,词语, 句子词性组成, 给对象添加属性的键, 前或后面第某个成分);
                    System.out.println("生成逻辑：" + 逻辑);
                    impl给输入的句子生成内置格式化逻辑.保持并刷新逻辑(逻辑);
                }
            }
        }
    }


    public int 计算两个成分的相间的个数(List<Document> 成分集合, Document start, Document end) {
        String objectId1 = start.getObjectId(Cons._id).toString();
        String objectId2 = end.getObjectId(Cons._id).toString();
        for (int i = 0; i < 成分集合.size(); i++) {
            Document document1 = 成分集合.get(i);
            String objectId11 = document1.getObjectId(Cons._id).toString();
            if (!StringUtils.equals(objectId1, objectId11)) {
                continue;
            }
            for (int j = i + 1; j < 成分集合.size(); j++) {
                Document document2 = 成分集合.get(j);
                String objectId22 = document2.getObjectId(Cons._id).toString();
                if (!StringUtils.equals(objectId2, objectId22)) {
                    continue;
                }
                return j - i;
            }
        }
        return 0;
    }
}
