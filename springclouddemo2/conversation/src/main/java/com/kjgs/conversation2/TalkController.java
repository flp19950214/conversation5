package com.kjgs.conversation2;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TalkController {

    @PostMapping("/process3")
    public Object process(@RequestBody JSONObject input) {
        List<Document> 输入句子的元素集合 = new ArrayList<>();
        String 输入的句子 = input.getString("input");
        静态引用.输入的句子对象 = new Document();
        静态引用.输入的句子对象.put(Cons._id, new ObjectId());
        静态引用.输入的句子对象.put(Cons.输入的句子, 输入的句子);
        String[] 输入的句子元素集合 = 输入的句子.split("");
        //给每个词添加成句子成分
        for (int i = 0; i < 输入的句子元素集合.length; i++) {
            String item = 输入的句子元素集合[i];
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
            成分对象.put(Cons.词语, item);
            成分对象.put(Cons.在句子中的下标, i);
            成分对象.put(Cons.在句子中的结束下标, i + 1);
            静态引用.输入句子的成分集合.add(成分对象);
        }

        List<Document> 逻辑句子的元素集合 = new ArrayList<>();
        String 逻辑句子 = "如果";
        静态引用.逻辑句子对象 = new Document();
        静态引用.逻辑句子对象.put(Cons._id, new ObjectId());
        静态引用.逻辑句子对象.put(Cons.逻辑句子, 逻辑句子);
        String[] 逻辑句子元素集合 = 逻辑句子.split("");
        //给每个词添加成句子成分
        for (int i = 0; i < 逻辑句子元素集合.length; i++) {
            String item = 逻辑句子元素集合[i];
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.父id, 静态引用.逻辑句子对象.get(Cons._id));
            成分对象.put(Cons.词语, item);
            成分对象.put(Cons.在句子中的下标, i);
            成分对象.put(Cons.在句子中的结束下标, i + 1);
            静态引用.逻辑句子的成分集合.add(成分对象);
        }

        //开始处理每个逻辑成分


        return null;
    }
}
