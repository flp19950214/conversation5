package com.kjgs.conversation.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@Service
public class ScreenRecorder {



    private static final String FFMPEG_PATH = "D:\\Users\\hh\\FFmpeg\\ffmpeg-7.1-essentials_build\\bin\\ffmpeg.exe"; // FFmpeg 路径
    private static final String OUTPUT_PATH = "D:\\Users\\hh\\Desktop\\output.mp4"; // 输出路径
    private static final int FRAME_RATE = 30; // 帧率
    private static final int RECORDING_TIME = 10; // 录制时间（秒）

//    public static void main(String[] args) {
//        try {
//            recordScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public void startRecording() {
        try {
            recordScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void recordScreen() throws IOException {
        // 获取屏幕尺寸
        // 检查系统是否为无头环境
        System.setProperty("java.jwt.headless", "false");
//        if (GraphicsEnvironment.isHeadless()) {
//            System.err.println("当前环境为无头模式，无法进行屏幕录制操作。");
//            return; // 或者抛出异常
//        } else {
            // 获取屏幕尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            String screenResolution = (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight();

            // Print parameters to be used
            System.out.println("Starting screen recording with the following parameters:");
            System.out.println("FFmpeg Path: " + FFMPEG_PATH);
            System.out.println("Output Path: " + OUTPUT_PATH);
            System.out.println("Frame Rate: " + FRAME_RATE);
            System.out.println("Recording Time (seconds): " + RECORDING_TIME);
            System.out.println("Screen Resolution: " + screenResolution);

//        // 添加 -t 参数以设置录制时长
//        String command = String.format("%s -video_size %s -framerate %d -f gdigrab -i desktop -t %d -c:v libx264 -pix_fmt yuv420p %s",
//                FFMPEG_PATH, screenResolution, FRAME_RATE, RECORDING_TIME, OUTPUT_PATH);
//

            // 添加 -y 参数以自动覆盖已存在的文件
            String command = String.format("%s -y -video_size %s -framerate %d -f gdigrab -i desktop -t %d -c:v libx264 -pix_fmt yuv420p -loglevel info %s",
                    FFMPEG_PATH, screenResolution, FRAME_RATE, RECORDING_TIME, OUTPUT_PATH);

            System.out.println("Executing command: " + command);


            Process process = Runtime.getRuntime().exec(command);


            // 输出流处理
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("FFmpeg Output: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Error stream handling
            new Thread(() -> {
                try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = errorReader.readLine()) != null) {
                        System.err.println("FFmpeg Error: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // 等待进程结束
            try {
                int exitCode = process.waitFor();
                System.out.println("Process exited with code: " + exitCode);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//    }
}