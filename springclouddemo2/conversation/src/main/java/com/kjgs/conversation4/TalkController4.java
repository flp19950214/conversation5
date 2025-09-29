package com.kjgs.conversation4;

import com.kjgs.conversation3.Fixed;
import com.kjgs.conversation4.mapper.数据4Mapper;
import com.kjgs.conversation4.mapper.逻辑4Mapper;
import org.apache.commons.collections4.MapUtils;
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

    public Document 输入词语对象 = new Document();

    public static List<String> logList = new ArrayList<>();

    @PostMapping("/process5")
    public Object process(@RequestBody Document input) throws Exception {
        logList.clear();
        Fixed.输出的内容 = null;
        Fixed.处理流程.clear();

        String 输入的句子 = input.getString("input");
        输入词语对象.put(Cons.输入的词语, 输入的句子);
        Tool.printLog(String.format("输入的句子是: %s", 输入的句子));

        //保存
        impl数据4Mapper.insert(Cons.输入, 输入的句子);

        //找词语中包含的所有处理逻辑
        List<Document> 根据逻辑名查询逻辑 = impl逻辑4Mapper.根据逻辑名查询逻辑(输入的句子);
        Tool.printLog(String.format("输入句子的处理逻辑名有: %s",
                根据逻辑名查询逻辑.stream().map(m -> m.getString(Cons.逻辑名)).collect(Collectors.joining(Cons.comma))));

        //把逻辑名放到输入句子对象中，并赋值下标
        List<Document> 逻辑集合 = set输入句子的词语元素(输入词语对象, 根据逻辑名查询逻辑);

        Tool.printLog("---------开始执行逻辑-------------");
        //处理逻辑
        for (int i = 0; i < 逻辑集合.size(); i++) {
            Tool.printLog(String.format("---------开始执行第%s个逻辑-------------", i + 1));
            Document 当前逻辑 = 逻辑集合.get(i);
            String 逻辑名 = 当前逻辑.getString(Cons.逻辑名);
            String[] 逻辑 = 当前逻辑.getString(Cons.逻辑).split(Cons.comma);
            List<String> 逻辑分割集合 = Arrays.asList(逻辑);
            Tool.printLog(String.format("逻辑名: %s", 逻辑名));
            Tool.printLog(String.format("逻辑：%s", 逻辑分割集合));
            //循环执行逻辑 如果逻辑长度是1，那说明到底了，就反射执行内置逻辑
            Map<String, Object> map当前逻辑内存 = new HashMap<>();
            for (int j = 0; j < 逻辑分割集合.size(); j++) {
                递归处理逻辑(当前逻辑, 逻辑分割集合.get(j), map当前逻辑内存);
            }
        }
        Tool.printLog("---------执行逻辑结束-------------");
        return 输入词语对象;
    }

    private void 递归处理逻辑(Document 当前逻辑, String 逻辑名,Map<String, Object> map上层逻辑内存) throws Exception {
        Document 根据逻辑名查询逻辑 = impl逻辑4Mapper.根据逻辑名查询最新逻辑(逻辑名);
        if(根据逻辑名查询逻辑 == null){
            throw new Exception(String.format("逻辑名是：%s没有处理逻辑（可能是没有设置底层处理逻辑）", 逻辑名));
        }
        List<String> 逻辑集合 = Arrays.asList(StringUtils.split(根据逻辑名查询逻辑.getString(Cons.逻辑), Cons.comma));
        Map<String, Object> map当前逻辑内存 = new HashMap<>();
        //递归执行
        for (int i = 0; i < 逻辑集合.size(); i++) {
            if (逻辑集合.size() == 1) {
                处理句子中的词语(当前逻辑,逻辑集合,map上层逻辑内存, map当前逻辑内存);
                return;
            } else {
                递归处理逻辑(当前逻辑,逻辑集合.get(i),map当前逻辑内存);
            }
        }
    }

    private void 处理句子中的词语(Document 当前逻辑,List<String> 逻辑,Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {
        for (int i = 0; i < 逻辑.size(); i++) {
            invoke(当前逻辑,逻辑.get(i), map上层逻辑内存, map当前逻辑内存);
        }
    }

    public void invoke(Document 当前逻辑, String 动作,Map<String, Object> map上层逻辑内存, Map<String, Object> map当前逻辑内存) throws Exception {
        FuncAbstract4 funcAbstract4 = (FuncAbstract4)
                context.getBean(Class.forName("com.kjgs.conversation4.func." + 动作));
        funcAbstract4.当前逻辑=当前逻辑;
        funcAbstract4.map上层逻辑内存=map上层逻辑内存;
        funcAbstract4.map当前逻辑内存=map当前逻辑内存;
        funcAbstract4.method();
    }

    public List<Document> set输入句子的词语元素(Document 输入词语对象, List<Document> 根据逻辑名查询逻辑){
        String input = MapUtils.getString(输入词语对象, Cons.输入的词语);
        List<Document> 逻辑集合 = new ArrayList<>();
        for(Document 逻辑对象 : 根据逻辑名查询逻辑){
            String 逻辑名 = 逻辑对象.getString(Cons.逻辑名);
            String 逻辑 = 逻辑对象.getString(Cons.逻辑);
            List<Integer> indexList = searchAllIndex(input, 逻辑名);
            for(Integer index : indexList){
                Document 元素对象 = new Document();
                元素对象.put(Cons.下标, index);
                元素对象.put(Cons.逻辑名, 逻辑名);
                元素对象.put(Cons.逻辑, 逻辑);
                逻辑集合.add(元素对象);
            }
        }
        输入词语对象.put(Cons.逻辑集合, 逻辑集合);
        return 逻辑集合;
    }

    private List<Integer> searchAllIndex(String str, String key) {
        List<Integer> indexList = new ArrayList<>();
        int a = str.indexOf(key);//*第一个出现的索引位置
        while (a != -1) {
            indexList.add(a);
            a = str.indexOf(key, a + 1);//*从这个索引往后开始第一个出现的位置
        }
        return indexList;
    }

}
