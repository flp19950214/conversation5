package com.kjgs.conversation2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation.mysql.mapper.数据Mapper;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController()
public class TalkController2 {

    @Autowired
    private InvokeLuoji invokeLuoji;

    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;

    @Autowired
    private Impl数据 impl数据;

    @Autowired
    private 给输入句子生成内置句子成分 impl给输入句子生成内置句子成分;

    @Autowired
    private 给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    final int max = 10;

    /**
     * 输入的原句子 不能动
     * @param input
     * @return
     */
    @PostMapping("/process3")
    public Object process(@RequestBody JSONObject input) {
        静态引用.输出内容=null;
        静态引用.是否继续处理句子=true;
        String 输入的句子 = input.getString("input");
        静态引用.输入的句子对象 = new Document();
        静态引用.输入的句子对象.put(Cons._id, new ObjectId());
        静态引用.输入的句子对象.put(Cons.词语, 输入的句子);
        静态引用.输入的句子对象.put(Cons.词语类型, Cons.输入的句子);
        静态引用.输入句子的成分集合.clear();
        String[] 输入的句子元素集合 = 输入的句子.split("");
        //给每个词添加成句子成分
        for (int i = 0; i < 输入的句子元素集合.length; i++) {
            String item = 输入的句子元素集合[i];
            Document 成分对象 = Tool.生成成分对象(item,i,1);
            静态引用.输入句子的成分集合.add(成分对象);
        }
        静态引用.逻辑句子的成分集合.clear();
        处理句子New();
        System.out.println("最终的句子成分：");
        System.out.println(静态引用.逻辑句子的成分集合);
        System.out.println(静态引用.输入句子的成分集合);
        impl数据.保存输入的数据对象(Tool.生成输入的对象(输入的句子));
        impl数据.保存输出的数据对象(Tool.生成输出的对象(静态引用.输出内容));
//        impl给输入句子生成内置句子成分.生成内置句子成分(输入的句子);
        impl给输入的句子生成内置格式化逻辑.生成格式化逻辑();
        return 静态引用.输出内容;
    }

    public void 处理句子New(){
        int loop =0;
        while (静态引用.是否继续处理句子 && loop<10){
            loop++;
            for (int i = 0; i <静态引用.输入句子的成分集合.size() ; i++) {
                Document 句子成分 = 静态引用.输入句子的成分集合.get(i);
                //找逻辑
                String 词语 = 句子成分.getString(Cons.词语);
                String 词性 = 句子成分.getString(Cons.词性);
                String 属于= 句子成分.getString(Cons.属于);
                HashSet<Integer> 逻辑idSet = MapUtils.getObject(静态引用.关键词与逻辑, 词语, new HashSet<>());
                逻辑idSet.addAll(MapUtils.getObject(静态引用.关键词与逻辑, 词性, new HashSet<>()));
                逻辑idSet.addAll(MapUtils.getObject(静态引用.关键词与逻辑, 属于, new HashSet<>()));
                //执行处理逻辑
                执行处理逻辑(new ArrayList<>(逻辑idSet), 句子成分);
            }
        }
    }

    public void 执行处理逻辑(List<Integer> list,Document 句子成分){
        Collections.sort(list);
        for(Integer id:list){
            处理句子(id,句子成分);
        }
    }

    public void 处理句子(Integer 逻辑键,Document 原句子成分){
        Document 句子成分 = Tool.代词的最终指向(原句子成分);
        //获取已经格式化好的逻辑对象 并转成Document
        静态引用.逻辑句子对象 = JSON.parseArray(静态引用.所有逻辑句子对象.get(逻辑键), Document.class).get(0);
        静态引用.逻辑句子的成分集合 = JSON.parseArray(静态引用.所有逻辑句子成分对象.get(逻辑键), Document.class);
        //开始处理每个逻辑成分
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size() ; i++) {
            Document 逻辑成分 = 静态引用.逻辑句子的成分集合.get(i);
            String 动作 = 逻辑成分.getString(Cons.词语);
            invokeLuoji.执行逻辑(动作, 逻辑成分, 句子成分, 原句子成分);
        }
        List<Document> 输入句子的成分集合 = 静态引用.输入句子的成分集合;
        Document 逻辑句子对象 = 静态引用.逻辑句子对象;
        Document 输入的句子对象 = 静态引用.输入的句子对象;
        List<Document> 逻辑句子的成分集合 = 静态引用.逻辑句子的成分集合;

    }

    public void 重置输入句子成分(){
        静态引用.输入句子的成分集合.clear();
        Document 成分对象 = new Document();
        成分对象.put(Cons._id, new ObjectId());
        成分对象.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
        成分对象.put(Cons.词语, "合并");
        成分对象.put(Cons.下标, 0);
        成分对象.put(Cons.结束下标, 2);
        静态引用.输入句子的成分集合.add(成分对象);
        Document 成分对象2 = new Document();
        成分对象2.put(Cons._id, new ObjectId());
        成分对象2.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
        成分对象2.put(Cons.词语, "为");
        成分对象2.put(Cons.下标, 2);
        成分对象2.put(Cons.结束下标, 3);
        静态引用.输入句子的成分集合.add(成分对象2);
    }

}
