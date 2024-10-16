package com.kjgs.启动执行包;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

@Component
public class 启动读文件重置数据 implements ApplicationRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jdbcTemplate.execute("delete from `conversation`.`逻辑表`;");
        String path = "classpath:插入逻辑.sql";
        Resource resource  = resourceLoader.getResource(path);
        try(BufferedReader br =new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(StringUtils.isEmpty(line) || line.startsWith("--")){
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO `conversation`.`逻辑表`(`逻辑名`, `逻辑`) VALUES ")
                        .append(line.trim());
                // 处理可能的多行语句
                if (line.endsWith(";")) {
                    String sql = sb.toString();
                    try {
                        jdbcTemplate.execute(sql);
                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                    sb.setLength(0);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
