package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import org.springframework.stereotype.Service;

@Service
public class 给当前逻辑添加词性为数字 extends FuncAbstract4 {

    @Override
    public void method() {
        当前逻辑.put(Cons.词性, Cons.数字);
        Tool.printLog(String.format("给当前逻辑添加词性为数字 的 添加结果 是：%s:%s", 当前逻辑.get(Cons.逻辑名), Cons.数字));

    }
}
