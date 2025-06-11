package com.kjgs.conversation.mysql.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface 逻辑Mapper {
    List<String> 模糊查询逻辑(String 逻辑);
    int 查询逻辑(String 逻辑);
    List<String> 查询所有逻辑();
    int 保存逻辑(String 逻辑);
}
