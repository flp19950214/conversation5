package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 之间的内容 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        获取并列集合之间的成分并赋值指向();
    }

    public void 获取并列集合之间的成分并赋值指向(){
        Document 新句子成分 = 获取并列集合之间的成分();
        if(新句子成分==null){
            return;
        }
        逻辑成分.put(Cons.指向, 新句子成分);
    }

    public Document 获取并列集合之间的成分(){
        Document 指定下标前面的包含并列集合的逻辑成分 = Tool.指定下标前面包含某key的逻辑成分(下标, Cons.并列集合);
        if(!指定下标前面的包含并列集合的逻辑成分.containsKey(Cons.并列集合)){
            return null;
        }
        List<Document> 并列集合 = 指定下标前面的包含并列集合的逻辑成分.get(Cons.并列集合, List.class);
        Tool.刷新集合中代词的最终指向(并列集合);
        if(CollectionUtils.isEmpty(并列集合) || 并列集合.size()<2){
            return null;
        }
        //这里合并的是句子成分 所有并列集合的对象也要是句子成分
        Document document1 = 并列集合.get(0);
        Document document2 = 并列集合.get(1);
        if(!document1.containsKey(Cons.是否是句子成分) || !document2.containsKey(Cons.是否是句子成分)){
            return null;
        }
        if(document1.getBoolean(Cons.是否是句子成分) == false || document2.getBoolean(Cons.是否是句子成分) ==false){
            return null;
        }
        int startIndex = document1.getInteger(Cons.下标);
        int endIndex = document1.getInteger(Cons.下标);
        if(startIndex>endIndex){
            int temp = startIndex;
            startIndex=endIndex;
            endIndex=temp;
        }
        String 词语 = 句子.substring(startIndex,endIndex);
        //合并之间的词语 新句子成分
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, 词语);
        新句子成分.put(Cons.下标, startIndex);
        新句子成分.put(Cons.结束下标, endIndex);
        新句子成分.put(Cons.是否是句子成分, true);
        return 新句子成分;
    }

}
