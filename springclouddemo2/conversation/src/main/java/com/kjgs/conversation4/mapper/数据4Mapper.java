package com.kjgs.conversation4.mapper;

import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface 数据4Mapper {

    List 根据类型查询(String 类型);
    void insert(Object 类型, Object 数据);
}
