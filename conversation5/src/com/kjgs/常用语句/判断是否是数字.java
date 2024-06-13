package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.执行逻辑;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 判断是否是数字 {
    /**
     * 判断条件和判断结果要分开处理     */
    String 判断是否是数字 = "#{查询这个词的类型}\n被判断的对象《是》￥{查询的结果}\n判断的对象《是》数字\n《执行判断等于方法》" +
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    @Test
    public void test(){
        执行逻辑.执行逻辑(判断是否是数字, "2");
    }
}
