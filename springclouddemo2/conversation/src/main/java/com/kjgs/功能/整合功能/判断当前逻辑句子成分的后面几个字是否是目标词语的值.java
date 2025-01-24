package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class 判断当前逻辑句子成分的后面几个字是否是目标词语的值 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {

    }

    /**
     * 当前输入的句子作为
     * 当前词语的结束位置作为
     */
    @Override
    public void 功能() {
        String 目标词语 = 获取最近的属性值(所有逻辑对象, Cons.目标词语);

        int 当前逻辑句子成分的结束下标 = ToolService.获取当前逻辑句子成分的结束下标(uuidLevel);
        String 当前处理的逻辑句子 = ToolService.获取当前逻辑句子(uuidLevel);

        int 预计结束下标 = 当前逻辑句子成分的结束下标+目标词语.length();
        if(当前处理的逻辑句子 == null || 当前处理的逻辑句子.length()<=预计结束下标){
            return ;
        }
        if(StringUtils.equals(目标词语, StringUtils.substring(当前处理的逻辑句子,当前逻辑句子成分的结束下标,预计结束下标))){
            动作结果=true;
        }else{
            动作结果=false;
        }
    }

}
