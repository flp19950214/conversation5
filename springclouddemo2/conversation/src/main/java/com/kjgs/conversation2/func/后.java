package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class 后 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        // 初始化加载逻辑的目的是：要在形成逻辑的时候分割出其中的动态变量，所以加载初始化逻辑很有必要。。
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("如果遇到0，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到1，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到2，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到3，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到4，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到5，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到6，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到7，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到8，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到9，那就标记该词的词性为数字");
        impl逻辑.保存逻辑("如果遇到后，并且后面1个字是《面》，那就把当前词和后面1个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到后，并且后面2个字是《面第》，那就把当前词和后面2个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到后，并且后面4个字是《面的内容》，那就把当前词和后面4个字合并为1个词");
        impl逻辑.保存逻辑("如果当前词的词性是数字，并且前面1个成分是《后面》，并且后面1个成分是《个字》，那就把前面1个成分和当前词，再和后面1个成分合并为1个词");
        impl逻辑.保存逻辑("如果当前词的词性是数字，并且前面1个成分是《后面》，并且后面1个成分是《个成分》，那就把前面1个成分和当前词，再和后面1个成分合并为1个词");
        impl逻辑.保存逻辑("如果当前词的词性是数字，并且前面1个成分是《后面》，并且后面1个成分是《个分隔符》，那就把前面1个成分和当前词，再和后面1个成分合并为1个词");
        impl逻辑.保存逻辑("如果当前词的词性是数字，并且前面1个成分是《后面第》，并且后面1个成分是《个名词》，那就把前面1个成分和当前词，再和后面1个成分合并为1个词");
    }


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
        方法名 = Tool.匹配某数字某格式(逻辑句子,下标, "后面", "个分隔符");
        if(方法名 != null){
            后面几个分隔符(方法名);
            return;
        }
        方法名 = Tool.匹配开头(逻辑句子,下标, "后面的内容");
        if(方法名 != null){
            后面的内容(方法名);
            return;
        }
    }

    public void 后面的内容(String method){
        //满足条件 合并果，创建新成分，删除旧成分
        int 结束下标 = 下标+method.length();
        逻辑成分.put(Cons.词语, method);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
        //找到句子后面的内容，并赋值指向
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        if(句子结束下标>=句子.length()){return;}
        新句子成分.put(Cons.词语, 句子.substring(句子结束下标));
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子.length() );
        新句子成分.put(Cons.是否是句子成分, true);
        逻辑成分.put(Cons.指向,新句子成分);
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

    public void 后面几个分隔符(String method){
        //满足条件 合并果，创建新成分，删除旧成分
        int 结束下标 = 下标+method.length();
        逻辑成分.put(Cons.词语, method);
        逻辑成分.put(Cons.结束下标, 结束下标);
        int 量词 = Tool.转数字(StringUtils.substringBetween(method, "后面","个分隔符"));
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
        找到后面某个分隔符并赋值指向(逻辑成分, 量词);
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
    public void 找到后面某个分隔符并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        //往后找是分隔符的句子成分
        List<Document> 后面的句子成分 = Tool.根据键值对往后找句子成分(句子下标, Cons.是否具有分隔符功能, "true");
        if(CollectionUtils.isEmpty(后面的句子成分) || 后面的句子成分.size()<num || num==0){
            return;
        }
        逻辑成分.put(Cons.指向,后面的句子成分.get(num-1));
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
