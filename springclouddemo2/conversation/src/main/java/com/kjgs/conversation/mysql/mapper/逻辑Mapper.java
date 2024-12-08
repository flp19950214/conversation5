package com.kjgs.conversation.mysql.mapper;

import com.kjgs.实体.逻辑实体;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface 逻辑Mapper {
    逻辑实体 根据逻辑名查询单个处理逻辑(String 逻辑名);
    List<逻辑实体>  根据逻辑名查询所有处理逻辑(String 逻辑名);
    List<逻辑实体> 根据多个逻辑名查询List(List<String> 逻辑名集合);
}
