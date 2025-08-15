package com.kjgs.conversation2;

import com.kjgs.conversation2.method.怎么得出这个结果的;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 拦截处理 {

    @Autowired
    private 怎么得出这个结果的 impl怎么得出这个结果的;
    public void method(String str){
        impl怎么得出这个结果的.method(str);
    }
}
