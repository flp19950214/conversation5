package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行从数据库中查询句子成分方法 extends FuncAbstract {
    public 执行从数据库中查询句子成分方法(){
        后面能否跟内置动作=true;
    }
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
        执行查询数据库方法();
    }
    public void 执行查询数据库方法(){
        //获取需要的茶树
        Document 查询的值 = Tool.指定下标前面的逻辑成分(下标, "查询的句子");
        if(查询的值 == null){
            return;
        }
        if(Tool.获取是或者作为的值(查询的值) == null){
            return;
        }
        List<Document> 查询的结果 = impl数据.根据键值对查询(Cons.成分所在的句子,
                Tool.获取是或者作为的值(查询的值),  null);
        逻辑成分.put("查询数据库的结果", 查询的结果);
        逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(查询的结果));
    }

}
