package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 遇到 extends FuncAbstract {
    @Override
    public void 功能() {
        当前处理成分是遇到的后面一个成分();
    }

    public void 当前处理成分是遇到的后面一个成分(){
        //前面一个成分包含后面一个成分
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标后面的逻辑成分 == null){
            return;
        }
        if(指定下标后面的逻辑成分.getBoolean(Cons.句型的结束下标) == null){
            return;
        }
        boolean result = StringUtils.equals(句子词语, 指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值指定范围的逻辑成分的判断结果(0,
                指定下标后面的逻辑成分.getInteger(Cons.句型的结束下标), result);
    }
}
