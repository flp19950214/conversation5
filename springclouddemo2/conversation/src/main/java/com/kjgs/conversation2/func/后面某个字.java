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
        List<Document> 指定下标的逻辑成分 = Tool.指定下标的句子成分(句子结束下标);
        //获取其中长度是1的
        Document result = 指定下标的逻辑成分.stream().filter(m -> m.containsKey(Cons.词语)
                && m.getString(Cons.词语).length() == 1).findFirst().orElse(null);
        if(result==null){
            return;
        }
        逻辑成分.put(Cons.指向, result);
    }

}
