package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class 上一句话是分割对象 extends FuncAbstract4 {

    @Override
    public void method()  throws Exception  {

        Object 上一句话 = MapUtils.getString(map上层逻辑内存, Cons.上一句话);
        if(上一句话==null){
            throw new Exception("上一句话是分割对象 的 上一句话 为null");
        }
        map上层逻辑内存.put(Cons.分割对象, 上一句话);
        map上层逻辑内存.put(Cons.动作结果, 上一句话);
        map当前逻辑内存.put(Cons.分割对象, 上一句话);
    }
}
