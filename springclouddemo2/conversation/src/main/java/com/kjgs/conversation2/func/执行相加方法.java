package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行相加方法 extends FuncAbstract {
    public 执行相加方法(){
        后面能否跟内置动作=false;
    }
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
        if(!句子成分.containsKey(Cons.被加数)){
            return;
        }
        if(!句子成分.containsKey(Cons.加数)){
            return;
        }
        double 动作结果 = Double.parseDouble(句子成分.getString(Cons.被加数))
                + Double.parseDouble(句子成分.getString(Cons.加数));
        句子成分.put(Cons.指向, Tool.生成动作结果指向对象(动作结果));
        Tool.添加更新逻辑内容(句子成分,Cons.指向, 逻辑句子);
    }

}
