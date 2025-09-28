package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class 是是分割词 extends FuncAbstract4 {

    @Override
    public void method(Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) {
        map上层逻辑内存.put(Cons.分割词, Cons.是);
        map当前逻辑内存.put(Cons.分割词, Cons.是);
    }
}
