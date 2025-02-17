package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 后面 extends FuncAbstract {
    @Override
    public void 功能() {
        后面几个字();
    }

    public void 后面几个字(){
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
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "个字")){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标后面的逻辑成分.getString(Cons.词语)
        + 指定下标的下下一个逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的下下一个逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        Tool.删除指定下标的逻辑成分(指定下标的下下一个逻辑成分.getInteger(Cons.下标));
        int 量词 = Integer.parseInt(指定下标后面的逻辑成分.getString(Cons.词语));

        找到后面某个字并赋值指向(逻辑成分, 量词);
    }

    public void 找到后面某个字并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num > 句子.length()){
            return;
        }
        String substring = 句子.substring(句子下标, 句子下标 + num);
        Document 新句子成分 = new Document();
        新句子成分.put(Cons.词语, substring);
        新句子成分.put(Cons.下标, 句子下标);
        新句子成分.put(Cons.结束下标, 句子下标 + num);
        静态引用.输入句子的成分集合.add(新句子成分);

        逻辑成分.put(Cons.指向,新句子成分);
    }
}
