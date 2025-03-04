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
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);

        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 词语是结尾的成分 = Tool.往后找指定词语的逻辑成分(下标, "结尾");
        if(词语是结尾的成分==null){
            return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        //获取以和结尾之间的内容
        String betweenContent = 逻辑句子.substring(结束下标, 词语是结尾的成分.getInteger(Cons.下标));
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).endsWith(betweenContent);
        Tool.赋值判断结果(逻辑成分, result);
        Tool.赋值判断结果(词语是结尾的成分, result);
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
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        //获取以和结尾之间的内容
        String betweenContent = 逻辑句子.substring(结束下标, 词语是结尾的成分.getInteger(Cons.下标));
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).startsWith(betweenContent);
        Tool.赋值判断结果(逻辑成分, result);
        Tool.赋值判断结果(词语是结尾的成分, result);
    }
}
