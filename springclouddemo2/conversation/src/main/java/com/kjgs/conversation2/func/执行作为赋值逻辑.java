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
public class 执行作为赋值逻辑 extends FuncAbstract {

    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        给待处理对象赋值();
    }

    public void 给待处理对象赋值(){
        Document 指定前面下标的成分 = Tool.指定下标前面的待处理句子成分(下标);
        Document 指定后面下标的成分 = Tool.指定下标后面的待处理句子成分(下标);
        if(指定前面下标的成分 == null || 指定后面下标的成分 == null){
            return;
        }
        Object 属性值 = Tool.获取是或者作为的值(指定前面下标的成分);
        if(指定前面下标的成分.containsKey(Cons.归属对象) && 属性值 instanceof String){
            属性值 = Tool.最终的归属对象(指定前面下标的成分).get(属性值);
        }
        Document 属性对象 = Tool.往后找归属对象(下标, 指定后面下标的成分);
        String 属性;
        if(属性对象!=null){
            属性 = 属性对象.getString(Cons.词语);
            指定后面下标的成分.put(属性, 属性值);
        }else{
            属性=Cons.指向;
            指定后面下标的成分.put(Cons.指向, Tool.生成动作结果指向对象(属性值));
        }


        //获取处理过程
        //结构：动作名+"结果"+"参数名"+":"+"参数值"
        StringBuilder sb = new StringBuilder();
        sb.append("'执行作为赋值逻辑'给待处理对象属性赋值的结果是{");
        sb.append("赋值").append(属性).append("=").append(属性值);
        sb.append("}");
        Document 处理过程 = new Document();
        处理过程.put("输出的结果", sb.toString());
        Tool.添加更新逻辑内容(指定后面下标的成分, 属性,逻辑句子, 处理过程);
    }

}
