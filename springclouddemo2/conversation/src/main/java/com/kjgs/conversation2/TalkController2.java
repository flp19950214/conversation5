package com.kjgs.conversation2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation.mysql.mapper.数据Mapper;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
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

    @Autowired
    private Impl数据 impl数据;

    @Autowired
    private 给输入句子生成内置句子成分 impl给输入句子生成内置句子成分;

    @Autowired
    private 给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    final int max = 10;

    @PostMapping("/process3")
    public Object process(@RequestBody JSONObject input) {
        静态引用.输出内容=null;
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

        List<String> 所有逻辑 = 逻辑MapperImpl.查询所有逻辑();
        //重置输入句子成分();
        //查询所有逻辑
        //测试指定逻辑
//        List<String> 所有逻辑 = new ArrayList(){{
//            add("如果遇到等，并且后面1个字是于，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到合，并且后面1个字是并，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到合并，并且后面1个字是为，那就把当前词和后面1个字合并为1个词");
//            add("如果当前词后面是是数字，那就记录如果遇到当前词，那就标记当前词的词性为数字");
//            add("如果遇到1，那就标记当前词的词性为数字");
//            add("如果遇到5，那就标记当前词的词性为数字");
//            add("如果遇到一，那就把当前词转义为1");
//            add("如果当前词的词性是数字，并且后面1个成分是加，那就把当前词作为后面1个成分的被加数");
//            add("如果当前词是加，并且后面1个成分的词性是数字，那就把后面1个成分作为当前词的加数");
//            add("如果遇到空格，那就标记当前词的是否是无用词为true");
//            add("如果遇到上，那就标记当前词的词性为方位词");
//            add("如果遇到话，那就标记当前词的词性为名词");
//            add("如果遇到话，那就标记当前词的偏移量为1");
//            add("如果当前词的词性是数字，那就标记后面第1个名词的数字为当前词");
//            add("如果遇到话，并且当前词的词性是名词，那就标记当前词的操作表为数据表");
//            add("如果遇到话，并且当前词的词性是名词，那就找到输入句子的数据表下标作为当前词的数据表下标");
//            add("如果当前词的词性是数字，并且前面1个成分的词性是方位词，那就标记后面第1个名词的偏移量尺寸为当前词");
//            add("如果遇到再，并且后面第1个名词是话，那就找到刚才输出的内容的数据表下标作为后面第1个名词的数据表下标");
//            add("如果遇到话，并且当前词的词性是名词，那就标记当前词的数据表类型为输入的句子");
//            add("如果当前词的词性是名词，并且后面3个字是是什么，那就输出当前词");
//            add("如果遇到再，并且后面第1个名词包含偏移量尺寸属性，那就给后面第1个名词的偏移量加后面第1个名词的偏移量尺寸");
//            add("如果句子是《你好》，那就输出《你也好》");
//            add("如果句子包含如果，并且句子包含那就，那就标记句子的《句型》为《假设句》");
//            add("如果句子的《句型》是《假设句》，那就把句子记录成处理逻辑");
//            add("如果句子的《句型》是《假设句》，并且句子包含说，那就把句子中的说替换为输出");
//            add("如果遇到要，并且后面1个字是是，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到《要是》，那就把当前词替换为如果");
//            add("如果遇到那，并且后面1个字是就，那就把当前词和后面1个字合并为1个词");

//            add("如果遇到输出，并且句子的句型是假设句，那就把当前词后面的内容合并为1个词");
//            add("如果遇到如，并且后面1个字是果，那就把当前词和后面1个字合并为1个词");
//            add("如果遇到遇，并且后面1个字是到，那就把当前词和后面1个字合并为1个词");
//            add("如果当前词是遇到，并且前面1个成分是如果，那就把当前词和后面1个分隔符之间的内容合并为1个词");
//        }};

        List<Document> 输入句子的成分集合Temp;
        String before;
        String after;
        int loopN=0;
        do{
            loopN++;
            输入句子的成分集合Temp = 静态引用.输入句子的成分集合.stream().collect(Collectors.toList());
            for (int i = 0; i <所有逻辑.size() ; i++) {
                静态引用.逻辑句子的成分集合.clear();
                处理句子(所有逻辑.get(i));
            }
            before = JSON.toJSONString(输入句子的成分集合Temp);
            after = JSON.toJSONString(静态引用.输入句子的成分集合);
        }while (!StringUtils.equals(before, after) && loopN<max);
//        最后再检查一次
        int loopN3=0;
        do{
            loopN3++;
             输入句子的成分集合Temp = 静态引用.输入句子的成分集合.stream().collect(Collectors.toList());
            for (int i = 0; i <所有逻辑.size() ; i++) {
                静态引用.逻辑句子的成分集合.clear();
                处理句子(所有逻辑.get(i));
            }
            before = JSON.toJSONString(输入句子的成分集合Temp);
            after = JSON.toJSONString(静态引用.输入句子的成分集合);
        }while (!StringUtils.equals(before, after) && loopN3<max);
        System.out.println("最终的句子成分：");
        System.out.println(静态引用.逻辑句子的成分集合);
        System.out.println(静态引用.输入句子的成分集合);
        System.out.println(after);
        impl数据.保存输入的数据对象(Tool.生成输入的对象(输入的句子));
        impl数据.保存输出的数据对象(Tool.生成输出的对象(静态引用.输出内容));
//        impl给输入句子生成内置句子成分.生成内置句子成分(输入的句子);
        impl给输入的句子生成内置格式化逻辑.生成格式化逻辑();
        return 静态引用.输出内容;
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
            int loopN=0;
            while (!StringUtils.equals(before,after) && loopN<10){
                loopN++;
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
    public void 处理逻辑(Document 原句子成分){
        Document 句子成分 = Tool.代词的最终指向(原句子成分);
        //先把重置判断逻辑
        静态引用.判断的结果=true;
        //开始处理每个逻辑成分
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size() ; i++) {
            Document 逻辑成分 = 静态引用.逻辑句子的成分集合.get(i);
            String 动作 = 逻辑成分.getString(Cons.词语);
            invokeLuoji.执行逻辑(动作, 逻辑成分, 句子成分, 原句子成分);
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
