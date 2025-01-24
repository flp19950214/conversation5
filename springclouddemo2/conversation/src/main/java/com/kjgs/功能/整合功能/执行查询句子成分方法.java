package com.kjgs.功能.整合功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation.service.ToolService;
import com.kjgs.conversation.service.Tool条件查询;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class 执行查询句子成分方法 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    /**
     * 查询逻辑对象：内存逻辑成分
     * 查询逻辑条件
     * 查询逻辑方位
     */
    @Override
    public void 功能() {
        List<Document> 句子成分集合 = ToolService.获取句子成分集合();
        // 注意这里是当前逻辑成分的查询条件 取查 句子的成分集合
        Document 逻辑句子的成分 = ToolService.获取当前逻辑句子成分(uuidLevel);
        Document 当前句子的成分 = ToolService.获取当前句子成分();
        int 在句子中的下标 = 当前句子的成分.getInteger(Cons.在句子中的下标);
        int 在句子中的结束下标 = 当前句子的成分.getInteger(Cons.在句子中的结束下标);
        //获取当前处理逻辑的方位属性
        String 方位属性 = 逻辑句子的成分.getString(Cons.方位属性);
        List<Document> filterResult = new ArrayList<>();
        if(StringUtils.equals(方位属性, Cons.向前)){
            filterResult = 句子成分集合.stream()
                    .filter(m -> m.getInteger(Cons.在句子中的下标) < 在句子中的下标)
                    .collect(Collectors.toList());
        }else if(StringUtils.equals(方位属性, Cons.向后)){
            filterResult = 句子成分集合.stream()
                    .filter(m -> m.getInteger(Cons.在句子中的下标) > 在句子中的下标)
                    .collect(Collectors.toList());
        }

        //获取查询属性键值对
        Object 查询条件 = 逻辑句子的成分.get(Cons.查询条件);
        if(查询条件 instanceof Pair){
            Pair 查询条件Pair = 逻辑句子的成分.get(Cons.查询条件, Pair.class);
            filterResult = Tool条件查询.过滤键值对(filterResult, 查询条件Pair);
        }else if(查询条件 instanceof List){
            List<Pair> 查询条件List = 逻辑句子的成分.get(Cons.查询条件, List.class);
            for(Pair pair:查询条件List){
                filterResult = Tool条件查询.过滤键值对(filterResult, pair);
            }
        }

        动作结果 = filterResult;
        静态变量.添加执行层级集合(String.format("%s %s", level, " 执行查询句子成分结果："+ JSON.toJSONString(动作结果)));
    }

}
