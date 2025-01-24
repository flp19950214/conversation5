package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import org.springframework.stereotype.Service;

@Service
public class 获取当前所有句子成分 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    /**
     * 当前输入的句子作为
     * 当前词语的结束位置作为
     */
    @Override
    public void 功能() {
        动作结果=ToolService.获取句子成分集合();
    }


}
