package com.kjgs.conversation.mysql.mapper;

import com.kjgs.conversation2.model.Model数据;
import com.kjgs.实体.逻辑实体;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface 数据Mapper {

    List<Model数据> 查询所有数据();
    int 保存输入数据(Object 数据, String 数据对象);
    int 保存输出数据(Object 数据, String 数据对象);
    String 查询上一个输出对象();
    String 查询数据表指向();
}
