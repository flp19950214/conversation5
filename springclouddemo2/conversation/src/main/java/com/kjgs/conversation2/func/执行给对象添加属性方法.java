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
public class 执行给对象添加属性方法 extends FuncAbstract {
    public 执行给对象添加属性方法(){
        后面能否跟内置动作=false;
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
        Document 指定下标前面的逻辑成分_无迭代 = Tool.指定下标前面的逻辑成分_无迭代(下标, "给添加属性的对象");
        if(!指定下标前面的逻辑成分_无迭代.containsKey(Cons.指向)){
            return;
        }
        Document 添加对象 = Tool.指定下标前面的逻辑成分(下标, "给添加属性的对象");
        Document 属性的键 = Tool.指定下标前面的逻辑成分(下标, "给对象添加属性的键");
        Document 属性的值 = Tool.指定下标前面的逻辑成分(下标, "给对象添加属性的值");
        if(添加对象 == null || 属性的键 == null || 属性的值==null){
            return;
        }
        if(Tool.获取是或者作为的值(属性的键) == null || Tool.获取是或者作为的值(属性的值) == null){
            return;
        }
        if(!(Tool.获取是或者作为的值(添加对象) instanceof Document)){
            return;
        }
        添加对象 = (Document) Tool.获取是或者作为的值(添加对象);
        Tool.添加更新逻辑内容(添加对象, 逻辑句子);
        添加对象.put(Tool.获取是或者作为的值(属性的键).toString(), Tool.获取是或者作为的值(属性的值));
    }

}
