package com.kjgs.枚举;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class resr {

    public static void main(String[] args) {
        System.out.println(chineseToNumber("十万"));
    }
    static final List<String> CHINESE_NUMBER = Arrays.asList("零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "百", "千", "万", "亿");
    private static final HashMap<Character, Integer> chineseMap = new HashMap() {{
        put('零', 0);
        put('一', 1);
        put('二', 2);
        put('三', 3);
        put('四', 4);
        put('五', 5);
        put('六', 6);
        put('七', 7);
        put('八', 8);
        put('九', 9);
        put('十', 10);
        put('百', 100);
        put('千', 1000);
        put('万', 10000);
        put('亿', 100000000);
    }};


    public static String chineseToNumber(String chinese) {
        if (ObjectUtils.isEmpty(chinese)) {
            return "00";
        }
        //判断是否十纯中文汉字，不是则直接返回00
        if (!isChineseNum(chinese)) {
            return "00";
        }
        int number = 0;
        int temp = 0;
        for (int i = 0; i < chinese.length(); i++) {
            int current = chineseMap.get(chinese.charAt(i));
            if (current < 10) {
                temp += current;
            } else {
                if (current == 100) { // 处理"百"的情况
                    if (temp == 0) {
                        temp = 1;
                    }
                    number += temp * current;
                    temp = 0;
                } else if (current == 1000) { // 处理"千"的情况
                    if (temp == 0) {
                        temp = 1;
                    }
                    number += temp * current;
                    temp = 0;
                } else { // 处理其他情况
                    number += temp;
                    number += current;
                    temp = 0;
                }
            }
        }
        number += temp;
        return append(String.valueOf(number));
    }

    /**
     * 判断传入的字符串是否全是汉字数字
     *
     * @param chineseStr 中文
     * @return 是否全是中文数字
     */
    private static boolean isChineseNum(String chineseStr) {
        for (char c : chineseStr.toCharArray()) {
            if (!CHINESE_NUMBER.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    private static String append(String num) {
        if (StringUtils.length(num) > 0) {
            return num.length() == 2 ? num : "0" + num;
        }
        return "00";
    }

}
