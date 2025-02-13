package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;


public class 那就 extends FuncAbstract {
    @Override
    public void 功能() {
        到那就之间的成分赋值为假设句();
    }

    public void 到那就之间的成分赋值为假设句() {
        //1,表示判断句， 找到后面表示肯定的 赋值为肯定句，找到表示否定的 赋值为否定句
        Document 那就 = Tool.指定词语的逻辑成分("那就");
        if(那就 != null){
            int 那就下标 = 那就.getInteger(Cons.下标);
            Tool.赋值指定范围的逻辑成分的句型(下标, 那就下标, Cons.假设句);
        }else{
            Tool.赋值后面所有逻辑成分的句型(下标, Cons.假设句);
        }
    }
}
