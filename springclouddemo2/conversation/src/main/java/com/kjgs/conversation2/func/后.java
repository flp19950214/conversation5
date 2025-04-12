package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class 后 extends FuncAbstract {

    /**
     * 分词后直接干活
     */
    @Override
    public void 功能() {
        String 方法名 = Tool.匹配某数字某格式(逻辑句子,下标, "后面第", "个名词");
        if(方法名 != null){
            后面第几个名词(方法名);
            return;
        }
        方法名 = Tool.匹配某数字某格式(逻辑句子,下标, "后面", "个成分");
        if(方法名 != null){
            后面几个成分(方法名);
            return;
        }
        方法名 = Tool.匹配某数字某格式(逻辑句子,下标, "后面", "个字");
        if(方法名 != null){
            后面几个字(方法名);
            return;
        }
    }



    public void 后面第几个名词(String method){
        //满足条件 合并果，创建新成分，删除旧成分
        int 结束下标 = 下标+method.length();
        逻辑成分.put(Cons.词语, method);
        逻辑成分.put(Cons.结束下标, 结束下标);
        int 量词 = Tool.转数字(StringUtils.substringBetween(method, "后面第","个名词"));
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
        找到后面1个名词并赋值指向(逻辑成分, 量词);
    }

    public void 找到后面1个名词并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标后面一个句子成分(句子下标, Cons.名词);
        if(新句子成分 != null){
            逻辑成分.put(Cons.指向,新句子成分);
        }
    }
    public void 后面几个成分(String method){
        //满足条件 合并果，创建新成分，删除旧成分
        int 结束下标 = 下标+method.length();
        逻辑成分.put(Cons.词语, method);
        逻辑成分.put(Cons.结束下标, 结束下标);
        int 量词 = Tool.转数字(StringUtils.substringBetween(method, "后面","个成分"));
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
        找到后面1个成分并赋值指向(逻辑成分, 量词);
    }

    public void 后面几个字(String method){
        //满足条件 合并果，创建新成分，删除旧成分
        int 结束下标 = 下标+method.length();
        逻辑成分.put(Cons.词语, method);
        逻辑成分.put(Cons.结束下标, 结束下标);
        int 量词 = Tool.转数字(StringUtils.substringBetween(method, "后面","个字"));
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
        找到后面某个字并赋值指向(逻辑成分, 量词);
    }
    public void 找到后面1个成分并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标后面一个句子成分(句子下标);
        if(新句子成分 != null){
            逻辑成分.put(Cons.指向,新句子成分);
        }
    }

    public void 找到后面某个字并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = new Document();
        StringBuffer 词语 = new StringBuffer();
        for (int i = 0; i < num ; i++) {
            if( 句子结束下标 + i +1 > 句子.length()){
                return;
            }
            词语.append(句子.substring(句子结束下标+i, 句子结束下标 + i +1));
        }
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, 词语.toString());
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子结束下标 + num );
        新句子成分.put(Cons.是否是句子成分, true);
        逻辑成分.put(Cons.指向,新句子成分);
    }

}
