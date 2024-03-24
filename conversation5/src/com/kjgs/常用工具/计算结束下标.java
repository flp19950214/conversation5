package com.kjgs.常用工具;

public class 计算结束下标 {
    public static int 结束下标(int 开始下标, String arg1, String arg2){
        return 开始下标+arg1.length()+arg2.length();
    }
    public static int 结束下标(int 开始下标, String arg1){
        return 开始下标+arg1.length();
    }
}
