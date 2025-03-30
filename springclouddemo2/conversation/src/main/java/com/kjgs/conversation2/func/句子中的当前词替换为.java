package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 句子中的当前词替换为 extends FuncAbstract {

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        句子中的当前词替换为();
    }
    public void 句子中的当前词替换为(){
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标后面的逻辑成分 == null){
            return;
        }
        //替换
        String before = 句子.substring(0, 句子下标);
        String cur = 指定下标后面的逻辑成分.get(Cons.词语).toString();
        String after = 句子.substring(句子结束下标);
        句子 = before+cur+after;
    }

}
