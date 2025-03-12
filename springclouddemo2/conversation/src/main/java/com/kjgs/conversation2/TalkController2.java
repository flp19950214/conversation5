package com.kjgs.conversation2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class TalkController2 {

    @Autowired
    private InvokeLuoji invokeLuoji;

    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;

    @PostMapping("/process3")
    public Object process(@RequestBody JSONObject input) {
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
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
            成分对象.put(Cons.词语, item);
            成分对象.put(Cons.下标, i);
            成分对象.put(Cons.结束下标, i + 1);
            静态引用.输入句子的成分集合.add(成分对象);
        }

        List<String> 所有逻辑 = 逻辑MapperImpl.查询所有逻辑();
//        //重置输入句子成分();
//        //查询所有逻辑
//        //测试指定逻辑
//        List<String> 所有逻辑 = new ArrayList(){{
//            add("如果遇到等，并且后面1个字是于，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到合，并且后面1个字是并，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到合并，并且后面1个字是为，那就把当前词和后面1个字合并为1个词");
//        }};

        List<Document> 输入句子的成分集合Temp;
        String before;
        String after;
        do{
            输入句子的成分集合Temp = 静态引用.输入句子的成分集合.stream().collect(Collectors.toList());
            for (int i = 0; i <所有逻辑.size() ; i++) {
                静态引用.逻辑句子的成分集合.clear();
                处理句子(所有逻辑.get(i));
            }
            before = JSON.toJSONString(输入句子的成分集合Temp);
            after = JSON.toJSONString(静态引用.输入句子的成分集合);
//            System.out.println(JSON.toJSONString(Tool.指定词语的逻辑成分("如果")));
        }while (!StringUtils.equals(before, after));
        System.out.println("最终的句子成分：");
        System.out.println(静态引用.输入句子的成分集合);
        System.out.println(after);
        return null;
    }

    public void 处理句子(String 逻辑句子){
        for (int j = 0; j <静态引用.输入句子的成分集合.size() ; j++) {
            Document 句子成分 = 静态引用.输入句子的成分集合.get(j);
//            String 逻辑句子 = "如果句子以是数字结尾，那就句子记录成处理逻辑";
            静态引用.逻辑句子对象 = new Document();
            静态引用.逻辑句子对象.put(Cons._id, new ObjectId());
            静态引用.逻辑句子对象.put(Cons.词语, 逻辑句子);
            静态引用.逻辑句子对象.put(Cons.词语类型, Cons.逻辑句子);
            String[] 逻辑句子元素集合 = 逻辑句子.split("");
            //给每个词添加成句子成分
            for (int i = 0; i < 逻辑句子元素集合.length; i++) {
                String item = 逻辑句子元素集合[i];
                Document 成分对象 = new Document();
                成分对象.put(Cons._id, new ObjectId());
                成分对象.put(Cons.父id, 静态引用.逻辑句子对象.get(Cons._id));
                成分对象.put(Cons.词语, item);
                成分对象.put(Cons.下标, i);
                成分对象.put(Cons.结束下标, i + 1);
                Tool.添加逻辑成分(成分对象);
            }
            String before = JSON.toJSONString(静态引用.逻辑句子的成分集合);
            处理逻辑(句子成分);
            String after = JSON.toJSONString(静态引用.逻辑句子的成分集合);
            while (!StringUtils.equals(before,after)){
                before = after;
                处理逻辑(句子成分);
                after = JSON.toJSONString(静态引用.逻辑句子的成分集合);
            }
            List<Document> 输入句子的成分集合 = 静态引用.输入句子的成分集合;
            Document 逻辑句子对象 = 静态引用.逻辑句子对象;
            Document 输入的句子对象 = 静态引用.输入的句子对象;
            List<Document> 逻辑句子的成分集合 = 静态引用.逻辑句子的成分集合;
        }

    }
    public void 处理逻辑(Document 句子成分){
        //开始处理每个逻辑成分
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size() ; i++) {
            Document 逻辑成分 = 静态引用.逻辑句子的成分集合.get(i);
            String 动作 = 逻辑成分.getString(Cons.词语);
            invokeLuoji.执行逻辑(动作, 逻辑成分, 句子成分);
        }
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
