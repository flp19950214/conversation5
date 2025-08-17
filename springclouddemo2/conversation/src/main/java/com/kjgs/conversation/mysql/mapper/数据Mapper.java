package com.kjgs.conversation.mysql.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface 数据Mapper {

    List<String> 查询所有数据();
    int 保存数据表(String 数据对象);
    String 查询上一个输出对象();
    String 查询数据表指向();
    List<String> 根据键值对查询(Object 键, Object 值, Object 个数);
    String 查询上一个输入对象();
}
