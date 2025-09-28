package com.kjgs.conversation4;

import com.kjgs.conversation3.Fixed;
import com.kjgs.conversation4.mapper.数据4Mapper;
import com.kjgs.conversation4.mapper.逻辑4Mapper;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController()
public class TalkController4 {

    @Autowired
    private 逻辑4Mapper impl逻辑4Mapper;

    @Autowired
    private 数据4Mapper impl数据4Mapper;

    @Autowired
    private ApplicationContext context;

    List<Document> list = new ArrayList<>();
    public static List<String> logList = new ArrayList<>();

    @PostMapping("/process5")
    public Object process(@RequestBody Document input) throws Exception {
        logList.clear();
        Fixed.输出的内容 = null;
        Fixed.处理流程.clear();

        String 输入的句子 = input.getString("input");
        Document document = new Document();
        document.put(Cons.输入的词语, input);
        list.add(document);
        Tool.printLog(String.format("输入的句子是: %s", 输入的句子));

        //保存
        impl数据4Mapper.insert(Cons.输入, 输入的句子);

        //找词语中包含的所有处理逻辑
        List<Document> 根据逻辑名查询逻辑 = impl逻辑4Mapper.根据逻辑名查询逻辑(输入的句子);
        Tool.printLog(String.format("输入句子的处理逻辑名有: %s",
                根据逻辑名查询逻辑.stream().map(m -> m.getString(Cons.逻辑名)).collect(Collectors.joining(Cons.comma))));

        Tool.printLog("---------开始执行逻辑-------------");
        //处理逻辑
        for (int i = 0; i < 根据逻辑名查询逻辑.size(); i++) {
            Tool.printLog(String.format("---------开始执行第%s个逻辑-------------", i + 1));
            Document document1 = 根据逻辑名查询逻辑.get(i);
            String 逻辑名 = document1.getString(Cons.逻辑名);
            List<String> 逻辑集合 = Arrays.asList(StringUtils.split(document1.getString(Cons.逻辑), Cons.comma));
            Tool.printLog(String.format("逻辑名: %s", 逻辑名));
            Tool.printLog(String.format("逻辑：%s", 逻辑集合));
            //循环执行逻辑 如果逻辑长度是1，那说明到底了，就反射执行内置逻辑
            Map<String, Object> map当前逻辑内存 = new HashMap<>();
            for (int j = 0; j < 逻辑集合.size(); j++) {
                递归处理逻辑(逻辑集合.get(j), map当前逻辑内存);
            }
        }
        Tool.printLog("---------执行逻辑结束-------------");
        return document;
    }

    private void 递归处理逻辑(String 逻辑名,Map<String, Object> map上层逻辑内存) throws Exception {
        Document 根据逻辑名查询逻辑 = impl逻辑4Mapper.根据逻辑名查询最新逻辑(逻辑名);
        List<String> 逻辑集合 = Arrays.asList(StringUtils.split(根据逻辑名查询逻辑.getString(Cons.逻辑), Cons.comma));
        Map<String, Object> map当前逻辑内存 = new HashMap<>();
        //递归执行
        for (int i = 0; i < 逻辑集合.size(); i++) {
            if (逻辑集合.size() == 1) {
                处理句子中的词语(逻辑集合,map上层逻辑内存, map当前逻辑内存);
                return;
            } else {
                递归处理逻辑(逻辑集合.get(i),map当前逻辑内存);
            }
        }
    }

    private void 处理句子中的词语(List<String> 逻辑,Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {
        for (int i = 0; i < 逻辑.size(); i++) {
            invoke(逻辑.get(i), map上层逻辑内存, map当前逻辑内存);
        }
    }

    public void invoke(String 动作,Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {

        FuncAbstract4 funcAbstract4 = (FuncAbstract4)
                context.getBean(Class.forName("com.kjgs.conversation4.func." + 动作));
        funcAbstract4.method(map上层逻辑内存, map当前逻辑内存);

    }
}
