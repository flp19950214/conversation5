package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class 执行查询逻辑成分方法 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        List<Document> 逻辑句子的成分集合 = ToolService.获取逻辑句子的成分集合();
        List<Document> 句子成分集合 = ToolService.获取句子成分集合();
        Document 逻辑句子的成分 = ToolService.获取当前逻辑句子成分();
        int 在句子中的下标 = 逻辑句子的成分.getInteger(Cons.在句子中的下标);
        int 在句子中的结束下标 = 逻辑句子的成分.getInteger(Cons.在句子中的结束下标);
        //获取当前处理逻辑的方位属性
        String 方位属性 = 逻辑句子的成分.getString(Cons.方位属性);
        List<Document> filterResult = new ArrayList<>();
        if(StringUtils.equals(方位属性, Cons.向前)){
            filterResult = 逻辑句子的成分集合.stream()
                    .filter(m -> m.getInteger(Cons.在句子中的下标) < 在句子中的下标)
                    .collect(Collectors.toList());
        }else if(StringUtils.equals(方位属性, Cons.向后)){
            filterResult = 逻辑句子的成分集合.stream()
                    .filter(m -> m.getInteger(Cons.在句子中的下标) > 在句子中的下标)
                    .collect(Collectors.toList());
        }

    }

}
