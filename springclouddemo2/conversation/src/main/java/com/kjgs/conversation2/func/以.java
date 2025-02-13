package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 以 extends FuncAbstract {
    @Override
    public void 功能() {

    }
    public void 判断句中以某某结尾(){
        if(!逻辑成分.containsKey(Cons.句型)) {
            return;
        }
        if(StringUtils.equals(Cons.假设句, 逻辑成分.getString(Cons.句型))){
            return;
        }
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);
        if(指定下标的下下一个逻辑成分 == null){
            return;
        }
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "结尾")){
            return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        if(指定下标前面的逻辑成分.getString(Cons.词语) == null
                || 指定下标后面的逻辑成分.getString(Cons.词语) == null){
            return;
        }
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).endsWith(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值指定范围的逻辑成分的判断结果(指定下标前面的逻辑成分.getInteger(Cons.句型的下标),
                指定下标前面的逻辑成分.getInteger(Cons.句型的结束下标), result);
    }
}
