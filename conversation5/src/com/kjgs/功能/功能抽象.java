package com.kjgs.功能;

import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.text.DecimalFormat;
import java.util.List;


public abstract class 功能抽象<T> implements 功能接口 {
    public List<Document> 所有逻辑对象;
    public Document 当前动作对象;
    public Document 当前动作;
    public String 动作;
    public Document 当前逻辑句子对象;
    public String 当前逻辑句子;

    public static void main(String[] args) {
        double value = 123.01; // 假设这是你需要格式化的double值
        DecimalFormat df = new DecimalFormat("0"); // 使用0作为模式，这样会去除小数点和尾随的零
        String formattedValue = df.format(value);
        System.out.println(formattedValue); // 输出将不包含小数点
    }

    public int 获取当前动作对象开始下标(){
        return 当前逻辑句子.indexOf(Cons.左尖括号);
    }
    public int 获取当前动作对象结束下标(){
        return 当前逻辑句子.indexOf(Cons.右尖括号)+1;
    }
    public void 执行流程(List<Document> 所有逻辑对象, String 当前逻辑句子, String 动作) {
        this.所有逻辑对象 = 所有逻辑对象;
        this.动作 = 动作;
        this.当前逻辑句子 = 当前逻辑句子;
        功能();
    }

    public String 获取最近的属性值(List<Document> list, String key){
        return 获取最近的属性值(list, key, Object.class).toString();
    }


//    public List<T> 获取最近的属性值(List<Document> list, String key, List<T> t){
//        for(int i=list.size()-1; i>=0;i--){
//            Document document = list.get(i);
//            if(document.containsKey(key)){
//                return document.get(key, t);
//            }
//        }
//        return null;
//    }

    public <T> T 获取最近的属性值(List<Document> list, String key, Class<T> t){
        for(int i=list.size()-1; i>=0;i--){
            Document document = list.get(i);
            if(document.containsKey(key)){
                try {
                    String value = document.getString(key);
                    //判断值是否是变量，如果是需要再次查询
                    if (StringUtils.startsWith(value, Cons.左变量标识符) && StringUtils.endsWith(value, Cons.右变量标识符)) {
                        String key2 = StringUtils.substringBetween(value, Cons.左变量标识符, Cons.右变量标识符);
                        if(StringUtils.equals(key, key2)){
                            continue;
                        }
                        return 获取最近的属性值(list, key2, t);
                    }
                    return document.get(key, t);
                }catch (ClassCastException e){
                    return document.get(key, t);
                }
            }
        }
        return null;
    }

    public static Document 获取最近的对象(List<Document> list, String key){
        for(int i=list.size()-1; i>=0;i--){
            Document document = list.get(i);
            if(document.containsKey(key)){
                return document;
            }
        }
        return null;
    }

}
