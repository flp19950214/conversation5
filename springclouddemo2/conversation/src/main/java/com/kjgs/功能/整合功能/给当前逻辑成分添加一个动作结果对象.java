package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 给当前逻辑成分添加一个动作结果对象 extends 功能抽象 {
    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        Document 获取当前逻辑句子成分 = ToolService.获取当前逻辑句子成分(uuidLevel);
        Document 动作结果 = new Document();

    }
}
