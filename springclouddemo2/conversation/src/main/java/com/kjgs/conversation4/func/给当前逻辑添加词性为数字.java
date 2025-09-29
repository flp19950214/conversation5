package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import org.springframework.stereotype.Service;

@Service
public class 给当前逻辑添加词性为数字 extends FuncAbstract4 {

    @Override
    public void method() {
        当前逻辑.put(Cons.词性, Cons.数字);
    }
}
