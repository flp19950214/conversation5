package com.kjgs.conversation2.func;

import com.alibaba.fastjson2.JSON;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 空格 extends FuncAbstract {
    public 空格(){
        后面能否跟内置动作=true;
        执行层级=1;
    }

    @Override
    public void 功能() {
        转义空格();
    }

    public void 转义空格(){
        if(StringUtils.equals(" ", 句子词语)){
            Document 新成分 = Document.parse(句子成分.toJson());
            新成分.put(Cons.词语, Cons.空格);
            句子成分.put(Cons.指向, 新成分);

        }
    }
}
