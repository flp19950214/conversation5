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
public class 合并为 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        合并为几个词();
    }

    public void 合并为几个词(){
        Document 指定下标前面的包含并列集合的逻辑成分 = Tool.指定下标前面包含某key的逻辑成分(下标, Cons.并列集合);
        if(指定下标前面的包含并列集合的逻辑成分 == null){
            指定下标前面的包含并列集合的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        }
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        Document 指定下标的下下一个逻辑成分 = Tool.指定下标的下下一个逻辑成分(下标);
        if(指定下标前面的包含并列集合的逻辑成分 == null || 指定下标后面的逻辑成分 == null || 指定下标的下下一个逻辑成分==null){
            return;
        }
        if(StringUtils.isEmpty(指定下标后面的逻辑成分.getString(Cons.词语)) ||
                !指定下标后面的逻辑成分.getString(Cons.词语).matches("-?\\d+(\\.\\d+)?")){
            return;
        }
        if(!StringUtils.equals(指定下标的下下一个逻辑成分.getString(Cons.词语), "个词")){
            return;
        }
        boolean 前面是之间的内容就优先合并前面词语 = 前面是之间的内容就优先合并前面词语();
        if(前面是之间的内容就优先合并前面词语){
            return;
        }
        //满足条件 合并前面的多对象成分
        Document 合并结果 = 合并前面成分中的并列对象(指定下标前面的包含并列集合的逻辑成分);
        if(合并结果 != null){
            逻辑成分.put(Cons.动作结果, 合并结果.get(Cons.词语));
            逻辑成分.put(Cons.合并的结果, 合并结果);
        }
    }

    public boolean 前面是之间的内容就优先合并前面词语(){
        Document 指定下标前面的逻辑成分_无迭代 = Tool.指定下标前面的逻辑成分_无迭代(下标);
        if(指定下标前面的逻辑成分_无迭代 == null){
            return false;
        }
        if(!StringUtils.equalsAny(指定下标前面的逻辑成分_无迭代.getString(Cons.词语), "之间的内容","后面的内容","前面的内容")){
            return false;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Tool.添加句子成分(指定下标前面的逻辑成分);
        return true;
    }
    public Document 合并前面成分中的并列对象(Document 指定下标前面的包含并列集合的逻辑成分){
        if(!指定下标前面的包含并列集合的逻辑成分.containsKey(Cons.并列集合)){
            return null;
        }
        List<Document> 子成分 = 指定下标前面的包含并列集合的逻辑成分.get(Cons.并列集合, List.class);
        Tool.刷新集合中代词的最终指向(子成分);
        StringBuffer 词语 = new StringBuffer();
        for(Document document:子成分){
            词语.append(document.getString(Cons.词语));
        }
        //合并 新句子成分的 对象要都是句子成分
        //子成分中包含非句子成分就不能合并新句子成分
        if(子成分.stream().filter(m -> !m.containsKey(Cons.是否是句子成分)
              || m.getBoolean(Cons.是否是句子成分)==false).count()>0){
            return null;
        }
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, 词语.toString());
        int 下标 = 子成分.get(0).getInteger(Cons.下标);
        int 结束下标 = 子成分.get(子成分.size()-1).getInteger(Cons.结束下标);
        新句子成分.put(Cons.下标, 下标);
        新句子成分.put(Cons.结束下标, 结束下标);
        新句子成分.put(Cons.是否是句子成分, true);
        //校验词语 要跟下标和结束下标的长度相匹配
        if(新句子成分.getString(Cons.词语).length() > 结束下标-下标 ){
            词语 = new StringBuffer(新句子成分.getString(Cons.词语).substring(0,结束下标-下标));
            System.out.println("校验词语 要跟下标和结束下标的长度相匹配："+ 新句子成分.getString(Cons.词语));
        }
        新句子成分.put(Cons.词语, 词语.toString());
        Tool.添加句子成分(新句子成分);
        return 新句子成分;
    }
}
