package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 加 extends FuncAbstract {

    public void 功能() {
        分词_加数();
        给属性加量();
    }

    public void 给属性加量(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        if(!指定下标前面的逻辑成分.containsKey(Cons.归属对象)){
            return;
        }
        Document 最终的归属对象 = Tool.最终的归属对象(指定下标前面的逻辑成分);
        if(最终的归属对象 == null){
            return;
        }
        String 属性 = 指定下标前面的逻辑成分.getString(Cons.词语);
        Object 属性值 = 最终的归属对象.get(属性);
        Integer 被加数 = Tool.转数字(属性值);
        Integer 加数 = Tool.转数字(指定下标后面的逻辑成分.get(Cons.词语));
        if(被加数 == null){
            被加数 = 0;
        }
        if(加数 == null){
            加数 = 0;
        }

        if(Tool.判断一个逻辑是否已经操作过某个增量方法(句子成分, 逻辑成分, "加", 属性)){
            return;
        }
        最终的归属对象.put(指定下标前面的逻辑成分.get(Cons.词语)+"", 加数 + 被加数);
        Document 属性的执行记录对象 = Tool.记录增量方法操作记录(逻辑成分, "加", 属性);
        句子成分.put(属性+Cons.的+Cons.执行记录, 属性的执行记录对象);
    }

    public void 分词_加数(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+2;
        if(结束下标 > 逻辑句子.length()){
            return;
        }
        String 记录成处理逻辑 = 逻辑句子.substring(下标, 结束下标);
        if (!"加数".equals(记录成处理逻辑)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 记录成处理逻辑);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }
}
