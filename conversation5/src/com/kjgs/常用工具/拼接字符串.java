package com.kjgs.常用工具;

import com.kjgs.枚举.Cons;
import org.junit.Test;

public class 拼接字符串 {


    @Test
    public void 拼接_测试(){
        System.out.println(拼接("asd","d","sd"));
    }

    public static String 拼接(Object...args){
        StringBuffer sb = new StringBuffer();
        for(Object obj:args){
            sb.append(obj);
        }
        return sb.toString();
    }

    public static String 双引号拼接(Object arg){
        return 拼接(Cons.左引号, arg, Cons.右引号);
    }
}
