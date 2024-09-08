package com.kjgs.conversation.service;

import com.kjgs.conversation.mysql.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestDaoService {
    @Autowired
    private TestDao testDao;
    public List<Map<String,Object>> getUsers(){
        return testDao.getUsers();
    }
}
