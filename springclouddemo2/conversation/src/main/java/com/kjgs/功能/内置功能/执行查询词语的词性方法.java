package com.kjgs.功能.内置功能;

import com.kjgs.conversation.mysql.mapper.词性Mapper;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

// 只查数据库对象  区别于  执行查询指定属性值方法
@Service
public class 执行查询词语的词性方法 extends 功能抽象 {
    public static final String 查询的词语 = "查询的词语";
    public static final String 查询的结果= "查询的结果";

    @Autowired
    private 词性Mapper 词性MapperImpl;
    @PostConstruct
    public void checkInjection() {
        if (词性MapperImpl != null) {
            // 依赖注入成功
            System.out.println("***************注入成功**************");
        } else {
            // 依赖注入失败
            System.out.println("***************注入失败**************");
        }
    }
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的词语)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 查询的词语 = 获取最近的属性值(所有逻辑对象, this.查询的词语);
        List<String> 查询的结果 = 词性MapperImpl.查询词语词性(查询的词语);
        Document  查询的结果对象 =  new Document();
        查询的结果对象.put(this.查询的结果, 查询的结果);
        查询的结果对象.put(Cons.level,level);
        所有逻辑对象.add(查询的结果对象);

        动作结果=查询的结果;
    }
}

