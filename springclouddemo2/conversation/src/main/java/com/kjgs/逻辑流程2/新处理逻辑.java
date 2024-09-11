package com.kjgs.逻辑流程2;

import com.beust.ah.A;
import com.kjgs.conversation.mysql.mapper.词性Mapper;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.词性实体;
import com.kjgs.算法.组装句子中由词性组成的句子Service;
import com.kjgs.逻辑流程.执行逻辑;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class 新处理逻辑 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private 词性Mapper 词性Mapper;

    @Autowired
    private 逻辑Mapper 逻辑Mapper;

    @Autowired
    private 组装句子中由词性组成的句子Service 组装句子中由词性组成的句子Impl;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    /**
     * 基于mysql
     * 对话语句录入到输入表
     * 输入的句子 的成分分析是放在内存中的，不是是存库的
     * 对句子的分析是基于逻辑表的
     *
     *  1，第一步先划分句子，这一步有代码内置固定方法完成。
     *     划分的句子，组成词性，到逻辑表中找处理逻辑。
     *     然后执行逻辑就行了。
     *     可能组成多个逻辑。大家独立线程，互补干扰。最后应该输出那个结果，有更高级的处理逻辑给出。
     */

    public Map<String, List<String>> 获取句子中所有词性(String 句子){
        List<词性实体> 词性集合 = 词性Mapper.查询词性(句子);
        Map<String, List<String>> map = 词性集合.stream()
                .collect(Collectors.toMap(词性实体::get词语,
                        s -> {
                            List<String> 词性List = new ArrayList<>();
                            词性List.add(s.词性);
                            return 词性List;
                        },
                        (List<String> v1, List<String> v2) -> {
                            v1.addAll(v2);
                            return v1;
                        }));
        return map;
    }

    public void 组装句子中由词性组成的句子(String 句子, Map<String, List<String>> 词语词性集合){
        组装句子中由词性组成的句子Impl.组装句子中由词性组成的句子(句子, 词语词性集合);
    }

    public List<String> 根据词性句子找到对应处理逻辑(){
        if(CollectionUtils.isNotEmpty(组装句子中由词性组成的句子Service.res)){
            return 逻辑Mapper.根据多个逻辑名查询List(组装句子中由词性组成的句子Service.res);
        }else{
            return new ArrayList<>();
        }
    }

    public void process(String 句子){
        Map<String, List<String>> 获取句子中所有词性 = 获取句子中所有词性(句子);
        组装句子中由词性组成的句子(句子, 获取句子中所有词性);
        List<String> 所有逻辑集合 = 根据词性句子找到对应处理逻辑();
        执行词性处理逻辑(所有逻辑集合);
    }
    static ThreadLocal<List<Document>> threadLocal = new ThreadLocal<>();
    public void 执行词性处理逻辑(List<String> 所有逻辑集合){
        threadLocal.set(执行逻辑Impl.所有逻辑对象);
        for(String 逻辑:所有逻辑集合){
            new Thread(() -> {
                执行逻辑Impl.执行逻辑(逻辑, threadLocal.get()==null?new ArrayList<Document>():threadLocal.get());
            }).start();
        }
    }
}
