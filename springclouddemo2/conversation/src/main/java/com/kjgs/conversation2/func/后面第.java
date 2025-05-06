package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class 后面第 extends FuncAbstract {
    public 后面第(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
    }

    /**
     * 分词后直接干活
     */
    @Override
    public void 功能() {
        Document 后面一个成分 = Tool.指定下标后面的逻辑成分_无迭代(下标);
        Document 再后面一个成分 = Tool.指定下标后面的逻辑成分_无迭代(Tool.指定下标后面的逻辑成分_无迭代(下标).getInteger(Cons.下标));
        String 后面一个词语 = "";
        String 再后面一个词语 = "";
        if(后面一个成分!=null){
            后面一个词语=后面一个成分.getString(Cons.词语);
        }
        if(再后面一个成分!=null){
            再后面一个词语=再后面一个成分.getString(Cons.词语);
        }
        String method = "后面第"+后面一个词语+再后面一个词语;
        if(StringUtils.equals(再后面一个词语, "个名词")){
            //满足条件 合并果，创建新成分，删除旧成分
            int 结束下标 = 下标+method.length();
            逻辑成分.put(Cons.词语, method);
            逻辑成分.put(Cons.结束下标, 结束下标);
            int 量词 = Tool.转数字(StringUtils.substringBetween(method, "后面第","个名词"));
            Tool.删除指定下标的逻辑成分(后面一个成分.getInteger(Cons.下标));
            Tool.删除指定下标的逻辑成分(再后面一个成分.getInteger(Cons.下标));
            找到后面1个名词并赋值指向(逻辑成分, 量词);
        }
    }
    public void 找到后面1个名词并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标后面一个句子成分(句子下标, Cons.名词);
        if(新句子成分 != null){
            逻辑成分.put(Cons.指向,新句子成分);
        }
    }
}
