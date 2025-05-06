package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 那就 extends FuncAbstract {
    public 那就(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Override
    public void 功能() {
        到那就之间的成分赋值为假设句();
    }

    public void 到那就之间的成分赋值为假设句() {
        //1,表示判断句， 找到后面表示肯定的 赋值为肯定句，找到表示否定的 赋值为否定句
        Tool.赋值句型(逻辑成分, Cons.陈述句);
        静态引用.是否是陈述部分逻辑=true;
    }
}
