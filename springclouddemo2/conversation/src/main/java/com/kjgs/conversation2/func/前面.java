package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 前面 extends FuncAbstract {
    public 前面(){
        后面能否跟内置动作=true;
        执行层级=1;
    }

    @Override
    public void 功能() {
        Document 后面一个成分 = Tool.指定下标后面的逻辑成分_无迭代(下标);
        Document 再后面一个成分 = Tool.指定下标后面的逻辑成分_无迭代(Tool.指定下标后面的逻辑成分_无迭代(下标).getInteger(Cons.下标));
        String 后面一个词语 = "";
        String 再后面一个词语 = "";
        if(后面一个成分!=null){
            后面一个词语=后面一个成分.getString(Cons.词语);
        }
        if(再后面一个成分!=null){
            再后面一个词语=再后面一个成分.getString(Cons.词语);
        }
        String method = "前面"+后面一个词语+再后面一个词语;
        if(StringUtils.equals(再后面一个词语, "个成分")){
            //满足条件 合并果，创建新成分，删除旧成分
            int 结束下标 = 下标+method.length();
            逻辑成分.put(Cons.词语, method);
            逻辑成分.put(Cons.结束下标, 结束下标);
            int 量词 = Tool.转数字(StringUtils.substringBetween(method, "前面","个成分"));
            Tool.删除指定下标的逻辑成分(后面一个成分.getInteger(Cons.下标));
            Tool.删除指定下标的逻辑成分(再后面一个成分.getInteger(Cons.下标));
            找到前面1个成分并赋值指向(逻辑成分, 量词);
        }else if(StringUtils.equals(再后面一个词语, "个字")){
            //满足条件 合并果，创建新成分，删除旧成分
            int 结束下标 = 下标+method.length();
            逻辑成分.put(Cons.词语, method);
            逻辑成分.put(Cons.结束下标, 结束下标);
            int 量词 = Tool.转数字(StringUtils.substringBetween(method, "前面","个字"));
            Tool.删除指定下标的逻辑成分(后面一个成分.getInteger(Cons.下标));
            Tool.删除指定下标的逻辑成分(再后面一个成分.getInteger(Cons.下标));
            找到前面某个字并赋值指向(逻辑成分, 量词);
        }
//        方法名 = Tool.匹配某数字某格式(逻辑句子,下标, "前面", "个属性是");
//        if(方法名 != null){
//            前面几个属性是(方法名);
//            return;
//        }

    }
//    public void 前面几个属性是(String method){//eg：前面1个属性是动作结果
//        //满足条件 合并果，创建新成分，删除旧成分
//        逻辑成分.put(Cons.词语, method);
//        int 结束下标 = 下标+method.length();
//        逻辑成分.put(Cons.结束下标, 结束下标);
//        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
//        int 量词 = Tool.转数字(StringUtils.substringBetween(method, "前面","个属性是"));
//        String 属性 = 指定下标的下下下一个逻辑成分.getString(Cons.词语);
//        找到前面某个属性并赋值指向(逻辑成分, 属性, 量词);
//    }


    public void 找到前面某个属性并赋值指向(Document 逻辑成分,String 属性, int num){
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, "");
        逻辑成分.put(Cons.指向,新句子成分);
        List<Document> 指定范围下标的句子成分 = Tool.获取指定范围下标的句子成分(0, 句子下标);
        for (Document document: 指定范围下标的句子成分) {
            if(document.containsKey(属性)){
                新句子成分.put(Cons.词语, document.get(属性));
                逻辑成分.put(Cons.指向,新句子成分);
                return;
            }
        }
    }
    public void 找到前面1个成分并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num > 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标前面一个句子成分(句子下标);
        if(新句子成分 != null){
            逻辑成分.put(Cons.指向,新句子成分);
        }
    }

    public void 找到前面某个字并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = new Document();
        StringBuffer 词语 = new StringBuffer();
        for (int i = num; i >0 ; i--) {
            if(句子下标-i<0){
                return;
            }
            词语.append(句子.substring(句子下标-i,句子下标-i+1));
        }
        新句子成分.put(Cons.词语, 词语.toString());
        新句子成分.put(Cons.下标, 句子下标-num);
        新句子成分.put(Cons.结束下标, 句子下标);
        新句子成分.put(Cons.是否是句子成分, true);

        逻辑成分.put(Cons.指向,新句子成分);
    }
}
