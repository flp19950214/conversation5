package com.kjgs.conversation.mysql.mapper;

import com.kjgs.实体.逻辑实体;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface 逻辑Mapper {
    逻辑实体 queryForObject(String 逻辑名);
    Set<逻辑实体> 根据多个逻辑名查询List(Set<String> 逻辑名集合);
}
