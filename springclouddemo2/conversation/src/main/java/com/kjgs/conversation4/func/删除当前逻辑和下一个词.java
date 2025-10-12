package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 删除当前逻辑和下一个词 extends FuncAbstract4 {

    @Override
    public void method()  throws Exception  {
        int 结束下标 = 当前逻辑.getInteger(Cons.结束下标);
        List<Document> list = 输入词语对象.get(Cons.逻辑集合, List.class);
        Document 下一个词 = Tool.倒叙下一个词(list, 结束下标);
        if (下一个词 != null) {
            list.remove(下一个词);
            list.remove(当前逻辑);
            Tool.printLog(String.format("删除当前逻辑和下一个词 的 当前逻辑 是：%s", 当前逻辑.get(Cons.逻辑名)));
            Tool.printLog(String.format("删除当前逻辑和下一个词 的 下一个词是 是：%s", 下一个词.get(Cons.逻辑名)));
        }
    }
}
