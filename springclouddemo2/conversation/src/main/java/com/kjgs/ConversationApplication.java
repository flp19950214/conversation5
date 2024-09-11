package com.kjgs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kjgs.conversation.mysql.mapper")
public class ConversationApplication {

    /**
     * 无论怎么样  先分词 再划分成分 以及归属
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConversationApplication.class, args);
    }


}
