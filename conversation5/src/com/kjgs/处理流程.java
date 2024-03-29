package com.kjgs;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.功能.执行判断逻辑;
import com.kjgs.工具.克隆JSON;
import com.kjgs.工具.环境信息;
import com.kjgs.工具.获取内置功能名;
import com.kjgs.数据库.Mongo词语在句子中;
import com.kjgs.枚举.Cons;

import java.lang.reflect.Method;
import java.util.List;

public class 处理流程 {
    public static void main(String[] args) {
        String input = "岁的词性是什么";

        初始化内置功能();

        input = 执行判断逻辑.判断逻辑(input);

        JSONArray 句子词语集合 = 查询在句子中的词语对象(input);

        处理句子共用流程(句子词语集合, input);
    }

    public static void 处理句子共用流程(JSONArray 句子词语集合, String input){

        句子词语集合.addAll(环境信息.默认环境信息(input));

        依次执行内置功能(句子词语集合);
    }


    /**
     * 1,有任何一个词的句型发生了改变，除了本词外，所有的动作都要重新执行
     * 2,对于代词的替换，不能改变原词，对代词的替换是由执行结果来控制
     */
    public static void 依次执行内置功能(JSONArray 句子词语集合) {
        // 执行动作
        JSONArray 老句子词语集合 = 克隆JSON.copyJSONArray(句子词语集合);
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 当前词语对象 = 句子词语集合.getJSONObject(i);
            String 对象 = 当前词语对象.getString(Cons.对象);
            if(!获取内置功能名.内置功能类名.contains(对象)){
                continue;
            }
            try {
                功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 对象).newInstance();
                功能抽象对象.执行流程(句子词语集合, 当前词语对象);
                if (判断所有动作的句型是否发生变化(老句子词语集合, 句子词语集合)) {
                    依次执行内置功能(句子词语集合);
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static boolean 判断所有动作的句型是否发生变化(JSONArray 老句子词语集合, JSONArray 新句子词语集合){
        for(int i=0;i<老句子词语集合.size();i++){
            JSONObject 老单个词语对象 = 老句子词语集合.getJSONObject(i);
            JSONObject 新单个词语对象 = 新句子词语集合.getJSONObject(i);

            String 老句型 = 老单个词语对象.getString(Cons.句型);
            String 新句型 = 新单个词语对象.getString(Cons.句型);
            if(新句型 !=null){
                if(老句型 ==null){
                    return true;
                }
                if(!新句型.equals(老句型)){
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray 查询在句子中的词语对象(String input){
        JSONArray 在句子中的对象集合 = Mongo词语在句子中.查询在句子中的(Cons.对象, input);
        return 在句子中的对象集合;
    }
    /**初始化所有动作**/
    public static void 初始化内置功能(){
        List<String> allAct = 获取内置功能名.内置功能类名;
        for(String clzName:allAct){
            try {
                Object o = Class.forName("com.kjgs.功能.内置功能." + clzName).newInstance();
                Method initMethod = o.getClass().getMethod("功能初始化");
                initMethod.invoke(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
