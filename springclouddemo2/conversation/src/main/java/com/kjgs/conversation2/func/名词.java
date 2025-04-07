package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查询;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 名词 extends FuncAbstract {
    @Override
    public void 功能() {
//        执行查询功能并赋值指向();
    }

//    public void 执行查询功能并赋值指向() {
//        //查询的对象是句子的成分集合
//        //查询的条件在当前处理的逻辑成分中
//        Document 查询单个目标 = Tool查询.查询单个目标(逻辑成分, 句子成分,静态引用.输入句子的成分集合);
//        if (查询单个目标 != null) {
//            逻辑成分.put(Cons.指向, 查询单个目标);
//        }
//    }

//    public void 执行查询功能并赋值指向() {
//        List<Document> 查询集合 = Tool查询.查询集合(句子成分, 静态引用.输入句子的成分集合);
//        if (CollectionUtils.isEmpty(查询集合)) {
//            return;
//        }
//        if (查询集合.size() == 1) {
//            逻辑成分.put(Cons.指向, 查询集合.get(0));
//        } else {
//            逻辑成分.put(Cons.指向, 查询集合);
//        }
//    }
}
