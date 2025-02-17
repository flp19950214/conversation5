package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 并且 extends FuncAbstract {
    @Override
    public void 功能() {
        对前面一个成分和后面一个成分取并();
    }

    public void 对前面一个成分和后面一个成分取并(){
        //前面一个成分包含后面一个成分
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        if(指定下标前面的逻辑成分.getBoolean(Cons.判断的结果) == null
                || 指定下标后面的逻辑成分.getBoolean(Cons.判断的结果) == null){
            return;
        }
        if(指定下标前面的逻辑成分.getBoolean(Cons.句型的下标) == null
                || 指定下标后面的逻辑成分.getBoolean(Cons.句型的结束下标) == null){
            return;
        }
        boolean result = 指定下标前面的逻辑成分.getBoolean(Cons.判断的结果) && 指定下标后面的逻辑成分.getBoolean(Cons.判断的结果);
        Tool.赋值指定范围的逻辑成分的判断结果(指定下标前面的逻辑成分.getInteger(Cons.句型的下标),
                    指定下标后面的逻辑成分.getInteger(Cons.句型的结束下标), result);

    }
}
