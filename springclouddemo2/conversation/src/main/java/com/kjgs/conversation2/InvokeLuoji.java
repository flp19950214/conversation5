package com.kjgs.conversation2;

import com.kjgs.功能.功能抽象;
import com.kjgs.启动执行包.获取所有功能名;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class InvokeLuoji {
    @Autowired
    private ApplicationContext context;

    public void 执行逻辑(String 动作, Document 逻辑成分, Document 句子成分, Document 原句子成分){
        if(Tool.是否数字(动作)){
            逻辑成分.put(Cons.词性, Cons.数字);
        }
        if(StringUtils.equals(动作, Cons.左尖括号)){
            invoke(Cons.左尖括号_名字, 逻辑成分, 句子成分, 原句子成分);
            return;
        }
        if(!获取所有功能名.funcList.contains(动作)){
            return;
        }
        invoke(动作, 逻辑成分, 句子成分, 原句子成分);

    }

    public void invoke(String 动作, Document 逻辑成分, Document 句子成分, Document 原句子成分){
        try {
            FuncAbstract funcAbstract = (FuncAbstract)
                    context.getBean(Class.forName("com.kjgs.conversation2.func." + 动作));
            funcAbstract.执行流程(逻辑成分, 句子成分, 原句子成分);
        }catch (IngoreException e){
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
