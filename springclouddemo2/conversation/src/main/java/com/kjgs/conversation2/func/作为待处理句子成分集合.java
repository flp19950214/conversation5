package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 作为待处理句子成分集合 extends FuncAbstract {

    @Autowired
    private Impl数据 impl数据;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        执行查询句子成分方法();
    }

    /**
     * 查询顺序
     * 1.键值对过滤
     * 2.方位
     */
    public void 执行查询句子成分方法(){
        //获取需要的茶树
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标, Cons.目标对象);
        if(指定下标前面的逻辑成分==null){
            return;
        }
        Object 获取是或者作为的值 = Tool.从归属对象中找当前词的值(指定下标前面的逻辑成分);
        if(获取是或者作为的值 instanceof List){
            静态引用.待处理句子的成分集合 = (List)获取是或者作为的值;
            逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(获取是或者作为的值));
        }
    }

}
