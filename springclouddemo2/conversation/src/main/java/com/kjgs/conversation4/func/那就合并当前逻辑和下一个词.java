package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 那就合并当前逻辑和下一个词 extends FuncAbstract4 {

    @Override
    public void method() throws Exception {
        //先判断判断结果是否是真，否则抛出一场
        if (!map上层逻辑内存.containsKey(Cons.判断结果)) {
            throw new Exception("那就合并当前逻辑和下一个词 的 判断结果 为 null");
        }
        Object o = map上层逻辑内存.get(Cons.判断结果);
        if (!StringUtils.equals(o.toString(), "true")) {
            throw new Exception("那就合并当前逻辑和下一个词 的 判断结果 为 false");
        }
        int 结束下标 = 当前逻辑.getInteger(Cons.结束下标);
        List<Document> list = 输入词语对象.get(Cons.逻辑集合, List.class);
        Document 下一个词 = Tool.倒叙下一个词(list, 结束下标);
        if (下一个词 != null) {
            //下一个词合并到当前逻辑，并删除下一个词
            当前逻辑.put(Cons.逻辑名, 当前逻辑.getString(Cons.逻辑名) + 下一个词.getString(Cons.逻辑名));
            当前逻辑.put(Cons.结束下标, 下一个词.getInteger(Cons.结束下标));
//            list.remove(下一个词);
//            list.remove(当前逻辑);
            map上层逻辑内存.put(Cons.合并结果, 当前逻辑);
            map上层逻辑内存.put(Cons.动作结果, 当前逻辑);
            Tool.printLog(String.format("那就合并当前逻辑和下一个词 的 合并结果 是：%s", 当前逻辑.get(Cons.逻辑名)));
        }
    }
}
