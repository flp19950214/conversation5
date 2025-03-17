package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 有 extends FuncAbstract {
    @Override
    public void 功能() {
        前面一个成分词语包含后面一个成分词语();
        前面成分有什么属性();
    }

    public void 前面一个成分词语包含后面一个成分词语(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语)
                .contains(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
    }

    public void 前面成分有什么属性(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null
        || 指定下标的下下一个逻辑成分 == null){
            return;
        }
        if(!指定下标的下下一个逻辑成分.containsKey(Cons.属性)){
            return;
        }
        boolean result = false;
        if(Tool.对象是否是集合类型(指定下标前面的逻辑成分)){
            result = Tool.判断集合对象中是否包含某属性(指定下标前面的逻辑成分.get(Cons.集合类型, List.class)
                    ,指定下标后面的逻辑成分.getString(Cons.词语));
        }else{
            result = 指定下标前面的逻辑成分.containsKey(指定下标后面的逻辑成分.getString(Cons.词语));
        }
        Tool.赋值判断结果(逻辑成分, result);
    }
}
