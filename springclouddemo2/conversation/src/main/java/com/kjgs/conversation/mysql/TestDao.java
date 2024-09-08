package com.kjgs.conversation.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> getUsers(){
        String sql="select * from 逻辑表";//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
