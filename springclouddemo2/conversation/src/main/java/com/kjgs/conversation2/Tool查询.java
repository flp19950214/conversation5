package com.kjgs.conversation2;


import com.beust.ah.A;
import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.func.句子;
import com.kjgs.conversation2.model.Model数据;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Tool查询 {
    public static void main(String[] args) {
        Document document = new Document();
        document.put(Cons.方位词, Cons.后面);
        document.put(Cons.数字, 1);
        document.put(Cons.下标, 2);
        document.put(Cons.结束下标, 3);
        document.put(Cons.词性, Cons.名词);

        Document data1 = new Document();
        document.put(Cons.词语, "话");
        document.put(Cons.下标, 1);
        document.put(Cons.结束下标, 2);
        document.put(Cons.词性, Cons.名词);
        Document data2 = new Document();
        data2.put(Cons.词语, "话1");
        data2.put(Cons.下标, 11);
        data2.put(Cons.结束下标, 21);
        data2.put(Cons.词性, Cons.名词);
        Document data3 = new Document();
        data3.put(Cons.词语, "话2");
        data3.put(Cons.下标, 21);
        data3.put(Cons.结束下标, 32);
        data3.put(Cons.词性, Cons.名词);
        List<Document> list = new ArrayList<>();
        list.add(data1);
        list.add(data2);
        list.add(data3);
//        List<Document> 查询集合 = 查询集合(document, list);
        Document 查询集合 = 查询单个目标(document, document,list);
        System.out.println(查询集合);
    }

    @Autowired
    private Impl数据 impl数据;
    public Model数据 查询数据表单个目标(Document 句子成分) {
        List<Model数据> 数据表集合 = new ArrayList<>();
        if (句子成分.containsKey(Cons.操作库)) {
            if (StringUtils.equalsAny(句子成分.getString(Cons.操作库), Cons.数据表)) {
                数据表集合 = impl数据.查询所有数据();
            }
        }else{
            return null;
        }
        if(句子成分.containsKey(Cons.数据表类型) && 句子成分.get(Cons.数据表类型) != null){
            String 数据表类型 = 句子成分.get(Cons.数据表类型).toString();
            数据表集合 = 数据表集合.stream().filter(m -> m.containsKey(数据表类型))
                    .collect(Collectors.toList());
        }
        if (句子成分.containsKey(Cons.方位词)) {
            //注意 这里是逻辑成分的方位词  但是用的是句子成分的下标
            Integer 操作库下标 = 句子成分.getInteger(Cons.操作库下标);
            if(操作库下标 == null){
                操作库下标 = 数据表集合.size()-1;
            }
            Integer final操作库下标 = 操作库下标;
            if (StringUtils.equalsAny(句子成分.getString(Cons.方位词), Cons.后面,Cons.向后)) {
                数据表集合 = 数据表集合.stream()
                        .filter(m -> m.id > final操作库下标)
                        .collect(Collectors.toList());
            }else if(StringUtils.equals(句子成分.getString(Cons.方位词), Cons.向前)){
                数据表集合 = 数据表集合.stream()
                        .filter(m -> m.id < final操作库下标)
                        .collect(Collectors.toList());
            }
        }
        if (句子成分.containsKey(Cons.偏移量)) {
            Integer 序号 = Tool.转数字(句子成分.get(Cons.偏移量)+"");
            if(序号 != null){
                序号--;
                if(序号<数据表集合.size()){
                    return 数据表集合.get(序号);
                }
            }
        }
        return null;
    }

    public static Document 查询单个目标(Document 逻辑成分, Document 句子成分,List<Document> 句子成分集合) {
        if (逻辑成分.containsKey(Cons.方位词)) {
            //注意 这里是逻辑成分的方位词  但是用的是句子成分的下标
            int 下标 = 句子成分.getInteger(Cons.下标);
            if (StringUtils.equalsAny(逻辑成分.getString(Cons.方位词), Cons.后面,Cons.向后)) {
                句子成分集合 = 句子成分集合.stream()
                        .filter(m -> m.containsKey(Cons.下标))
                        .filter(m -> m.getInteger(Cons.下标) > 下标)
                        .collect(Collectors.toList());
            }else if(StringUtils.equals(逻辑成分.getString(Cons.方位词), Cons.向前)){
                句子成分集合 = 句子成分集合.stream()
                        .filter(m -> m.containsKey(Cons.下标))
                        .filter(m -> m.getInteger(Cons.下标) < 下标)
                        .collect(Collectors.toList());
            }
        }
        if (逻辑成分.containsKey(Cons.词性)) {
            String 词性 = 逻辑成分.getString(Cons.词性);
            句子成分集合 = 句子成分集合.stream()
                    .filter(m -> StringUtils.equalsAny(m.getString(Cons.词性), 词性))
                    .collect(Collectors.toList());
        }
        if (逻辑成分.containsKey(Cons.偏移量)) {
            Integer 序号 = Tool.转数字(逻辑成分.get(Cons.偏移量)+"");
            if(序号 != null){
                序号--;
                if(序号<句子成分集合.size()){
                    return 句子成分集合.get(序号);
                }
            }
        }
        return null;
    }
}
