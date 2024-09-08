package com.test;

public class Parent2 {
    private  String a1;
    private  String a2;
    static {
        System.out.println("sd");
    }

    public Parent2(String a1){
        System.out.println("sdf");
        this.a1=a1;
        try{

        }finally {

        }
    }
    {
        System.out.println("sdfadsf");
    }
    public static void main(String[] args) {
        Parent2 parent2 = new Parent2("we");
        System.out.println(parent2.a2);
    }
}
