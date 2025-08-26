package com.kjgs.conversation2;

import com.alibaba.fastjson2.JSON;
import com.kjgs.conversation2.func.句子;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tool {

    public static String 优先获取词性(Document document){
        //成立
        if(document.containsKey(Cons.词性)){
            return document.getString(Cons.词性);
        }else{
            return document.getString(Cons.词语);
        }
    }

    public static boolean 检查成分是否在句子成分集合中(Document document){
        List<String> objectIdList = 静态引用.输入句子的成分集合.stream().map(m -> m.getObjectId(Cons._id).toString()).collect(Collectors.toList());
        String objectId = document.getObjectId(Cons._id).toString();
        return objectIdList.contains(objectId);
    }

    public static String 获取句子词性组成(List<Document> 成分集合){
        List<String> 句型组成=new ArrayList<>();
        for(Document document : 成分集合){
            句型组成.add(Tool.优先获取词性(document));
        }
        return String.format(Cons.竖杠, 句型组成);
    }

    public static List<Document> 获取干净的句子成分(List<Document> 成分集合) {
        //找出最靠后的每个词组组合，就是句子的词性组成。有限词性 再是词组
        //排序 现根据结束下标排序，再根据下标排序
        成分集合 = 成分集合.stream()
                .sorted(Comparator.comparing((Document m1) -> m1.getInteger(Cons.结束下标), Comparator.nullsLast(Integer::compareTo).reversed())
                        .thenComparing(m1 -> m1.getObjectId(Cons._id), Comparator.nullsLast(ObjectId::compareTo).reversed()))
                .collect(Collectors.toList());
        //创建两个变量用来记录成分位置是否已经被占领
        int tempEndIndex = Integer.MAX_VALUE;
        int tempStartIndex = Integer.MAX_VALUE;
        List<String> 句型组成 = new ArrayList<>();
        List<Document> 过滤后的成分 = new ArrayList<>();
        for (Document document : 成分集合) {
            int 结束下标 = document.getInteger(Cons.结束下标);
            int 下标 = document.getInteger(Cons.下标);
            if (结束下标 < tempEndIndex && 下标 < tempStartIndex) {
                //成立
                句型组成.add(Tool.优先获取词性(document));
                tempEndIndex = 结束下标;
                tempStartIndex = 下标;
                过滤后的成分.add(document);
            }
        }

        Collections.reverse(句型组成);
        Collections.reverse(过滤后的成分);
        return 过滤后的成分;
    }

    public static List<String> 生成格式化逻辑对象(String 逻辑){
        Pattern pattern = Pattern.compile(Cons.左尖括号+"(.*?)"+Cons.右尖括号);
        Matcher matcher = pattern.matcher(逻辑);
        List<String> result = new ArrayList<>();
        while (matcher.find()){
            result.add(matcher.group(1));
        }
        return result;
    }

    public static Document 生成成分对象(String 词语, int 下标, int 词语长度){
        Document 成分对象 = new Document();
        成分对象.put(Cons._id, new ObjectId());
        成分对象.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
        成分对象.put(Cons.词语, 词语);
        成分对象.put(Cons.下标, 下标);
        成分对象.put(Cons.结束下标, 下标 + 词语长度);
        成分对象.put(Cons.是否是句子成分, true);
        return 成分对象;
    }


    public static void main(String[] args) {
        String s = "如果遇到如，并且后面12个字是果，那就把当前词和后面1个字合并为1个词";
        int 下标 = 8;
        System.out.println(匹配某数字某格式(s,下标, "后面", "个字"));

    }

        public static String 匹配某数字某格式(String 逻辑, int 下标, String before, String after){
        String s2 = 逻辑.substring(下标);
        if(!StringUtils.startsWith(s2, before)){
            return null;
        }
        String s3 = s2.substring(before.length());
        int index=-1;
        StringBuilder sb= new StringBuilder();
        while('0' <= s3.charAt(index+1) && s3.charAt(index+1)<='9'){
            sb.append(s3.charAt(index+1));
            index++;
        }
        if(index==-1){
            return null;
        }
        String s4= s3.substring(index+1);
        if(!s4.startsWith(after)){
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append(before).append(sb.toString()).append(after);
        return result.toString();
    }
    public static String 匹配开头(String 逻辑, int 下标, String 词语){
        String s2 = 逻辑.substring(下标);
        if(!s2.startsWith(词语)){
            return null;
        }
        return 词语;
    }

    public static boolean 判断一个逻辑是否已经操作过某个增量方法(Document 句子成分,Document 逻辑成分, String 方法, String 操作属性){
        String key = 操作属性+Cons.的+Cons.执行记录;
        if(!句子成分.containsKey(key)){
            return false;
        }
        if(!(句子成分 instanceof Document)){
            return false;
        }
        if(!(句子成分.get(key) instanceof Document)){
            return false;
        }
        Document document = 句子成分.get(key, Document.class);
        if(
        StringUtils.equals(document.getString(Cons.逻辑成分),逻辑成分.get(Cons._id).toString())  &&
         StringUtils.equals(document.getString(Cons.句子成分),句子成分.get(Cons._id).toString()) &&
         StringUtils.equals(document.getString(Cons.方法),方法)
        && StringUtils.equals(document.getString(Cons.操作属性),操作属性)
        ){
            return true;
        }
        return false;
    }
    public static Document 记录增量方法操作记录(Document 逻辑成分,Document 句子成分, String 方法, String 操作属性){
        Document document = new Document();
        document.put(Cons.逻辑成分, 逻辑成分.get(Cons._id).toString());
        if(!(句子成分 instanceof Document) || !句子成分.containsKey(Cons._id)){
            return null;
        }
        document.put(Cons.句子成分, 句子成分.get(Cons._id).toString());
        document.put(Cons.方法, 方法);
        document.put(Cons.操作属性, 操作属性);
        return document;
    }

    public static Document 生成输入的对象(String 词语) {
        Document document = new Document();
        document.put(Cons.输入的句子, 词语);
        document.put(Cons.词语, 词语);
        document.put(Cons.时间, ToolTime.getCurrentTime());
        return document;
    }
    public static Document 生成输出的对象(String 词语) {
        Document document = new Document();
        document.put(Cons.输出的句子, 词语);
        document.put(Cons.词语, 词语);
        document.put(Cons.时间, ToolTime.getCurrentTime());
        return document;
    }
    public static Document 复制对象(Document 旧对象) {
        return Document.parse(旧对象.toJson());
    }
    public static Integer 转数字(Object data){
        if(data == null){
            return null;
        }
        String 词语 = data +"";
        if(StringUtils.isEmpty(词语)){
            return null;
        }
        if(词语.matches("-?\\d+(\\.\\d+)?")){
            return Integer.parseInt(词语);
        }
        return null;
    }
    public static boolean 是否数字(String 词语){
        return 词语.matches("-?\\d+(\\.\\d+)?");
    }
    public static Document 往后找归属对象(int 下标, Document 下一个成分){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .filter (m -> m.containsKey(Cons.归属对象))
                .filter(m -> m.get(Cons.归属对象)==下一个成分)
                .findFirst().orElse(null);
        return result;
    }

    public static Object 往后找归属对象的属性值(int 下标, Document 主体){
        Document 属性对象 = Tool.往后找归属对象(下标, 主体);
        Object result;
        if(属性对象!=null){
            String 属性 = 属性对象.get(Cons.词语).toString();
            if(StringUtils.equals(属性, Cons.值)){
                result = 主体.get(Cons.词语);
            }else{
                result = 主体.get(属性);
            }
        }else{
            result = 主体.get(Cons.词语);
        }
        return result;
    }

    public static String 往后找归属对象的属性值的键名(int 下标, Document 主体){
        Document 属性对象 = Tool.往后找归属对象(下标, 主体);
        Object result;
        if(属性对象!=null){
            String 属性 = 属性对象.get(Cons.词语).toString();
            if(StringUtils.equals(属性, Cons.值)){
                result = Cons.词语;
            }else{
                result = 属性;
            }
        }else{
            result = Cons.词语;
        }
        return result.toString();
    }
    public static Document 指定词语的句子成分(String 词语){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter (m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定词语的逻辑成分(String 词语){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter (m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 往后找指定词语的逻辑成分(int 下标, String 词语){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .filter (m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 往后找指定词性的逻辑成分(int 下标, String 词性){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .filter (m -> StringUtils.equals(m.getString(Cons.词性), 词性))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    // 因为遵从 逻辑中只有并且 没有或者的理念 所有只要有一个判断结果为false 就为false
    public static boolean 往前找判断结果(int 下标){
        //没有判断结果就是false
        if(静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.判断的结果))
                .count()==0){
            return false;
        }
        boolean 判断的结果 =静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标) && m.getInteger(Cons.下标)<下标)
                .filter(m -> m.containsKey(Cons.判断的结果))
                .filter(m -> !m.getBoolean(Cons.判断的结果))
                .count()>0?false:true;
        return 判断的结果;
    }

    public static Object 往前找指定的键值(int 下标, String key){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .filter(m -> m.containsKey(key))
                .findFirst().orElse(null);
        if(result != null){
            return result.get(key);
        }
        return null;
    }

    public static void 赋值判断结果(Document document, Boolean 判断结果){
        document.put(Cons.判断的结果, 判断结果);
    }
    public static void 赋值句型(Document document, String 句型){
        document.put(Cons.句型, 句型);
    }
//    public static Document 指定下标前面包含判断结果的逻辑成分(int 下标){
//        //过滤出小于下标的，然后排序，找出第一条
//        Document result =  静态引用.逻辑句子的成分集合.stream()
//                .filter(m -> m.containsKey(Cons.下标) && m.containsKey(Cons.判断的结果))
//                .filter (m -> m.getInteger(Cons.下标) < 下标)
//                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
//                .findFirst().orElse(null);
//        return 代词的最终指向(result);
//    }
    public static Document 指定下标前面包含某key的逻辑成分(int 下标, String key){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标) && m.containsKey(key))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
//    public static Document 指定下标后面包含判断结果的逻辑成分(int 下标){
//        //过滤出小于下标的，然后排序，找出第一条
//        Document result =  静态引用.逻辑句子的成分集合.stream()
//                .filter(m -> m.containsKey(Cons.下标) && m.containsKey(Cons.判断的结果))
//                .filter (m -> m.getInteger(Cons.下标) > 下标)
//                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
//                .findFirst().orElse(null);
//        return 代词的最终指向(result);
//    }
    public static Document 指定下标前面的逻辑成分_无迭代(int 下标){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return result;
    }
    public static Document 往前根据属性找对象(String 属性,int 下标){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter(m -> m.getInteger(Cons.下标) < 下标)
                .filter(m -> m.containsKey(属性))
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标前面的逻辑成分_无迭代(int 下标,String 词语){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .filter(m -> m.containsKey(Cons.词语))
                .filter (m -> StringUtils.equals(m.get(Cons.词语).toString(), 词语))
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return result;
    }
    public static Document 指定下标前面的逻辑成分(int 下标,String 词语){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .filter(m -> m.containsKey(Cons.词语))
                .filter (m -> StringUtils.equals(m.get(Cons.词语).toString(), 词语))
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标前面的待处理句子成分(int 下标){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.待处理句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标前面的逻辑成分(int 下标){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标后面的逻辑成分_无迭代(int 下标){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return result;
    }
    public static Document 指定下标后面的待处理句子成分(int 下标){
        Document result =  静态引用.待处理句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标后面的逻辑成分(int 下标){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标前面一个句子成分(int 下标){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.结束下标))
                .filter (m -> m.getInteger(Cons.结束下标) <= 下标)
                .filter (m -> m.getObjectId(Cons._id) != null)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted(Comparator.comparing((Document m1) ->m1.getInteger(Cons.结束下标), Comparator.nullsLast(Integer::compareTo).reversed())
                        .thenComparing(m1 -> m1.getObjectId(Cons._id),  Comparator.nullsLast(ObjectId::compareTo).reversed()))
                .findFirst().orElse(null);
        Document result2 = 代词的最终指向(result);
        return result2;
    }

    public static Document 指定下标前面一个句子成分根据词语查询(int 下标, String 词语){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.结束下标))
                .filter (m -> m.getInteger(Cons.结束下标) <= 下标)
                .filter (m -> m.getObjectId(Cons._id) != null)
                .filter(m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .sorted(Comparator.comparing((Document m1) ->m1.getInteger(Cons.结束下标), Comparator.nullsLast(Integer::compareTo).reversed())
                        .thenComparing(m1 -> m1.getObjectId(Cons._id),  Comparator.nullsLast(ObjectId::compareTo).reversed()))
                .findFirst().orElse(null);
        return result;
    }


    public static Object 获取是或者作为的值(Document document){
        if(document==null){
            return null;
        }
//        if(document.containsKey(Cons.是)){
//            return document.get(Cons.是);
//        }
        if(document.containsKey(Cons.指向)){
            return document.get(Cons.指向);
        }
        if(document.containsKey(Cons.词语) &&
        !StringUtils.equals(String.valueOf(document.get(Cons.是否是句子成分)), "true")){
            return document.get(Cons.词语);
        }
        return document;
    }
    public static Document 生成动作结果指向对象(Object 动作结果){
        Document document = new Document();
        document.put(Cons.词语, 动作结果);
        return document;
    }
    public static List<Document> 获取大于下标的子集合(List<Document> list, int 下标) {
        List<Document> result2 = list.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter(m -> m.getInteger(Cons.下标)> 下标)
                .collect(Collectors.toList());
        return result2;
    }
    public static List<Document> 获取小于结束下标的子集合(List<Document> list, int 结束下标) {
        List<Document> result2 = list.stream()
                .filter(m -> m.containsKey(Cons.结束下标))
                .filter(m -> m.getInteger(Cons.结束下标)< 结束下标)
                .collect(Collectors.toList());
        return result2;
    }
    public static List<Document> 根据键值对过滤输入句子成分集合(String key, Object value) {
        List<Document> result2 = 静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(key)
                    && StringUtils.equals(String.valueOf(m.get(key)), String.valueOf(value)))
                .collect(Collectors.toList());
        return result2;
    }
    public static List<Document> 指定下标的句子成分(int 下标) {
        List<Document> result2 = 静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter(m -> m.getInteger(Cons.下标) == 下标)
                .sorted(Comparator.comparing((Document m1) -> m1.getObjectId(Cons._id), Comparator.nullsLast(ObjectId::compareTo).reversed())
                        .thenComparing(m1 -> m1.getInteger(Cons.结束下标), Comparator.nullsLast(Integer::compareTo).reversed()))
                .collect(Collectors.toList());
        return result2;
    }
    public static List<Document> 指定下标后面连续的句子成分(int 结束下标, int num){
        List<Document> result = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            Document 指定下标后面一个句子成分 = 指定下标后面一个句子成分(结束下标);
            if(指定下标后面一个句子成分==null || !指定下标后面一个句子成分.containsKey(Cons.下标)){
                break;
            }
            result.add(指定下标后面一个句子成分);
            结束下标 = 指定下标后面一个句子成分.getInteger(Cons.结束下标);
        }
        return result;
    }
    public static Document 指定下标后面一个句子成分_无迭代(int 结束下标){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) >= 结束下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .sorted(Comparator.comparing((Document m1) ->m1.getInteger(Cons.下标), Comparator.nullsLast(Integer::compareTo))
                        .thenComparing(m1 -> m1.getObjectId(Cons._id),  Comparator.nullsLast(ObjectId::compareTo).reversed()))
                .findFirst().orElse(null);
        return result;
    }
    public static Document 指定下标后面一个句子成分(int 结束下标){
        Document result =  指定下标后面一个句子成分_无迭代(结束下标);
        Document result2 = 代词的最终指向(result);
        return result2;
    }
    public static List<Document> 根据键值对往后找句子成分(int 下标, String key, String value){
        return 静态引用.get输入句子的指向成分集合().stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter(m -> m.containsKey(key))
                .filter(m -> StringUtils.equals(m.get(key).toString(), value))
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .collect(Collectors.toList());
    }
    public static Document 指定下标后面一个句子成分(int 下标, String 词性){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter (m -> !m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"))
                .filter(m -> m.containsKey(Cons.词性))
                .filter(m -> StringUtils.equals(m.getString(Cons.词性), 词性))
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .findFirst().orElse(null);
        Document result2 = 代词的最终指向(result);
        if(result2 != null && 对象是否是无用词(result2)){
            return 指定下标后面一个句子成分(下标+1);
        }
        return result2;
    }
    public static Document 指定下标后面一个句子成分根据词语查询(int 下标, String 词语){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .filter(m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .findFirst().orElse(null);
        return result;
    }


    public static String 合并逻辑集合指定范围的词语(int 下标, int 结束下标) {
        String result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) >= 下标 && m.getInteger(Cons.下标) <= 结束下标)
                .map(m -> m.getString(Cons.词语))
                .collect(Collectors.joining(""));
        return result;
    }

    public static String 格式化输入句子(String 输入的句子){
        StringBuffer sb = new StringBuffer();
//        sb.append(Cons.输入的句子);
//        sb.append(Cons.是);
        sb.append(输入的句子);
        return sb.toString();
    }

    public static boolean 对象是否是无用词(Document m){
        if(m == null){
            return true;
        }
        return !(!m.containsKey(Cons.是否是无用词) || !StringUtils.equals(m.getString(Cons.是否是无用词), "true"));
    }
    public static Document 指定下标的下下一个逻辑成分(int 下标){
        Document 指定下标后面的逻辑成分 = 指定下标后面的逻辑成分(下标);
        Document result = null;
        if(指定下标后面的逻辑成分 != null){
            result = 指定下标后面的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        }
        return 代词的最终指向(result);
    }
    public static Document 指定下标的下下下一个逻辑成分(int 下标){
        Document 指定下标后面的逻辑成分 = 指定下标后面的逻辑成分(下标);
        Document 指定下标的下下下一个逻辑成分 = null;
        if(指定下标后面的逻辑成分 != null){
            Document 指定下标的下下一个逻辑成分 = 指定下标后面的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
            if(指定下标的下下一个逻辑成分 != null){
                指定下标的下下下一个逻辑成分 = 指定下标后面的逻辑成分(指定下标的下下一个逻辑成分.getInteger(Cons.下标));
            }
        }
        return 代词的最终指向(指定下标的下下下一个逻辑成分);
    }
    public static Document 指定下标的逻辑成分(int 下标){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter (m -> m.getInteger(Cons.下标) == 下标)
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }

    public static void 删除指定范围下标的句子成分(int 下标,int 结束下标){
        for (int i = 下标; i < 结束下标; i++) {
            删除指定下标的句子成分(i);
        }
    }
    public static void 删除指定范围下标的逻辑成分(int 下标,int 结束下标){
        for (int i = 下标; i < 结束下标; i++) {
            删除指定下标的逻辑成分(i);
        }
    }
    // 下标和词语一样
    public static Document 获取句子中的已有成分(int 下标, String 词语){
        Document result =  静态引用.输入句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标) && m.containsKey(Cons.词语))
                .filter (m -> m.getInteger(Cons.下标).equals(下标)
                        && (StringUtils.equals(m.getString(Cons.词语), 词语)
                || StringUtils.equals(m.getString(Cons.原词语), 词语)
                ))
                .findFirst().orElse(null);
        return result;
    }
    public static void 添加句子成分(Document document){
        //先删除再增加
        if(document != null && document.getInteger(Cons.下标) != null
            && document.containsKey(Cons.是否是句子成分)
                && document.getBoolean(Cons.是否是句子成分)){
            Document 句子中的已有成分 = 获取句子中的已有成分(document.getInteger(Cons.下标), document.getString(Cons.词语));
//            Document 原句子中的已有成分 = 获取句子中的已有成分(document.getInteger(Cons.下标), document.getString(Cons.词语));
            //删掉之前的 重新入试试
//            静态引用.输入句子的成分集合.remove(句子中的已有成分);
            if(句子中的已有成分 != null){
                if(句子中的已有成分.containsKey(Cons._id)){
                    document.remove(Cons._id);
                }
                if(!句子中的已有成分.containsKey(Cons._id)
                    && !document.containsKey(Cons._id)){
                   document.put(Cons._id, new ObjectId());
                }
//                if(句子中的已有成分.containsKey(Cons.新成分的处理逻辑)){
//                    句子中的已有成分.get(Cons.新成分的处理逻辑, Set.class).add(静态引用.逻辑句子对象.get(Cons.词语));
//                }
                句子中的已有成分.putAll(document);
            }else {
//                document.put(Cons.父id, 静态引用.输入的句子对象.get(Cons._id));
                document.put(Cons.是否是句子成分, true);
                document.put(Cons.新成分的处理逻辑, 静态引用.逻辑句子对象.get(Cons.词语));
                document.put(Cons.新成分的处理逻辑下标, 静态引用.逻辑句子对象下标);
                静态引用.输入句子的成分集合.add(document);
            }
        }
    }

    public static String 添加更新逻辑内容(Document document,String 属性, String 逻辑句子, Document 处理过程){
        String result = String.format(Cons.更新属性的处理逻辑, 属性);
        if(Tool.判断是否是句子成分(document)){
            Document 处理逻辑 = new Document();
            处理逻辑.put(result, 逻辑句子);
            处理逻辑.put(String.format(Cons.更新属性的处理逻辑下标, 属性),  静态引用.逻辑句子对象下标);
            处理逻辑.put(Cons.处理过程,  处理过程);
            document.put(String.format(Cons.更新属性的处理逻辑, 属性), 处理逻辑);
            return result;
        }
        return null;
    }

    public static Document 获取集合中包含某属性的最后一个对象(List<Document> 对象集合, String 属性){
        List<Document> collect = 对象集合.stream().filter(m -> m.containsKey(属性)).collect(Collectors.toList());
        Collections.reverse(collect);
        return collect.stream().findFirst().orElse(null);
    }
    public static Document 获取属性的处理过程(Document 属性所在对象, String 属性){
        Document document = 属性所在对象.get(String.format(Cons.更新属性的处理逻辑, 属性), Document.class);
        if(document == null){
            return null;
        }
        Document 处理过程 = document.get(Cons.处理过程, Document.class);
        if(处理过程 == null){
            return null;
        }
        return 处理过程;
    }
    public static void 添加逻辑成分(Document document){
        //先删除再增加
        if(document != null && document.getInteger(Cons.下标) != null){
            删除指定下标的逻辑成分(document.getInteger(Cons.下标));
            document.put(Cons.是否是句子成分, false);
            静态引用.逻辑句子的成分集合.add(document);
        }
    }
    public static boolean 判断集合对象中是否包含某属性(List<Document> 集合数据, String 属性){
        if(集合数据 != null && 集合数据.size()>0){
            for (Document ele:集合数据) {
                if(ele.containsKey(属性)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean 对象是否是集合类型(Document 对象){
        if(对象 != null && 对象.containsKey(Cons.集合类型)
                && 对象.keySet().size()==1){
            return true;
        }
        return false;
    }
    public static Document 新建一个对象存放集合类型(List<Document> 集合数据){
        Document document = new Document();
        document.put(Cons.集合类型, 集合数据);
        return document;
    }
    public static List<Document> 获取指定范围下标的句子成分(int start, Integer end){
        List<Document> result = new ArrayList<>();
        if(end == null){
            for (int i = 0; i < 静态引用.输入句子的成分集合.size(); i++) {
                Document document = 静态引用.输入句子的成分集合.get(i);
                if(document != null && document.getInteger(Cons.下标) !=null
                        && document.getInteger(Cons.下标) >=start){
                    result.add(静态引用.输入句子的成分集合.get(i));
                }
            }
            return result;
        }else{
            for (int i = 0; i < 静态引用.输入句子的成分集合.size(); i++) {
                Document document = 静态引用.输入句子的成分集合.get(i);
                if(document != null && document.getInteger(Cons.下标) !=null
                        && document.getInteger(Cons.下标) >=start
                        && document.getInteger(Cons.下标) <end ){
                    result.add(静态引用.输入句子的成分集合.get(i));
                }
            }
            return result;
        }

    }
    public static void 删除指定下标的句子成分(int 下标){
        for (int i = 0; i < 静态引用.输入句子的成分集合.size(); i++) {
            Document document = 静态引用.输入句子的成分集合.get(i);
            if(document != null && document.getInteger(Cons.下标) !=null
            && document.getInteger(Cons.下标) == 下标){
                静态引用.输入句子的成分集合.remove(i);
            }
        }
    }

    public static void 删除指定下标的逻辑成分(int 下标) {
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            if (i < 静态引用.逻辑句子的成分集合.size()) {
                Document document = 静态引用.逻辑句子的成分集合.get(i);
                if (document.getInteger(Cons.下标) == 下标) {
                    静态引用.逻辑句子的成分集合.remove(i);
                }
            }
        }
    }

    public static boolean 判断对象指向是否是集合(Document document){
        if(document.containsKey(Cons.指向) &&
                document.get(Cons.指向) instanceof List){
            return true;
        }
        return false;
    }
    public static boolean 判断是否是句子成分(Document document){
        if(document.containsKey(Cons.是否是句子成分) &&
            document.getBoolean(Cons.是否是句子成分)){
            return true;
        }
        return false;
    }

    public static Document 代词的最终指向(Document document){
        if(document != null && document.containsKey(Cons.指向)){
            if(document.get(Cons.指向) instanceof Document){
                Document document1 = document.get(Cons.指向, Document.class);
                return 代词的最终指向(document1);
            }
        }
        if(document != null && document.keySet().size()==1 && document.containsKey(Cons.词语)){
            if(document.get(Cons.词语) instanceof Document){
                Document document1 = document.get(Cons.词语, Document.class);
                return 代词的最终指向(document1);
            }
        }
        return document;
    }

    public static Object 获取前面的属性值(Document 指定前面下标的逻辑成分){
        Object 属性值 = 指定前面下标的逻辑成分.getString(Cons.词语);
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            属性值 = Tool.最终的归属对象(指定前面下标的逻辑成分).get(属性值);
        }
        return 属性值;
    }
    public static Object 获取后面的属性值(int 下标, Document 指定后面下标的逻辑成分){
        Document 属性对象 = Tool.往后找归属对象(下标, 指定后面下标的逻辑成分);
        Object 属性值;
        if(属性对象==null){
            属性值 = 指定后面下标的逻辑成分.get(Cons.词语);
        }else{
            属性值 = 指定后面下标的逻辑成分.get(属性对象.getString(Cons.词语));
        }
        return 属性值;
    }

    public static boolean 判断对象是否是句子成分(Document document){
        return StringUtils.equals(String.valueOf(document.get(Cons.是否是句子成分)), "true");
    }

    public static Document 最终的归属对象(Document document){
        if(document != null && document.containsKey(Cons.归属对象)
        && !StringUtils.equals(String.valueOf(document.get(Cons.是否是句子成分)), "true")
        ){
            Document document1 = document.get(Cons.归属对象, Document.class);
            return 最终的归属对象(document1);
        }else{
            return document;
        }
    }

    public static void 刷新集合中代词的最终指向(List<Document> list){
        for (int i = 0; i <list.size() ; i++) {
            list.set(i, 代词的最终指向(list.get(i)));
        }
    }

}
