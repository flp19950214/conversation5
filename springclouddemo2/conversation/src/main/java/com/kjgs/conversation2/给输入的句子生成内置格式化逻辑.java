package com.kjgs.conversation2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class 给输入的句子生成内置格式化逻辑 {
    @Autowired
    Impl逻辑 impl逻辑;

    @Autowired
    private 启动执行初始化数据 impl启动执行初始化数据;

    /**
     * 只要句子是假设句就行
     * 然后就是给每个成分加上《》
     * 最后拼在一起
     * 然后保存即可
     */
    public void 生成格式化逻辑(){
        Document 输入的句子对象 = 静态引用.输入的句子对象;
        List<Document> 输入句子的成分集合 = 静态引用.输入句子的成分集合;
//        if(!输入的句子对象.containsKey(Cons.句型)){
//        return;
//        }
        String 新逻辑 = 生成格式化逻辑(输入句子的成分集合);
        if(StringUtils.isEmpty(新逻辑)){
            return;
        }
        if(!(StringUtils.contains(新逻辑, "《如果》")
            && StringUtils.contains(新逻辑,"《那就》"))){
            return;
        }
        保持并刷新逻辑(新逻辑);
    }

    public void 保持并刷新逻辑(String 新逻辑){
        impl逻辑.保存逻辑(新逻辑);
        impl启动执行初始化数据.加载单个逻辑(静态引用.获取所有逻辑键的最大值()+1, 新逻辑);
    }

    public String 生成格式化逻辑(List<Document> 输入句子的成分集合){
        输入句子的成分集合 = 输入句子的成分集合.stream()
                .sorted(Comparator.comparing(a -> a.getInteger(Cons.新成分的处理逻辑下标), Comparator.nullsFirst(Integer::compareTo)))
                .collect(Collectors.toList());
        //找到每个成分的最后结构即可
        List<int[]> dataList = new ArrayList<>();
        List<Document> result = new ArrayList<>();
        for (int i = 输入句子的成分集合.size()-1; i >=0; i--) {
            Document document = 输入句子的成分集合.get(i);
            if(document.containsKey(Cons.下标) && document.containsKey(Cons.结束下标)
                    && document.containsKey(Cons.词语)
            ){
                int 下标 = document.getInteger(Cons.下标);
                int 结束下标 = document.getInteger(Cons.结束下标);
                int[] data = {下标, 结束下标};
                if(!是否在已处理区间(下标, 结束下标, dataList)){
                    result.add(document);
                }
                dataList.add(data);
            }
        }
        //排序
        result = result.stream().sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .collect(Collectors.toList());
        StringBuilder 新逻辑 = new StringBuilder();
        for(Document m : result){
            新逻辑.append(Cons.左尖括号).append(m.getString(Cons.词语)).append(Cons.右尖括号);

        }
        return 新逻辑.toString();
    }


    public boolean 是否在已处理区间(int 下标, int 结束下标, List<int[]> dataList){
        for(int[] m : dataList){
            int one = m[0];
            int two = m[1];
            if((one<=下标 && 下标 < two) || (one<结束下标 && 结束下标 < two) || (下标<one && 结束下标>=two)){
                return true;
            }
        }
        return false;
    }
}
