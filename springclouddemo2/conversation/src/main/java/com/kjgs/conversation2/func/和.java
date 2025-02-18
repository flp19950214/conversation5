package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 和 extends FuncAbstract {
    @Override
    public void 功能() {
        合并前后成分并指向多成分();
    }
    public void 合并前后成分并指向多成分(){
        //前面一个成分包含后面一个成分
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        Document 新逻辑成分 = new Document();
        新逻辑成分.put(Cons.词语, 指定下标前面的逻辑成分.getString(Cons.词语)
                + 逻辑成分.getString(Cons.词语) + 指定下标后面的逻辑成分.getString(Cons.词语));
        新逻辑成分.put(Cons.下标, 指定下标前面的逻辑成分.getInteger(Cons.下标));
        新逻辑成分.put(Cons.结束下标, 指定下标后面的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标前面的逻辑成分.getInteger(Cons.下标));
        Tool.删除指定下标的逻辑成分(下标);
        Tool.删除指定下标的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));

        添加指向(新逻辑成分, 指定下标前面的逻辑成分, 指定下标后面的逻辑成分);
    }

    public void 添加指向(Document 新逻辑成分, Document 指定下标前面的逻辑成分,Document 指定下标后面的逻辑成分){
        List<Document> 多成分 = new ArrayList<>();
        多成分.add(指定下标前面的逻辑成分);
        多成分.add(指定下标后面的逻辑成分);
        新逻辑成分.put(Cons.子成分, 多成分);
    }
}
