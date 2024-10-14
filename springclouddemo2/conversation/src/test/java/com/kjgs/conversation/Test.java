package com.kjgs.conversation;

public class Test {
    public static void main(String[] args) {
        Object obj = new Object();
        test(obj);
        System.out.println(obj.toString());
    }
    public static void test(Object obj){
        obj="asdf";
    }


}
