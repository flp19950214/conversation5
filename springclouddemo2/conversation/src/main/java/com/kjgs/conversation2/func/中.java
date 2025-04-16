package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 中 extends FuncAbstract {

    public void 功能() {
        分词_中文逗号();
        分词_中有();
        分词_中的();
    }
    public void 分词_中文逗号(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        String 词语 = "中文逗号";
        int 结束下标 =  下标+词语.length();
        if(结束下标 > 逻辑句子.length()){
            return;
        }
        String 记录成处理逻辑 = 逻辑句子.substring(下标, 结束下标);
        if (!词语.equals(记录成处理逻辑)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 记录成处理逻辑);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

    public void 分词_中有(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"有".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }
    public void 分词_中的(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"的".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }

}
