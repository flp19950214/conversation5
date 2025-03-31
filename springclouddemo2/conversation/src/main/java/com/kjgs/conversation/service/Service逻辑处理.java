package com.kjgs.conversation.service;

import com.alibaba.fastjson2.JSON;
import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.实体.逻辑实体;
import com.kjgs.数据库.MongoCRUDDao;
import com.kjgs.枚举.Cons;
import com.kjgs.算法.工具;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Service逻辑处理 {
    @Autowired
    private MongoCRUDDao mongoCRUDDao;
    @Autowired
    private Impl逻辑 逻辑MapperImpl;

    @Autowired
    private 新处理逻辑 新处理逻辑;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    public void process(String 词语, String 逻辑类型){
        process(词语, 逻辑类型, 0, UUID.randomUUID().toString());
    }

    public void process(String 词语, String 逻辑类型, int level, String uuidLevel){
        ToolService.是否执行判断结果设置为true();
        List<String> 词性set =  mongoCRUDDao.查询词语词性(词语);
        词性set.add(词语);
        //查询逻辑
        List<逻辑实体> 逻辑set = 逻辑MapperImpl.根据逻辑名和逻辑类型查询(词性set, 逻辑类型);

        for (逻辑实体 逻辑实例 : 逻辑set){

            //判断逻辑是否有二级逻辑
            if(StringUtils.contains(逻辑实例.逻辑, "《")){
                //可以直接处理
                新处理逻辑.执行逻辑(逻辑实例, uuidLevel,level);
            }else{
                if(StringUtils.equals(逻辑实例.逻辑, ToolService.获取当前逻辑句子(uuidLevel))){
                    continue;
                }
                int level2 = level+1;
                String uuIdLevel2 = UUID.randomUUID().toString();
                if(!ToolService.是否存在逻辑句子(uuidLevel,逻辑实例.逻辑)){
                    Document 当前处理的逻辑句子 = new Document();
                    当前处理的逻辑句子.put(Cons.当前处理的逻辑句子, 逻辑实例.逻辑);
                    当前处理的逻辑句子.put(Cons.是否是当前处理的逻辑句子, true);
                    当前处理的逻辑句子.put(Cons.level, level2);
                    当前处理的逻辑句子.put(Cons.uuidLevel, uuIdLevel2);
                    执行逻辑Impl.所有逻辑对象.add(当前处理的逻辑句子);
                }
                //走分析并处理逻辑流程
                String[] 逻辑集合 = 逻辑实例.逻辑.split("");
                //给每个逻辑词添加成逻辑成分
                for (int i = 0; i < 逻辑集合.length; i++) {
                    String item = 逻辑集合[i];
                    Document 成分对象 = new Document();
                    成分对象.put(Cons._id, new ObjectId());
                    成分对象.put(Cons.对象类型, Cons.逻辑句子成分);
                    成分对象.put(Cons.词语, item);
                    成分对象.put(Cons.在句子中的下标, i);
                    成分对象.put(Cons.在句子中的结束下标, 工具.strDdoubleToInt(i) + 1);
                    成分对象.put(Cons.level, level2);
                    成分对象.put(Cons.uuidLevel, uuIdLevel2);
                    if(!ToolService.是否存在逻辑对象(uuIdLevel2, item, i)){
                        执行逻辑Impl.所有逻辑对象.add(成分对象);
                    }
                }

                List<Document> 句子成分集合 = ToolService.获取逻辑句子的成分集合(uuIdLevel2);
                for (int i = 0; i < 句子成分集合.size(); i++) {
                    Document 成分对象 = 句子成分集合.get(i);
                    成分对象.put(Cons.是否是当前处理的句子成分, true);
                    process(成分对象.getString(Cons.词语), Cons.词性逻辑, level2, uuIdLevel2);
                    process(成分对象.getString(Cons.词语), Cons.分词逻辑, level2, uuIdLevel2);
                    process(成分对象.getString(Cons.词语), Cons.动作逻辑, level2, uuIdLevel2);
                    process(成分对象.getString(Cons.词语), Cons.输出逻辑, level2, uuIdLevel2);
                    成分对象.put(Cons.是否是当前处理的句子成分, false);
                }
                List<Document> 句子成分集合new = ToolService.获取逻辑句子的成分集合(uuIdLevel2);
                String old = JSON.toJSONString(句子成分集合);
                String 成分new = JSON.toJSONString(句子成分集合new);
                Document 当前处理的逻辑句子 = ToolService.获取当前逻辑句子对象(uuIdLevel2);
                当前处理的逻辑句子.put(Cons.是否是当前处理的逻辑句子, false);
                while (!StringUtils.equals(old, 成分new)){
                    old = 成分new;
                    for (int i = 0; i < 句子成分集合new.size(); i++) {
                        Document 成分对象 = 句子成分集合new.get(i);
                        成分对象.put(Cons.是否是当前处理的句子成分, true);
                        process(成分对象.getString(Cons.词语), Cons.词性逻辑, level2, uuIdLevel2);
                        process(成分对象.getString(Cons.词语), Cons.分词逻辑, level2, uuIdLevel2);
                        process(成分对象.getString(Cons.词语), Cons.动作逻辑, level2, uuIdLevel2);
                        process(成分对象.getString(Cons.词语), Cons.输出逻辑, level2, uuIdLevel2);
                        成分对象.put(Cons.是否是当前处理的句子成分, false);
                    }
                    List<Document> 句子成分集合new2 = ToolService.获取逻辑句子的成分集合(uuIdLevel2);
                    成分new = JSON.toJSONString(句子成分集合new2);
                }
            }
        }
    }


    public void process逻辑(String 词语){
        List<String> 词性set =  mongoCRUDDao.查询词语词性(词语);
        词性set.add(词语);
        //查询逻辑
        List<逻辑实体> 逻辑set = 逻辑MapperImpl.根据多个逻辑名查询List(词性set);
        for (逻辑实体 逻辑实例 : 逻辑set){
            //判断逻辑是否有二级逻辑
            if(StringUtils.contains(逻辑实例.逻辑, "《")){
                //可以直接处理
                新处理逻辑.执行逻辑(逻辑实例, UUID.randomUUID().toString(),0);
            }
        }
    }
}
