package com.kjgs.conversation.mysql.mapper;

import com.kjgs.实体.词性实体;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface 词性Mapper {
    List<词性实体> 查询词性(String 句子);
}
