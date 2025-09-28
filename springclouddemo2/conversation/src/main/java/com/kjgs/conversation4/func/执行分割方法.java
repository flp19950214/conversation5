package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import com.kjgs.conversation4.Tool;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class 执行分割方法 extends FuncAbstract4 {

    @Override
    public void method(Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {
        Object 分割对象 = MapUtils.getString(map上层逻辑内存, Cons.分割对象);
        if(分割对象==null){
            throw new Exception("执行分割方法 的 分割对象 为null");
        }
        Object 分割词 = MapUtils.getString(map上层逻辑内存, Cons.分割词);
        if(分割词==null){
            throw new Exception("执行分割方法 的 分割词 为null");
        }
        if(!(分割对象 instanceof String)){
            throw new Exception("执行分割方法 的 分割对象 不是字符串");
        }
        if(!(分割词 instanceof String)){
            throw new Exception("执行分割方法 的 分割词 不是字符串");
        }
        List<String> 分割结果 = Arrays.asList(((String) 分割对象).split((String) 分割词));
        map上层逻辑内存.put(Cons.分割结果,分割结果);
        map上层逻辑内存.put(Cons.动作结果, 分割结果);
        Tool.printLog(String.format("执行分割方法 的 分割结果 是：%s", 分割结果));
    }
}
