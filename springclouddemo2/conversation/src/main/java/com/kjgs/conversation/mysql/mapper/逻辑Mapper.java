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
    List<逻辑实体> 根据逻辑名和逻辑类型查询(List<String> 逻辑名集合, String 逻辑类型);

    List<String> 模糊查询逻辑(String 逻辑);
    int 查询逻辑(String 逻辑);
    int 保存逻辑(String 逻辑);
}
