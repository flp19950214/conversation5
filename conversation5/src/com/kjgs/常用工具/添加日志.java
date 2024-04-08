package com.kjgs.常用工具;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 添加日志 {
    public static void appendToFile(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
            bufferedWriter.newLine(); // 添加换行符
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void 追加(String 内容){
        String content = "log/%s";
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        appendToFile(String.format(content, date), 内容);
    }

    public static void main(String[] args) {
        追加("neirong");
//        String filePath = "log/20240408.txt";
//        String lineToAppend = "这是要追加的行";
//        appendToFile(filePath, lineToAppend);
    }
}
