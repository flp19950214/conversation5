package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 输出 extends FuncAbstract {
    public 输出(){
        后面能否跟内置动作=false;
    }
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        输出下一个成分();
    }

    public void 输出下一个成分(){
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if( 指定后面下标的逻辑成分 == null){
           return;
        }
        Object result = Tool.往后找归属对象的属性值(下标, 指定后面下标的逻辑成分);
        String 归属对象的键名 = Tool.往后找归属对象的属性值的键名(下标, 指定后面下标的逻辑成分);
        if(result!=null){
            句子成分.put(Cons.指向, Tool.生成动作结果指向对象(result));
            静态引用.输出内容 = result.toString();

            //获取处理过程
            Document 获取属性的处理过程 = Tool.获取属性的处理过程(指定后面下标的逻辑成分, 归属对象的键名);
            //结构：动作名+"结果"+"参数名"+":"+"参数值"
            StringBuilder sb = new StringBuilder();
            sb.append("'输出'的结果是{");
            sb.append(result.toString()).append("的").append(归属对象的键名).append("=").append(result.toString());
            sb.append("}");
            Document 处理过程 = new Document();
            if(获取属性的处理过程!=null){
                处理过程.put("输出的结果的来源", 获取属性的处理过程);
            }
            处理过程.put("输出的结果", sb.toString());
            String 添加更新逻辑内容 = Tool.添加更新逻辑内容(句子成分, Cons.指向, 逻辑句子, 处理过程);
            if(添加更新逻辑内容 != null){
                句子成分.put(Cons.是否是输出动作, 添加更新逻辑内容);
            }
        }else{
            静态引用.输出内容 = "";
        }
    }


}
