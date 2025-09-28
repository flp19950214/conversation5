package com.kjgs.conversation3;

import com.kjgs.conversation3.mapper.DoneMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TalkController3 {

    @Autowired
    private DoneMapper doneMapper;

    @Autowired
    private ApplicationContext context;

    @PostMapping("/process4")
    public Object process(@RequestBody Document input) {
        Fixed.输出的内容=null;
        Fixed.处理流程.clear();

        String 输入的句子 = input.getString("input");
        DoneModel doneModel = new DoneModel();
        doneModel.词语=Dict.输入;
        doneModel.属性=Dict.内容;
        doneModel.属性值=输入的句子;
        doneMapper.保存(doneModel);
        Fixed.输入句子id = doneModel.id;

        List<String> 句子中的所有词语List = doneMapper.查出在句子中的所有词语(输入的句子);
        Fixed.处理流程.add(String.format("输入的句子在库中出现过的词语有=%s", 句子中的所有词语List));
        //循环处理句子，当前输出的结果不再变化，就结束循环，最少循环3词
        String 临时输出内容;
        int n = 1;
        do {
            临时输出内容 = Fixed.输出的内容;
            处理句子中的词语(句子中的所有词语List);
            Fixed.处理流程.add(String.format("---第%s遍处理句子中的词语结束---", n));
            n++;
        } while (StringUtils.equals(临时输出内容, Fixed.输出的内容) && n < 4);
        Document document = new Document();
        document.put("输出的内容", Fixed.输出的内容);
        document.put("处理流程", Fixed.处理流程);
        return document;
    }

    private void 处理句子中的词语(List<String> 句子中的所有词语List) {
        if (CollectionUtils.isEmpty(句子中的所有词语List)) {
            Fixed.输出的内容 = "输入的句子中的词语没有在库中出现过,所以无法处理";
        }
        for (int i = 0; i < 句子中的所有词语List.size(); i++) {
            invoke(句子中的所有词语List.get(i));
        }
        invoke(Dict.输出);
    }

    public void invoke(String 动作) {
        try {
            FuncAbstract2 funcAbstract = (FuncAbstract2)
                    context.getBean(Class.forName("com.kjgs.conversation3.func." + 动作));
            funcAbstract.method();
        } catch (ClassNotFoundException e) {
            return;
        }
    }
}
