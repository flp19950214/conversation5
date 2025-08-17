package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 以 extends FuncAbstract {
    public 以(){
        后面能否跟内置动作=false;
    }
    @Override
    public void 功能() {
        判断句中以某某结尾();
        判断句中以某某开头();
    }
    //判断功能
    public void 判断句中以某某结尾(){
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);

        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 词语是结尾的成分 = Tool.往后找指定词语的逻辑成分(下标, "结尾");
        if(词语是结尾的成分==null){
            return;
        }
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //获取以和结尾之间的内容
        boolean result = 指定前面下标的逻辑成分.get(Cons.词语).toString().endsWith(指定下标后面的逻辑成分.get(Cons.词语).toString());
        Tool.赋值判断结果(逻辑成分, result);
    }

    //判断功能
    public void 判断句中以某某开头(){

        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 词语是结尾的成分 = Tool.往后找指定词语的逻辑成分(下标, "开头");
        if(词语是结尾的成分==null){
            return;
        }
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //获取以和结尾之间的内容
        boolean result = 指定前面下标的逻辑成分.get(Cons.词语).toString().startsWith(指定下标后面的逻辑成分.get(Cons.词语).toString());
        Tool.赋值判断结果(逻辑成分, result);
    }
}
