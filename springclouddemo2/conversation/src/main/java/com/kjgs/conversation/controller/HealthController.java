package com.kjgs.conversation.controller;

import com.kjgs.conversation.service.TestDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    @Autowired
    private TestDaoService testDaoService;

    @RequestMapping("/getHealth")
    public Map getHealth(){
        Map map = new HashMap();
        map.put("123","2sdf");
        return map;
    }

    @RequestMapping("/testDao")
    public List<Map<String, Object>> testDao(){
        List<Map<String, Object>> users = testDaoService.getUsers();
        return users;
    }

}
