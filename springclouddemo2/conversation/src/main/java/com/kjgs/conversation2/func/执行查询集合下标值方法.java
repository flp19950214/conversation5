package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查询;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询集合下标值方法 extends FuncAbstract {
    public 执行查询集合下标值方法(){
        后面能否跟内置动作=false;
    }
    @Autowired
    private Tool查询 tool查询;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        执行查询名词指向方法();
    }
    public void 执行查询名词指向方法(){
        Document 查询的集合 = Tool.指定下标前面的逻辑成分(下标, "查询的集合");
        Document 查询的集合下标 = Tool.指定下标前面的逻辑成分(下标, "查询集合的下标");
        if (查询的集合 == null || 查询的集合下标==null){
            return;
        }
        if(Tool.获取是或者作为的值(查询的集合下标)==null || Tool.获取是或者作为的值(查询的集合) == null){
            return;
        }
        Object 是或者作为的值 = Tool.获取是或者作为的值(查询的集合下标);
        if(是或者作为的值==null){
            return;
        }
        Integer 下标 = Tool.转数字(Tool.获取是或者作为的值(查询的集合下标));
        if(!(Tool.获取是或者作为的值(查询的集合) instanceof List)){
            return;
        }
        List 集合 = (List)Tool.获取是或者作为的值(查询的集合);
        if(集合.size()<= 下标){
            return;
        }
        Object 查询集合下标值的结果 = 集合.get(下标);
        逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(查询集合下标值的结果));
    }

}
