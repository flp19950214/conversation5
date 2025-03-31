package com.kjgs.conversation.mysql;

import com.kjgs.conversation.mysql.mapper.数据Mapper;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.conversation2.model.Model数据;
import com.kjgs.实体.逻辑实体;
import com.kjgs.静态变量;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Impl数据 {

    @Autowired
    private 数据Mapper 数据MapperImpl;

    public  List<Model数据> 查询所有数据(){
        return 数据MapperImpl.查询所有数据();
    }
}
