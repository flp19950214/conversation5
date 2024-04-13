package com.kjgs.常用工具;

import org.apache.commons.lang3.StringUtils;

public class 截取字符串 {
    public static void main(String[] args) {
        String 字符串="字符串测试sssss";
        System.out.println(截取结束下标到开始下标(字符串,0+"字符串".length(), 5));
    }
    public static  String 截取结束下标到开始下标(String 字符串, int 结束下标, int 开始下标){
        return StringUtils.substring(字符串, 结束下标, 开始下标);
    }
}
