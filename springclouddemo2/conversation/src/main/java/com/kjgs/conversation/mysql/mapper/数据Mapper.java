package com.kjgs.conversation.mysql.mapper;

import com.kjgs.conversation2.model.Model数据;
import com.kjgs.实体.逻辑实体;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface 数据Mapper {

    List<Model数据> 查询所有数据();
    int 保存数据(String 数据);
}
