package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.springframework.stereotype.Service;

@Service
public class 获取当前逻辑句子成分的词语 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    /**
     * 当前输入的句子作为
     * 当前词语的结束位置作为
     */
    @Override
    public void 功能() {
        动作结果=ToolService.获取当前逻辑句子成分的词语();
        静态变量.添加执行层级集合(String.format("%s %s", level, " 当前逻辑句子成分的词语："+动作结果));
    }


}
