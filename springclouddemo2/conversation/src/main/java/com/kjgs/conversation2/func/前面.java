package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 前面 extends FuncAbstract {
    @Override
    public void 功能() {
        前面所有成分();
//        前面几个成分();
    }

    public void 前面所有成分(){
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);

        if(指定下标后面的逻辑成分 == null && 指定下标的下下一个逻辑成分 == null){
            return;
        }
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), Cons.成分)){
            return;
        }
        if(!StringUtils.equals(指定下标后面的逻辑成分.getString(Cons.词语), Cons.所有)){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标后面的逻辑成分.getString(Cons.词语)
                + 指定下标的下下一个逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标后面的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        Tool.删除指定下标的逻辑成分(指定下标的下下一个逻辑成分.getInteger(Cons.下标));
        找到前面所有成分并赋值指向(逻辑成分);
    }

    public void 前面几个成分(){
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
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "个成分")){
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

    public void 找到前面所有成分并赋值指向(Document 逻辑成分){
        List<Document> 指定范围下标的句子成分 = Tool.获取指定范围下标的句子成分(0, 句子下标);
        逻辑成分.put(Cons.指向,Tool.新建一个对象存放集合类型(指定范围下标的句子成分));
    }

    public void 找到后面某个字并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }

        Document 新句子成分 = new Document();
        StringBuffer 词语 = new StringBuffer();
        for (int i = 0; i < num ; i++) {
            词语.append(句子.substring(句子结束下标+i, 句子结束下标 + i +1));
        }
        新句子成分.put(Cons.词语, 词语.toString());
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子结束下标 + num );

        逻辑成分.put(Cons.指向,新句子成分);
    }
}
