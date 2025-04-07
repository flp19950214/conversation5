package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 后面第 extends FuncAbstract {
    @Override
    public void 功能() {
        后面第几个名词();
    }

    public void 后面第几个名词(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null || 指定下标的下下一个逻辑成分==null){
            return;
        }
        if(StringUtils.isEmpty(指定下标后面的逻辑成分.getString(Cons.词语)) ||
                !指定下标后面的逻辑成分.getString(Cons.词语).matches("-?\\d+(\\.\\d+)?")){
            return;
        }
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "个名词")){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标后面的逻辑成分.getString(Cons.词语)
                + 指定下标的下下一个逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的下下一个逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        Tool.删除指定下标的逻辑成分(指定下标的下下一个逻辑成分.getInteger(Cons.下标));
        int 量词 = Integer.parseInt(指定下标后面的逻辑成分.getString(Cons.词语));

        找到后面1个名词并赋值指向(逻辑成分, 量词);
    }

    public void 找到后面1个名词并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标后面一个句子成分(句子下标, Cons.名词);
        if(新句子成分 != null){
            逻辑成分.put(Cons.指向,新句子成分);
        }
    }

}
