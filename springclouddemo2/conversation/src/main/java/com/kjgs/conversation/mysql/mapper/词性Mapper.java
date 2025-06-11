package com.kjgs.conversation.mysql.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface 词性Mapper {
    List<String> 查询词语词性(String 词语);
}
