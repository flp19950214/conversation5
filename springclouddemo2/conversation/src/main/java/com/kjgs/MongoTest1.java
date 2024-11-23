package com.kjgs;

import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MongoDB测试类
 * */
@SpringBootTest(classes = ConversationApplication.class)
@RunWith(SpringRunner.class)
@ComponentScan("com.kjgs")
public class MongoTest1 {


    @Autowired
    private MongoTemplate mongoTemplate;

    //保存
    @Test
    public void saveTest(){
        Document document = new Document();
        document.put(Cons.词语, 1);
        document.put(Cons.词语类型, "数字");
        mongoTemplate.save(document);

    }

    //查询一个
    @Test
    public void saveFindOne(){
//        TestDemo testDemo = mongoTemplate.findById("661743b77bee2f0a5739819d", TestDemo.class);
//        System.out.println(testDemo);
        //TestDemo(id=661743b77bee2f0a5739819d, name=张三, birthDay=Thu Apr 11 09:58:15 CST 2024)
    }

    //条件查询
    @Test
    public void testQuery(){
        //查询字段name为张三的数据（多条件查询）
        Query query = Query.query(Criteria.where("name").is("张三"))
                .with(Sort.by(Sort.Direction.DESC,"birthDay"));

        // 执行查询 模糊查询 只查询5条数据
        Query query1 = Query.query(Criteria.where("name").regex(".*?\\" + "张三" + ".*"));
        query.limit(5);

//        List<TestDemo> list = mongoTemplate.find(query, TestDemo.class);
//        List<TestDemo> list1 = mongoTemplate.find(query1, TestDemo.class);

//        System.out.println("list:"+list);
//        System.out.println("list1:"+list1);

    }

    //测试删除
    @Test
    public void testDel(){
//        mongoTemplate.remove(Query.query(Criteria.where("name").is("张三")),TestDemo.class);
    }
}