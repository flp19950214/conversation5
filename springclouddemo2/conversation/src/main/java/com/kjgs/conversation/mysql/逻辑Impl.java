package com.kjgs.conversation.mysql;

import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.实体.逻辑实体;
import com.kjgs.静态变量;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class 逻辑Impl{

    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;

    public 逻辑实体 根据逻辑名查询单个处理逻辑(String 逻辑名) {
        try{
            逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
            return 逻辑Obj;
        }catch (TooManyResultsException e1){
            静态变量.输出的内容.add(String.format("%s %s", 逻辑名, "有多个逻辑异常"));
            e1.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<逻辑实体> 根据逻辑名查询所有处理逻辑(String 逻辑名) {
        try{
            List<逻辑实体> 逻辑List = 逻辑MapperImpl.根据逻辑名查询所有处理逻辑(逻辑名);
            return 逻辑List;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<逻辑实体> 根据多个逻辑名查询List(List<String> 逻辑名集合) {
        return 逻辑MapperImpl.根据多个逻辑名查询List(逻辑名集合);
    }
    public List<逻辑实体> 根据逻辑名和逻辑类型查询(List<String> 逻辑名集合, String 逻辑类型) {
        return 逻辑MapperImpl.根据逻辑名和逻辑类型查询(逻辑名集合, 逻辑类型);
    }


    public void 保存逻辑(String 逻辑){
        if(逻辑MapperImpl.查询逻辑(逻辑) ==0){
            System.out.println("保存逻辑："+逻辑);
            逻辑MapperImpl.保存逻辑(逻辑);
        }
    }
}
