package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class 后面某个字 extends FuncAbstract {
    public 后面某个字() {
        后面能否跟内置动作 = true;
        执行层级 = 1;
    }

    @Autowired
    Impl逻辑 impl逻辑;

    @PostConstruct
    public void init() {
    }

    /**
     * 分词后直接干活
     */
    @Override
    public void 功能() {
        Integer 量词 = Tool.转数字(StringUtils.substringBetween(逻辑词语, "后面", "个字"));
        if(量词 == null){
            return;
        }
        找到后面某个字并赋值指向(逻辑成分, 量词);
    }

    //就一个字符
    public void 找到后面某个字并赋值指向(Document 逻辑成分, int num) {
        if (句子下标 + num + 1 > 句子.length()) {
            return;
        }
        Document 新句子成分 = new Document();
        StringBuffer 词语 = new StringBuffer();
        for (int i = 0; i < num; i++) {
            if (句子结束下标 + i + 1 > 句子.length()) {
                return;
            }
            词语.append(句子.substring(句子结束下标 + i, 句子结束下标 + i + 1));
        }
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, 词语.toString());
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子结束下标 + num);
        新句子成分.put(Cons.是否是句子成分, true);
        逻辑成分.put(Cons.指向, 新句子成分);
    }

}
