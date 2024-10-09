package com.kjgs.启动执行包;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class 启动读文件重置数据 implements ApplicationRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String path = "classpath:逻辑数据.sql";
        Resource resource  = resourceLoader.getResource(path);
        try(BufferedReader br =new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if(line.startsWith("--")){
                    continue;
                }
                sb.append(line.trim());
                // 处理可能的多行语句
                if (line.endsWith(";")) {
                    String sql = sb.toString();
                    jdbcTemplate.execute(sql);
                    sb.setLength(0);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
