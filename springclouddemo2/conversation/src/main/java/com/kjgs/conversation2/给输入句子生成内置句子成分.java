package com.kjgs.conversation2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class 给输入句子生成内置句子成分 {

    @Autowired
    Impl逻辑 impl逻辑;

    public void 生成内置句子成分(String 句子){
        //是判断句就行了
        Document 输入的句子对象 = 静态引用.输入的句子对象;
        if(输入的句子对象 != null &&
                输入的句子对象.containsKey(Cons.句型)
                && StringUtils.equals(输入的句子对象.getString(Cons.句型), Cons.假设句)){
            impl逻辑.保存逻辑(句子);
        }
    }

    public static List<Document> 生成内置句子成分2(String 句子){
        List<Document> result = new ArrayList<>();
        for (String m:静态引用.内置词语集合) {
            if(!句子.contains(m)) {
                continue;
            }
            int i = StringUtils.indexOf(句子, m);
            String tmp句子 = 句子;
            while (i != -1){
                Document 成分对象 = Tool.生成成分对象(m,i,m.length());
                静态引用.输入句子的成分集合.add(成分对象);
                result.add(成分对象);
                tmp句子 = StringUtils.substring(tmp句子, i);
                i = StringUtils.indexOf(tmp句子, m);
            }
        }
        return result;
    }
}
