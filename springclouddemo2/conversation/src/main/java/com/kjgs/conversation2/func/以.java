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
        判断句中以某某结尾();
        判断句中以某某开头();
    }
    //判断功能
    public void 判断句中以某某结尾(){
        if(!逻辑成分.containsKey(Cons.句型)) {
            return;
        }
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
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
        Tool.赋值判断结果(逻辑成分, result);
    }

    //判断功能
    public void 判断句中以某某开头(){
        if(!逻辑成分.containsKey(Cons.句型)) {
            return;
        }
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);
        if(指定下标的下下一个逻辑成分 == null){
            return;
        }
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "开头")){
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
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).startsWith(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
    }
}
