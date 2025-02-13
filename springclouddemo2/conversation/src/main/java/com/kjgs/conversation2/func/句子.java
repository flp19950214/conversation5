package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;

public class 句子 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    public void 赋值代指对象(){
        //特指当前输入的句子
        逻辑成分.put(Cons.指向id, 静态引用.输入的句子对象.get(Cons._id));
    }
}
