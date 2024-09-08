package com.kjgs.线程池;

import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class 异步_初始化记录常用逻辑 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private 逻辑Mapper 逻辑Mapper;

    @Async("AsyncTaskExecutor")
    public void 初始化记录内置功能属性(逻辑实体 obj) {
        // 存在就更新，否则就新增，
        逻辑实体 逻辑实体 = 逻辑Mapper.queryForObject(obj.逻辑名);
        if (逻辑实体 == null) {
            String insertSql = "insert into 逻辑表 (逻辑名,逻辑) values(?,?)";
            jdbcTemplate.update(insertSql, obj.逻辑名, obj.逻辑);
        } else if (逻辑实体 != null && !逻辑实体.equals(obj)) {
            String updateSql = "update  逻辑表 set 逻辑 = ? where 逻辑名 = ?";
            jdbcTemplate.update(updateSql, obj.逻辑, obj.逻辑名);
        }
    }
}
