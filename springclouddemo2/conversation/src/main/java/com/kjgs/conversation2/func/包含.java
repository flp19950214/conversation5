package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 包含 extends FuncAbstract {

    {
        静态引用.内置判断方法集合.add(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
    }
    @Override
    public void 功能() {
        判断句的包含动作();
        包含某个属性();
    }

    public void 包含某个属性(){
        //前面一个成分包含后面一个成分
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null){
            指定下标前面的逻辑成分 = 句子成分;
        }
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标后面的逻辑成分 == null || !指定下标后面的逻辑成分.containsKey(Cons.下标)){
            return;
        }
        Document 指定下下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        if(指定下下标后面的逻辑成分 == null
                || !StringUtils.equals(指定下下标后面的逻辑成分.getString(Cons.词语), Cons.属性)){
            return;
        }
        boolean result = 指定下标前面的逻辑成分.containsKey(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);

    }
    public void 判断句的包含动作(){
        //前面一个成分包含后面一个成分
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null || 指定下标前面的逻辑成分.getString(Cons.词语) == null){
            return;
        }
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语)
                .contains(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);

    }
}
