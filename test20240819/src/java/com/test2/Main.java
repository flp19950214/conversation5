package com.test2;

import java.util.Scanner;

public class Main {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
//        String s = "aaaa";
//        String p = "aa";
//        String s = "axb";
//        String p = "ab";
//        String s = "axxbaxxxb";
//        String p = "ab";
        method2(s, p);
    }

    public static void method2(String s, String p) {
        if(s.contains(p)){
            System.out.println(0);
            return;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();
        for (int k = 0; k < arr1.length; k++) {
            int index = k;
            int count = 0;
            int num = 0;
            for (int i = 0; i < arr2.length; i++) {
                for (int j = index; j < arr1.length; j++) {
                    index = j + 1;
                    if (arr2[i] != arr1[j]) {
                        count++;
                    } else {
                        num++;
                        break;
                    }
                    if (num == arr2.length) {
                        break;
                    }
                }
            }
            if (count != 0 && !s.equals(p) && num == arr2.length) {
                res = Math.min(res, count);
            }
        }
        System.out.println(res);
    }
}
