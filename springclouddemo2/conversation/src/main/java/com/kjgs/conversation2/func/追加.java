package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 追加 extends FuncAbstract {
    @Override
    public void 功能() {
        前面成分追加后面成分();
    }

    public void 前面成分追加后面成分(){
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null){
            return;
        }
        StringBuilder sb =new StringBuilder();
        //前面的属性值
        Object 前面 = Tool.获取前面的属性值(指定前面下标的逻辑成分);
        if(前面!= null){
            sb.append(前面.toString());
        }
        //后面的属性值
        Object 后面 = Tool.获取后面的属性值(下标,指定后面下标的逻辑成分);
        if(后面!= null){
            sb.append(后面.toString());
        }
        //赋值
        Object 属性值 = 指定前面下标的逻辑成分.getString(Cons.词语);
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            Document 最终的归属对象 = Tool.最终的归属对象(指定前面下标的逻辑成分);
            最终的归属对象.put(属性值.toString(), sb.toString());
        }else{
            指定前面下标的逻辑成分.put(Cons.词语, sb.toString());
        }
    }
}
