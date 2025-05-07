package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 记录成处理逻辑 extends FuncAbstract {
    public 记录成处理逻辑(){
        后面能否跟内置动作=false;
    }
    //碰撞形成内置逻辑
    public static void 能否形成内置逻辑(List<Document> 成分集合){
        //必须包含如果
        //必须包含那就
        //遇到后面支持一个非内置词语
        //输出后面支持一个非内置词语
        //如果遇到说，那就标记当前词的相似词为输出
    }

    public static void main(String[] args) {
        记录成处理逻辑 obj = new 记录成处理逻辑();
        String 句子 = "如果遇到你好，那就说你也好";
        List<Document> 成分集合 = new ArrayList<>();
        Document document = new Document();
        document.put(Cons.词语, "如");
        document.put(Cons.下标, 0);
        document.put(Cons.结束下标, 1);
        Document document1 = new Document();
        document1.put(Cons.词语, "如果");
        document1.put(Cons.下标, 0);
        document1.put(Cons.结束下标, 2);
        Document document2 = new Document();
        document2.put(Cons.词语, "到");
        document2.put(Cons.下标, 3);
        document2.put(Cons.结束下标, 4);
        Document document3 = new Document();
        document3.put(Cons.词语, "遇到");
        document3.put(Cons.下标, 2);
        document3.put(Cons.结束下标, 4);
        Document document4 = new Document();
        document4.put(Cons.词语, "你好");
        document4.put(Cons.下标, 5);
        document4.put(Cons.结束下标, 7);
        Document document5 = new Document();
        document5.put(Cons.词语, "，");
        document5.put(Cons.下标, 7);
        document5.put(Cons.结束下标, 8);
        Document document6 = new Document();
        document6.put(Cons.词语, "那就");
        document6.put(Cons.下标, 8);
        document6.put(Cons.结束下标, 10);
        Document document7 = new Document();
        document7.put(Cons.词语, "说");
        document7.put(Cons.下标, 10);
        document7.put(Cons.结束下标, 11);
        Document document8 = new Document();
        document8.put(Cons.词语, "你也好");
        document8.put(Cons.下标, 11);
        document8.put(Cons.结束下标, 14);
//        Document document9 = new Document();
//        document9.put(Cons.词语, "如");
//        document9.put(Cons.下标, 0);
//        document9.put(Cons.结束下标, 0);
//        Document document = new Document();
//        document.put(Cons.词语, "如");
//        document.put(Cons.下标, 0);
//        document.put(Cons.结束下标, 0);
        成分集合.add(document);
        成分集合.add(document1);
        成分集合.add(document2);
        成分集合.add(document3);
        成分集合.add(document4);
        成分集合.add(document5);
        成分集合.add(document6);
        成分集合.add(document7);
        成分集合.add(document8);
        obj.能否形成处理逻辑(句子, 成分集合);
    }

    public void 能否形成处理逻辑(String 句子, List<Document> 成分集合){
        //判断是否是内置逻辑
        for (String m: 静态引用.内置词语集合){
            int i = StringUtils.indexOf(句子, m);
            if(i > 0){
                Document document = new Document();
                document.put(Cons.词语, m);
                document.put(Cons.下标, i);
                document.put(Cons.结束下标, i+m.length());

            }
        }
    }

    @Autowired
    private Impl逻辑 逻辑impl;

    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        找到前面一个成分保存成逻辑();
    }

    public void 找到前面一个成分保存成逻辑(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
           return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null){
            return;
        }
        if(StringUtils.isEmpty(指定下标前面的逻辑成分.getString(Cons.词语))){
            return;
        }
        逻辑impl.保存逻辑(指定下标前面的逻辑成分.getString(Cons.词语));
    }
}
