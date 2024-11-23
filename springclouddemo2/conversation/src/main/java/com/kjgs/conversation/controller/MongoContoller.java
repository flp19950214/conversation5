package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.数据库.MongoCRUDDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mongo")
public class MongoContoller {
    @Autowired
    private MongoCRUDDao mongoCRUDDao;

    //保存
    @RequestMapping("/saveTest")
    public boolean saveTest(){
        mongoCRUDDao.saveTest();
        return true;
    }

    @RequestMapping("/getWordType")
    public List getWordType(@RequestBody JSONObject input ){
        return mongoCRUDDao.查询词语词性(input.get(Cons.词语));
    }

    //保存
    @RequestMapping("/queryTest")
    public List<Document> queryTest(){
        return mongoCRUDDao.queryTest();
    }
}
