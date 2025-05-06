package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.springframework.stereotype.Service;

@Service
public class 如果  extends FuncAbstract {
    public 如果(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Override
    public void 功能() {
        赋值后面所有逻辑成分的句型();
    }

    public void 赋值后面所有逻辑成分的句型() {
        if (下标 == 0) {
            Tool.赋值句型(逻辑成分, Cons.假设句);
            静态引用.是否是陈述部分逻辑=false;
        }
    }
}
