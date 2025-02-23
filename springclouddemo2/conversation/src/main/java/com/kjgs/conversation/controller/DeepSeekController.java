package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@RestController
public class DeepSeekController {
    @PostMapping("/deepseek")
    public Object process1(@RequestBody JSONObject input) {
        return deepseek( input.getString("input"));
    }
    public String deepseek(String input) {
        // DeepSeek 接口地址
//        String apiUrl = "http://localhost:8080/v1/chat/completions";
        String apiUrl = "http://localhost:11434/api/chat";

        // 请求体（JSON 格式）
        String requestBody = "{ \"model\":\"deepseek-r1:8b\", \"messages\":[{\"role\":\"user\",\"content\":\"%s\"}], \"stream\":false}";
        requestBody = String.format(requestBody, input);
        String result = null;
        // 创建 HttpClient
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建 POST 请求
            HttpPost httpPost = new HttpPost(apiUrl);
            httpPost.setHeader("Content-Type", "application/json");
            // 如果需要认证，添加头：httpPost.setHeader("Authorization", "Bearer your-local-key");

            // 设置请求体
            StringEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpPost.setEntity(requestEntity);

            // 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                // 获取响应状态码
                int statusCode = response.getCode();
                System.out.println("Status Code: " + statusCode);

                // 获取响应体
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response Body: " + responseBody);

                // 解析 JSON 响应（使用 Jackson）
                ObjectMapper mapper = new ObjectMapper();
                String message = JSON.parseObject(responseBody, Map.class).get("message").toString();
                result =  JSON.parseObject(message, Map.class).get("content").toString();
                System.out.println("模型回复: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

