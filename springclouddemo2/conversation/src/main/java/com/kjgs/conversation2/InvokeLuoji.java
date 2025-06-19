package com.kjgs.conversation2;

import com.kjgs.启动执行包.获取所有功能名;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class InvokeLuoji {
    @Autowired
    private ApplicationContext context;

    public void 执行逻辑(String 动作, Document 逻辑成分, Document 句子成分, Document 原句子成分) throws IngoreException{
        if(Tool.是否数字(动作)){
            逻辑成分.put(Cons.词性, Cons.数字);
        }
        if(StringUtils.equals(动作, Cons.左尖括号)){
            invoke( Cons.左尖括号_名字, 逻辑成分, 句子成分, 原句子成分);
            return;
        }
        动作 = 修改动作名(动作);
        if(!获取所有功能名.funcList.contains(动作)){
            静态引用.上个逻辑后面能否跟内置动作 = true;
            return;
        }
        invoke(动作, 逻辑成分, 句子成分, 原句子成分);

    }

    public void invoke( String 动作, Document 逻辑成分, Document 句子成分, Document 原句子成分) throws IngoreException {
        try {
            FuncAbstract funcAbstract = (FuncAbstract)
                    context.getBean(Class.forName("com.kjgs.conversation2.func." + 动作));
            funcAbstract.执行流程( 逻辑成分, 句子成分, 原句子成分);
            静态引用.上个逻辑后面能否跟内置动作 = funcAbstract.后面能否跟内置动作;
        }catch (IngoreException e){
            throw new IngoreException(e.getMessage());
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String 修改动作名(String 动作){
        if(动作.startsWith("后面") && 动作.endsWith("个字")){
            动作 = "后面某个字";
        }else if(动作.startsWith("后面") && 动作.endsWith("个成分")){
            动作 = "后面某个成分";
        }else if(动作.startsWith("再后面") && 动作.endsWith("个成分")){
            动作 = "再后面某个成分";
        }else if(动作.startsWith("后面第") && 动作.endsWith("某个名词")){
            动作 = "后面第某个名词";
        }else if(动作.startsWith("前面") && 动作.endsWith("个字")){
            动作 = "前面某个字";
        }else if(动作.startsWith("前面") && 动作.endsWith("个成分")){
            动作 = "前面某个成分";
        }
        return 动作;
    }
}
