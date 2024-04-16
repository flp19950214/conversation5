package com.kjgs;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.功能.执行判断逻辑;
import com.kjgs.工具.克隆JSON;
import com.kjgs.工具.环境信息;
import com.kjgs.工具.获取内置功能名;
import com.kjgs.工具.补充对象下标;
import com.kjgs.常用工具.保存对象;
import com.kjgs.常用工具.添加日志;
import com.kjgs.数据库.Mongo词语在句子中;
import com.kjgs.枚举.Cons;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 是否需要创建新对象的原则：是否还有子元素。要充分考虑新增元素的个数
 */
public class 处理流程 {
    public static void main(String[] args) {
//        String input = "岁的词性是名词";
//        String input = "岁的词性是什么";
//        String input = "我爱你";
//        String input = "如果遇到你，那么把待处理对象中的你替换成当前人的值";
//        String input = "如果遇到当前人的值，那么把待处理对象中的你替换成当前人的值";
        String input = "当前人的指向";
//        String input = "待处理对象中的你";
        初始化内置功能();

        input = 执行判断逻辑.判断逻辑(input);

        JSONArray 句子词语集合 = 查询在句子中的词语对象(input);

        处理句子共用流程(句子词语集合, input);

        //保存结果，分析结果，输出结果
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 单个对象 = 句子词语集合.getJSONObject(i);
            String 动作结果 = 单个对象.getString(Cons.动作结果);
            if(动作结果 != null){
                添加日志.追加(动作结果);
            }
        }
        保存对象.保存对象集合(句子词语集合);
    }

    public static void 处理句子共用流程(JSONArray 句子词语集合, String input){
        句子词语集合.addAll(环境信息.默认环境信息(input));

        添加上级对象(句子词语集合, input);

        补充对象下标.补充对象下标(句子词语集合);

        依次执行内置功能(句子词语集合);
    }

    /**
     * 加上级对象，加是否是新属性
     * @param 句子词语集合
     * @param input
     */
    private static void 添加上级对象(JSONArray 句子词语集合, String input) {
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 单个对象 = 句子词语集合.getJSONObject(i);
            单个对象.put(Cons.上级对象, input);
        }
    }


    /**
     * 1,有任何一个词的句型发生了改变，除了本词外，所有的动作都要重新执行
     * 2,对于代词的替换，不能改变原词，对代词的替换是由执行结果来控制
     * @Param 句子词语集合：
     *[
     *     {
     *         "对象": "的",
     *         "_id": {
     *             "$oid": "6608ed46898eac019c609073"
     *         },
     *         "词性": "归属介词"
     *     },
     *     {
     *         "对象": "是",
     *         "_id": {
     *             "$oid": "6608ed46898eac019c609079"
     *         },
     *         "词性": "指向词"
     *     },
     *     {
     *         "对象": "当前人",
     *         "指向": "小燕"
     *     }
     * ]
     */
    public static void 依次执行内置功能(JSONArray 句子词语集合) {
        // 执行动作
        JSONArray 老句子词语集合 = 克隆JSON.copyJSONArray(句子词语集合);
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 当前词语对象 = 句子词语集合.getJSONObject(i);
            String 词性 = 当前词语对象.getString(Cons.词性);
            if(!获取内置功能名.内置功能类名.contains(词性)){
                continue;
            }
            try {
                功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 词性).newInstance();
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

    /**
     *
     * @param input
     * @return
     */
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
