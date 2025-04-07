package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 个 extends FuncAbstract {

    public void 功能() {
        分词();
    }

    public void 分词(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if ("字".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "词".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "成分".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "属性是".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "名词".equals(指定下标的逻辑成分.getString(Cons.词语))
        ) {
            //满足条件 合并果，创建新成分，删除旧成分
            逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
            逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
            Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
        }

    }

}
