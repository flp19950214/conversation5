package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 获取下一个词 extends FuncAbstract4 {

    @Override
    public void method()  throws Exception  {
        int 结束下标 = 当前逻辑.getInteger(Cons.结束下标);
        List<Document> list = 输入词语对象.get(Cons.逻辑集合, List.class);
        Document 下一个词 = Tool.倒叙下一个词(list, 结束下标);
        if (下一个词 != null) {
            map上层逻辑内存.put(Cons.下一个词, 下一个词);
            map上层逻辑内存.put(Cons.动作结果, 下一个词);
            Tool.printLog(String.format("那就合并当前逻辑和下一个词 的 合并结果 是：%s", 当前逻辑.get(Cons.逻辑名)));
        }

    }
}
