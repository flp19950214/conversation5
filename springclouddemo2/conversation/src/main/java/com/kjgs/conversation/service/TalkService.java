package com.kjgs.conversation.service;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.功能.功能对象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkService {

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Autowired
    private Impl逻辑 逻辑MapperImpl;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @Autowired
    private 功能对象 功能对象Impl;

    public boolean 是否继续反复处理句子(){
        //判断句子成分是否还有变换
        String 逻辑名 = "是否继续反复处理句子";
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);
        return Boolean.parseBoolean(result.toString());
    }

    public void 记录所有的句子成分到内存中(){
        //被动记录句子成分集合
        String 逻辑名 = "获取所有的句子成分";
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);
        Document 输入的句子 = new Document();
        输入的句子.put(Cons.句子成分集合, result);
        输入的句子.put(Cons.对象类型, Cons.句子成分);
        执行逻辑Impl.所有逻辑对象.add(输入的句子);
    }

    public String 记录当前输入句子(){
        String 逻辑名 = "记录当前输入句子";
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);
        if(result==null){
            return null;
        }
        return result.toString();
    }

    public String 执行输出结果逻辑(){
        Document 获取最近的对象 = 功能对象Impl.获取最近的对象(执行逻辑Impl.所有逻辑对象, Cons.是否执行判断结果);
        获取最近的对象.put(Cons.是否执行判断结果, true);
        //被动记录句子成分集合
        String 逻辑名 = "执行输出结果逻辑";
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);
        return result.toString();
    }

}
