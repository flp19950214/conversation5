package com.kjgs.conversation.mysql;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation.mysql.mapper.数据Mapper;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Impl数据 {

    @Autowired
    private 数据Mapper 数据MapperImpl;

    public  List<Document> 查询所有数据(){
        return 数据MapperImpl.查询所有数据().stream()
        .map(m -> JSON.parseObject(m, Document.class))
        .collect(Collectors.toList());
    }
    public  List<Document> 根据键值对查询(Object 键, Object 值){
        return 数据MapperImpl.根据键值对查询(键, 值).stream()
        .map(m -> JSON.parseObject(m, Document.class))
        .collect(Collectors.toList());
    }

    public Document 查询上一个输出对象(){
        String 上一个输出对象 = 数据MapperImpl.查询上一个输出对象();
        if(StringUtils.isEmpty(上一个输出对象)){
            return null;
        }
        return JSON.parseObject(上一个输出对象, Document.class);
    }
    public Document 查询上一个输入对象(){
        String 上一个输入对象 = 数据MapperImpl.查询上一个输入对象();
        if(StringUtils.isEmpty(上一个输入对象)){
            return null;
        }
        return JSON.parseObject(上一个输入对象, Document.class);
    }
    public Document 查询数据表指向(){
        String 上一个输出对象 = 数据MapperImpl.查询数据表指向();
        if(StringUtils.isEmpty(上一个输出对象)){
            return null;
        }
        return JSON.parseObject(上一个输出对象, Document.class);
    }
    public void 保存数据对象(Document document){
        String 数据对象 = document.toJson();
        if(document !=  null){
            数据MapperImpl.保存数据表(数据对象);
        }
    }
    public void 保存输入的数据对象(Document document){
        String 数据对象 = document.toJson();
        if(document !=  null){
            数据MapperImpl.保存数据表(数据对象);
        }
    }

    public void 保存输出的数据对象(Document document){
        if(document !=  null){
            String 数据对象 =  document.toJson();
            数据MapperImpl.保存数据表(数据对象);
        }
    }
}
