package com.kjgs.线程池;

import com.kjgs.实体.内置功能实体;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class 异步_初始化记录内置功能属性 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Async("AsyncTaskExecutor")
    public void 初始化记录内置功能属性(内置功能实体 obj) {
        String querySql = "select * from 内置功能表 where 结果名 = %s";
        querySql = String.format(querySql, obj.功能名);
        // 存在就更新，否则就新增，
        内置功能实体 内置功能实体 = jdbcTemplate.queryForObject(querySql, 内置功能实体.class);
        if (内置功能实体 == null) {
            String insertSql = "insert into 内置功能表 (功能名,参数名1,参数名2,参数名3,结果名) values(?,?,?,?,?)";
            insertSql = String.format(insertSql, obj.功能名, obj.参数名1, obj.参数名2, obj.参数名3, obj.结果名);
            jdbcTemplate.update(insertSql);
        } else if (内置功能实体 != null && !内置功能实体.equals(obj)) {
            String updateSql = "update  内置功能表 set 功能名 = ?,参数名1 = ?,参数名2 = ? ,参数名3 = ?,结果名= ?";
            updateSql = String.format(updateSql, obj.功能名, obj.参数名1, obj.参数名2, obj.参数名3, obj.结果名);
            jdbcTemplate.update(updateSql);
        }
    }
}
