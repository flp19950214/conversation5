package com.kjgs.功能;

import com.kjgs.枚举.Cons;
import com.kjgs.线程池.异步_初始化记录内置功能属性;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class 功能抽象<T> implements 功能接口 {
    public List<Document> 所有逻辑对象;
    public String 动作;
    public static Object 动作结果;
    public String 当前逻辑句子;
    public static int 属性在所有对象中的下标 = 0;

    @Autowired
    public 异步_初始化记录内置功能属性 异步初始化类;

    @PostConstruct
    public void 初始化(){
        初始化记录内置功能属性();
    }

    public static String getClasName(){
        String classPath = new Exception().getStackTrace()[1].getClassName();
        return classPath.substring(classPath.lastIndexOf(".")+1);
    }

    public static void main(String[] args) {
        double value = 123.01; // 假设这是你需要格式化的double值
        DecimalFormat df = new DecimalFormat("0"); // 使用0作为模式，这样会去除小数点和尾随的零
        String formattedValue = df.format(value);
        System.out.println(formattedValue); // 输出将不包含小数点
    }

    public int 获取当前动作对象开始下标(String 动作名){
        StringBuffer sb = new StringBuffer();
        sb.append(Cons.左尖括号).append(动作名).append(Cons.右尖括号);
        return 当前逻辑句子.indexOf(sb.toString());
    }
    public int 获取当前动作对象结束下标(String 动作名){
        StringBuffer sb = new StringBuffer();
        sb.append(Cons.左尖括号).append(动作名).append(Cons.右尖括号);
        return 当前逻辑句子.indexOf(sb.toString()) + sb.length();
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

    public List 获取所有的属性值(List<Document> list, String key){
        return 获取所有的属性值(list, key, Object.class);
    }


    public <T> List<T> 获取所有的属性值(List<Document> list, String key, Class<T> t){
        List<T> result = new ArrayList<>();
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
                        result.add(获取最近的属性值(list, key2, t));
                    }
                    result.add(document.get(key, t));
                }catch (ClassCastException e){
                    result.add(document.get(key, t));
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

    public <T> T 获取最近的属性值value(List<Document> list, String value, Class<T> t){
        //判断值是否是变量，如果是需要再次查询
        if (StringUtils.startsWith(value, Cons.左变量标识符) && StringUtils.endsWith(value, Cons.右变量标识符)) {
            String key2 = StringUtils.substringBetween(value, Cons.左变量标识符, Cons.右变量标识符);
            return 获取最近的属性值(list, key2, t);
        }
        if (StringUtils.startsWith(value, Cons.左尖括号) && StringUtils.endsWith(value, Cons.右尖括号)) {
            String key2 = StringUtils.substringBetween(value, Cons.左尖括号, Cons.右尖括号);
            return 获取最近的属性值(list, key2, t);
        }
        return (T) value;
    }
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
                    属性在所有对象中的下标 = i;
                    return document.get(key, t);
                }catch (ClassCastException e){
                    属性在所有对象中的下标 = i;
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
