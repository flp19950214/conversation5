package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.springframework.stereotype.Service;

@Service
public class 句子 extends FuncAbstract {
    public 句子(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Override
    public void 功能() {
        赋值代指对象();
    }

    public void 赋值代指对象(){
        //特指当前输入的句子
        逻辑成分.put(Cons.指向, 静态引用.输入的句子对象);
    }
}
