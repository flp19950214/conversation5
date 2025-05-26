package com.kjgs.conversation2.func;

import com.alibaba.fastjson2.JSON;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 转义为 extends FuncAbstract {
    public 转义为(){
        后面能否跟内置动作=false;
    }
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        前面的词指向后面的词();
    }

    public void 前面的词指向后面的词(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
       if(指定下标前面的逻辑成分 == null  || 指定下标后面的逻辑成分 == null){
           return;
       }
        Document 新成分 = Document.parse(指定下标前面的逻辑成分.toJson());
       新成分.put(Cons.词语, 指定下标后面的逻辑成分.get(Cons.词语));
       新成分.put(String.format(Cons.更新属性的处理逻辑, Cons.词语), 逻辑句子);

       指定下标前面的逻辑成分.put(Cons.指向, 新成分);
    }

}
