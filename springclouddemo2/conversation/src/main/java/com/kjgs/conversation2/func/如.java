package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 如 extends FuncAbstract {

    public void 功能() {

    }

    public void 以如开头并且下一个词是果() {
        if (下标 != 0) {
            return;
        }
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"果".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件
        //1,表示判断句
        //2,合并果，创建新成分，删除旧成分
        //3,
    }
}
