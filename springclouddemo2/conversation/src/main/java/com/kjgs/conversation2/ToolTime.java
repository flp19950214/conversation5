package com.kjgs.conversation2;

import com.alibaba.fastjson2.JSON;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ToolTime {

    public static void main(String[] args) {
        // 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
        String formattedDateTime = now.format(formatter);

        System.out.println(formattedDateTime); // 输出格式化的日期时间
    }

    public static String getCurrentTime(){
        // 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
       return now.format(formatter);
    }

}
