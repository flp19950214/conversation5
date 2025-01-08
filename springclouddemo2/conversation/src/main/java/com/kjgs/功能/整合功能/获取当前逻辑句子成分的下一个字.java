package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
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
        String 下一个字 = 下一个字();
        静态变量.添加执行层级集合(String.format("%s %s", level, " 当前逻辑句子成分的下一个字："+下一个字));

        动作结果=下一个字;
    }

    public String 下一个字(){
        int 当前逻辑句子成分的结束下标 = ToolService.获取当前逻辑句子成分的结束下标();
        String 当前处理的逻辑句子 =获取最近的属性值(所有逻辑对象, Cons.当前处理的逻辑句子);
        return 当前处理的逻辑句子.substring(当前逻辑句子成分的结束下标,当前逻辑句子成分的结束下标+1);
    }
}
