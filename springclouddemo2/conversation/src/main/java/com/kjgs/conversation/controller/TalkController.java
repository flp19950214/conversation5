package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation.service.Service逻辑处理;
import com.kjgs.conversation.service.TalkService;
import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能对象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.数据库.MongoCRUDDao;
import com.kjgs.枚举.Cons;
import com.kjgs.算法.工具;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import com.kjgs.静态变量;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
public class TalkController {

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Autowired
    private Impl逻辑 逻辑MapperImpl;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @Autowired
    private 功能对象 功能对象impl;

    @Autowired
    private TalkService talkService;

    @Autowired
    private MongoCRUDDao mongoCRUDDao;

    @Autowired
    private Service逻辑处理 service逻辑处理;


    public static String 成分执行阶段 = null;
    /**
     * 新策略
     * 分词逻辑 动作逻辑 输出逻辑
     *  处理句子 和 处理逻辑
     * @param input
     * @return
     */
    @PostMapping("/process1")
    public Object process1(@RequestBody JSONObject input) {
        return process(input);
    }

    /**
     * 新策略，压力给到输出逻辑
     * 遍历每个词的逻辑，主要做分词功能
     * 最后执行输出逻辑，这将是个很长很长的判断
     */
    @PostMapping("/process")
    public Object process(@RequestBody JSONObject input) {
        静态变量.执行层级集合 = new ArrayList<>();
        静态变量.逻辑实体执行链路 = new ArrayList<>();
        静态变量.逻辑执行链路 = new ArrayList<>();
        执行逻辑.所有逻辑对象 = new ArrayList<>();
        String 句子 = input.getString("input");
        Document 当前处理的句子 = new Document();
        当前处理的句子.put(Cons.输入的句子, 句子);
        mongoCRUDDao.保存对象(当前处理的句子);
        执行逻辑Impl.所有逻辑对象.add(当前处理的句子);
        Document 输入的句子的词语集合 = new Document();
        String[] 句子元素集合 = 句子.split("");
        输入的句子的词语集合.put(Cons.输入的句子的词语集合, 句子元素集合);
        执行逻辑Impl.所有逻辑对象.add(输入的句子的词语集合);
        if (StringUtils.isEmpty(句子)) {
            return "输入是空的";
        }
        //给每个词添加成句子成分
        for (int i = 0; i < 句子元素集合.length; i++) {
            String item = 句子元素集合[i];
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.对象类型, Cons.句子成分);
            成分对象.put(Cons.词语, item);
            成分对象.put(Cons.在句子中的下标, i);
            成分对象.put(Cons.在句子中的结束下标, 工具.strDdoubleToInt(i) + 1);
            执行逻辑Impl.所有逻辑对象.add(成分对象);

        }

        int level = 0;
        String uuidLevel = UUID.randomUUID().toString();
// 在成分变化的地方加上是否改变的标识符，如果有改变就还需要循环执行
        //执行词性逻辑
        List<Document> 句子成分集合 = ToolService.获取句子成分集合();
        成分执行阶段 =  Cons.词性逻辑;
        for (int i = 0; i < 句子成分集合.size(); i++) {
            Document 成分对象 = 句子成分集合.get(i);
            成分对象.put(Cons.是否是当前处理的句子成分, true);
            service逻辑处理.process(成分对象.getString(Cons.词语), Cons.词性逻辑, level, uuidLevel);
            成分对象.put(Cons.是否是当前处理的句子成分, false);
        }
        //执行分词逻辑
        成分执行阶段 =  Cons.分词逻辑;
        句子成分集合 = ToolService.获取句子成分集合();
        for (int i = 0; i < 句子成分集合.size(); i++) {
            Document 成分对象 = 句子成分集合.get(i);
            成分对象.put(Cons.是否是当前处理的句子成分, true);
            service逻辑处理.process(成分对象.getString(Cons.词语), Cons.分词逻辑, level, uuidLevel);
            成分对象.put(Cons.是否是当前处理的句子成分, false);
        }
        //执行动作逻辑
        成分执行阶段 =  Cons.动作逻辑;
        句子成分集合 = ToolService.获取句子成分集合();
        for (int i = 0; i < 句子成分集合.size(); i++) {
            Document 成分对象 = 句子成分集合.get(i);
            成分对象.put(Cons.是否是当前处理的句子成分, true);
            service逻辑处理.process(成分对象.getString(Cons.词语), Cons.动作逻辑, level, uuidLevel);
            成分对象.put(Cons.是否是当前处理的句子成分, false);
        }
        //执行输出逻辑
        成分执行阶段 =  Cons.输出逻辑;
        句子成分集合 = ToolService.获取句子成分集合();
        for (int i = 0; i < 句子成分集合.size(); i++) {
            Document 成分对象 = 句子成分集合.get(i);
            成分对象.put(Cons.是否是当前处理的句子成分, true);
            service逻辑处理.process(成分对象.getString(Cons.词语), Cons.输出逻辑, level, uuidLevel);
            成分对象.put(Cons.是否是当前处理的句子成分, false);
        }
//        talkService.执行输出结果逻辑();
        return 静态变量.输出的内容;
    }


    @PostMapping("/talk")
    public Object conversation(@RequestBody JSONObject input) {
        静态变量.执行层级集合 = new ArrayList<>();
        静态变量.逻辑实体执行链路 = new ArrayList<>();
        静态变量.逻辑执行链路 = new ArrayList<>();
        执行逻辑.所有逻辑对象 = new ArrayList<>();
        String 句子 = input.getString("input");
        int 处理位置 = 0;
        int 处理结束位置 = 1;
        while (处理结束位置 <= 句子.length()) {
            System.out.println("本次处理结束位置:" + 处理结束位置);
            String 词语 = 句子.substring(处理位置, 处理结束位置);
            新处理逻辑Impl.init(句子, 处理位置, 处理结束位置, 词语, false);
            新处理逻辑Impl.process(词语, 0);

            //开启下一轮
            Object 当前处理的词语结束位置 = 功能对象impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语结束位置);
            try {
                处理结束位置 = 工具.strDdoubleToInt(当前处理的词语结束位置);
            } catch (Exception e) {
                e.printStackTrace();
            }
            处理位置 = 处理结束位置;
            处理结束位置++;
        }

        //判断句子成分是否还有变化  没有变化了也就不用再反复执行了
        List<Document> 所有成分逻辑 = 执行逻辑.所有逻辑对象.stream().filter(m -> m.containsKey(Cons.对象类型) && m.containsValue(Cons.句子成分))
                .peek(m -> m.remove(Cons._id))
                .collect(Collectors.toList());
        执行逻辑.所有逻辑对象.clear();
        执行逻辑.所有逻辑对象.addAll(所有成分逻辑);
        while (!StringUtils.equals(JSON.toJSONString(所有成分逻辑), JSON.toJSONString(静态变量.上一层句子成分集合))) {
            静态变量.上一层句子成分集合 = 所有成分逻辑;
            //清空输出内容
            静态变量.输出的内容.clear();
            String str = "成分划分完毕，再次执行句子中的逻辑";
            System.err.println(str);
            静态变量.添加执行层级集合(String.format("%s %s", 0, str));
            新处理逻辑Impl.二次执行成分逻辑(句子);
        }

        talkService.记录当前输入句子();
        talkService.执行输出结果逻辑();
        return 静态变量.输出的内容;
    }


    @PostMapping("/testLogic")
    public Object testLogic(@RequestBody JSONObject input) {
        新处理逻辑Impl.init("123", 0, 1, "1", false);
        Document 是否执行判断结果 = new Document();
        是否执行判断结果.put(Cons.是否执行判断结果, "true");
        执行逻辑Impl.所有逻辑对象.add(是否执行判断结果);
        String 逻辑名 = input.getString("逻辑名");
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);

        Document 当前处理逻辑 = new Document();
        是否执行判断结果.put(Cons.当前处理逻辑, 逻辑Obj.逻辑);
        执行逻辑Impl.所有逻辑对象.add(当前处理逻辑);
        return result;
    }
}
