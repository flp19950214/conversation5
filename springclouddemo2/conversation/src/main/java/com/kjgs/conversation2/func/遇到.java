package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.IngoreException;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 遇到 extends FuncAbstract {
    public 遇到(){
        后面能否跟内置动作=false;
    }
    @Override
    public void 功能() throws IngoreException {
        当前处理成分是遇到的后面一个成分();
    }

    public void 当前处理成分是遇到的后面一个成分() throws IngoreException {
        //前面一个成分包含后面一个成分
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分_无迭代(下标);
        if(指定下标后面的逻辑成分 == null){
            return;
        }
        //额外判断词性和属于的值
        boolean result =
                (StringUtils.equals(句子词语, 指定下标后面的逻辑成分.getString(Cons.词语))
                || StringUtils.equals(句子成分.getString(Cons.词性), 指定下标后面的逻辑成分.getString(Cons.词语))
                || StringUtils.equals(句子成分.getString(Cons.属于), 指定下标后面的逻辑成分.getString(Cons.词语))
                );
        Tool.赋值判断结果(逻辑成分, result);
        if(result == false){
            throw new IngoreException("不满足条件");
        }
    }
}
