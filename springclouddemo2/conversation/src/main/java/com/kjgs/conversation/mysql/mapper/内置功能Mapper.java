package com.kjgs.conversation.mysql.mapper;

import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Repository;

@Repository
public interface 内置功能Mapper {
    内置功能实体 queryForObject(String 功能名);
}
