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
public class 如果下一个词也是数字 extends FuncAbstract4 {

    @Override
    public void method()  throws Exception  {
        Object object = MapUtils.getObject(map上层逻辑内存, Cons.下一个词);
        if(object != null){
            if(object instanceof Document){
                String 词性 = ((Document) object).getString(Cons.词性);
                if(StringUtils.equals(词性, Cons.数字)){
                    map上层逻辑内存.put(Cons.判断结果, true);
                    map上层逻辑内存.put(Cons.判断结果, true);
                    Tool.printLog(String.format("如果下一个词也是数字 的 判断结果 是：%s", true));
                    return;
                }
            }
        }

        //内存中没有目标字段，就再去取
        int 结束下标 = 当前逻辑.getInteger(Cons.结束下标);
        List<Document> list = 输入词语对象.get(Cons.逻辑集合, List.class);

        Document 下一个词 = Tool.倒叙下一个词(list, 结束下标);
        if (下一个词 != null) {
            String 词性 = 下一个词.getString(Cons.词性);
            if(StringUtils.equals(词性, Cons.数字)){
                map上层逻辑内存.put(Cons.判断结果, true);
                map上层逻辑内存.put(Cons.判断结果, true);
                Tool.printLog(String.format("如果下一个词也是数字 的 判断结果 是：%s", true));
                return;
            }
        }

        //默认是false
        map上层逻辑内存.put(Cons.判断结果, true);
        map上层逻辑内存.put(Cons.判断结果, true);
        Tool.printLog(String.format("如果下一个词也是数字 的 判断结果 是：%s", false));
    }
}
