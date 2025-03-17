package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行相加方法 extends FuncAbstract {

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        为当前词执行相加方法();
    }
    public void 为当前词执行相加方法(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标前面的逻辑成分_无迭代 = Tool.指定下标前面的逻辑成分_无迭代(下标);
        if(指定下标前面的逻辑成分==null
        || 指定下标前面的逻辑成分_无迭代 ==null
        || !StringUtils.equals(指定下标前面的逻辑成分_无迭代.getString(Cons.词语), Cons.当前词)){
            return;
        }
        if(!指定下标前面的逻辑成分.containsKey(Cons.被加数)){
            return;
        }
        if(!指定下标前面的逻辑成分.containsKey(Cons.加数)){
            return;
        }
        double 动作结果 = Double.parseDouble(指定下标前面的逻辑成分.getString(Cons.被加数))
                + Double.parseDouble(指定下标前面的逻辑成分.getString(Cons.加数));
        指定下标前面的逻辑成分.put(Cons.动作结果, 动作结果);
    }

}
