package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 是 extends FuncAbstract {
    @Override
    public void 功能() {
        判断句的包含动作();
    }

    public void 判断句的包含动作(){
        // 是判断句
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //前面一个成分等于后面一个成分
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).equals(指定下标后面的逻辑成分.getString(Cons.词语));
//        if(result==false){
//            if(结束下标+指定下标前面的逻辑成分.getString(Cons.词语).length()<=逻辑句子.length()){
//                String 跟句子词语长度相同 = 逻辑句子.substring(结束下标, 结束下标+指定下标前面的逻辑成分.getString(Cons.词语).length());
//                result = StringUtils.equals(指定下标前面的逻辑成分.getString(Cons.词语), 跟句子词语长度相同);
//            }
//        }
        Tool.赋值判断结果(逻辑成分, result);
    }
}
