package com.kjgs.conversation2;

import com.kjgs.conversation2.method.输出句子成分集合;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 拦截处理 {

    @Autowired
    private 输出句子成分集合 impl怎么得出这个结果的;
    public Object method(String str){
        return impl怎么得出这个结果的.method(str);
    }
}
