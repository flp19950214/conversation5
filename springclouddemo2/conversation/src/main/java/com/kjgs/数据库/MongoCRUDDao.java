package com.kjgs.数据库;

import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MongoCRUDDao {
    String doc = "kjgsDoc2";
    @Autowired
    private MongoTemplate mongoTemplate;

    public List 查询词语词性(Object 词语){
        if(词语==null){
            return Collections.emptyList();
        }
        Query query = Query.query(Criteria.where(Cons.词语).in(词语,词语.toString()));
//                .is(词语))
//                .with(Sort.by(Sort.Direction.DESC,"_id"));
        List<Document> list = mongoTemplate.find(query, Document.class,doc);
        return new ArrayList(list.stream().filter(m -> m.containsKey(Cons.词语类型)).map(m -> m.get(Cons.词语类型)).collect(Collectors.toSet()));
    }


    public List<Document> 条件查询(Document document) {
        Query query = new Query();
        for (Map.Entry entry : document.entrySet()) {
            query.addCriteria(Criteria.where(entry.getKey().toString()).is(entry.getValue()));
        }
        return mongoTemplate.find(query, Document.class, doc);
    }

    //查询测试
    public List<Document> queryTest(){
        //查询字段name为张三的数据（多条件查询）
        Query query = Query.query(Criteria.where(Cons.词语).is(1))
                .with(Sort.by(Sort.Direction.DESC,"_id"));
        List<Document> list = mongoTemplate.find(query, Document.class,doc);
        return list;
    }
    //保存
    public void saveTest(){
        Document document0 = new Document();
        document0.put(Cons.词语, "2");
        document0.put(Cons.词语类型, "数字");
        mongoTemplate.save(document0,doc);
        Document document = new Document();
        document.put(Cons.词语, "1");
        document.put(Cons.词语类型, "数字");
        mongoTemplate.save(document,doc);

        Document document1 = new Document();
        document1.put(Cons.词语, "加");
        document1.put(Cons.词语类型, "加号");
        mongoTemplate.save(document1,doc);

        Document document2 = new Document();
        document2.put(Cons.词语, "是");
        document2.put(Cons.词语类型, "是");
        mongoTemplate.save(document2, doc);
    }
}
