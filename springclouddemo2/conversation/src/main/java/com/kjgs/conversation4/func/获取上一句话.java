package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import com.kjgs.conversation4.mapper.数据4Mapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class 获取上一句话 extends FuncAbstract4 {

    @Autowired
    private 数据4Mapper impl数据4Mapper;

    @Override
    public void method() throws Exception {
        List 输入类型结果 = impl数据4Mapper.根据类型查询(Cons.输入);
        if(CollectionUtils.isEmpty(输入类型结果)){
            throw new Exception("获取上一句话 的 查询根据输入类型的数据结果 为null");
        }
        Object  上一句话 = 输入类型结果.get(0);
        if(!(上一句话 instanceof String)){
            throw new Exception("获取上一句话 的 查询结果 不是 字符串");
        }
        Tool.printLog(String.format("获取上一句话 的 查询结果 是：%s", 上一句话));
        map上层逻辑内存.put(Cons.上一句话,上一句话);
        map上层逻辑内存.put(Cons.动作结果, 上一句话);
    }
}
