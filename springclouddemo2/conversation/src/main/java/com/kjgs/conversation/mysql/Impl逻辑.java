package com.kjgs.conversation.mysql;

import com.kjgs.conversation.mysql.mapper.逻辑Mapper;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Impl逻辑 {

    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;

    public void 保存逻辑(String 逻辑){
        if(逻辑MapperImpl.查询逻辑(逻辑) ==0){
            System.out.println("保存逻辑："+逻辑);
            逻辑MapperImpl.保存逻辑(逻辑);
        }
    }
}
