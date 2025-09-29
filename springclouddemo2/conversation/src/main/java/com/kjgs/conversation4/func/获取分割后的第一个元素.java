package com.kjgs.conversation4.func;

import com.kjgs.conversation4.Cons;
import com.kjgs.conversation4.FuncAbstract4;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class 获取分割后的第一个元素 extends FuncAbstract4 {

    @Override
    public void method() throws Exception {
        Object object = MapUtils.getObject(map上层逻辑内存, Cons.分割结果);
        if(object==null){
            throw new Exception("获取分割后的第一个元素 的 分割结果 为null");
        }
        if(object instanceof List){
            List object1 = (List) object;
            if(object1.size()<1){
                throw new Exception("获取分割后的第一个元素 的 分割结果 长度小于1");
            }
            map上层逻辑内存.put(Cons.分割后的第一个元素, object1.get(0));
            map上层逻辑内存.put(Cons.动作结果, object1.get(0));
        }else{
            throw new Exception("获取分割后的第一个元素 的 分割结果不是数组集合");
        }
    }
}
