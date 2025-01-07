package com.kjgs.功能.内置功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import org.springframework.stereotype.Service;

@Service
public class 获取当前逻辑句子成分的下一个字 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    /**
     * 当前输入的句子作为
     * 当前词语的结束位置作为
     */
    @Override
    public void 功能() {
        int 当前逻辑句子成分的结束下标 = ToolService.获取当前逻辑句子成分的结束下标();
        String 输入的逻辑句子 = 获取最近的属性值(所有逻辑对象, Cons.输入的逻辑句子);
        动作结果=输入的逻辑句子.indexOf(当前逻辑句子成分的结束下标);
    }
}
