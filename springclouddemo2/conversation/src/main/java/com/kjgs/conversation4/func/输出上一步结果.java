package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import com.kjgs.conversation4.mapper.数据4Mapper;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class 输出上一步结果 extends FuncAbstract4 {

    @Autowired
    private 数据4Mapper impl数据4Mapper;

    @Override
    public void method(Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {
        Object object = MapUtils.getObject(map上层逻辑内存, Cons.动作结果);
        if(object==null){
            throw new Exception("输出上一步结果 的 动作结果 为null");
        }
        Tool.printLog(String.format("输出上一步结果 的 动作结果 是：%s", object));
    }
}
