package com.kjgs;

import com.kjgs.功能.内置功能.执行追加方法;
import com.kjgs.功能.内置功能.是;
import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 执行逻辑 {
    @Test
    public void test1(){
        String sen = "ss\\nsdf";
        System.out.println(sen);
        System.out.println(Arrays.toString(sen.split("\n")));
    }

    public static String 保存逻辑0="保存的对象《是》小明\n保存的属性《是》名字\n保存的属性值《是》小明\n《执行保存方法》";
    public static String 保存逻辑3="保存的对象《是》待处理的对象\n保存的属性《是》是\n保存的属性值《是》我爱你\n《执行保存方法》";
    public static String 查询更新逻辑="查询条件的键《是》对象\n查询条件的值《是》你\n《执行查询方法》\n过滤对象是￥{查询结果}\n过滤条件的键《是》年龄\n《执行过滤大于方法》"
            +"循环对象《是》￥{过滤结果}\n循环动作《是》执行更新方法\n更新的主键《是》ObjectId(\"66514c96e5d2a40c245040fe\")\n更新的属性《是》名字\n更新的属性值《是》小明\n《执行循环方法》"
            +"更新的主键《是》";
    public static String 保存逻辑1="保存的对象《是》你\n保存的属性《是》年龄\n保存的属性值《是》12\n《执行保存方法》";
    public static String 保存逻辑2="保存的对象《是》你\n保存的属性《是》年龄\n保存的属性值《是》10\n《执行保存方法》";
    public static String 更新逻辑0="更新的主键《是》6657dcbe6b4d1c26847e1a22\n更新的属性《是》名字\n更新的属性值《是》小华\n《执行更新方法》";
    public static String 查询逻辑0="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》";
    public static String 过滤大于逻辑1="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤大于方法》";
    public static String 过滤小于逻辑1="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》";
    public static String 执行过滤指定下标方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
            "\n过滤的对象《是》￥{过滤的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》";
    public static String 执行过滤指定范围下标方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》" +
            "\n过滤的对象《是》￥{查询的结果}\n过滤的开始下标《是》0\n过滤的结束下标《是》2\n《执行过滤指定范围下标方法》";
    public static String 执行查询对象指定属性值方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
            "\n过滤的对象《是》￥{过滤的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
            "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询对象指定属性值方法》";
    public static String 执行查询集合对象指定属性值方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
            "\n过滤的对象《是》￥{查询的结果}\n过滤的开始下标《是》0\n过滤的结束下标《是》2\n《执行过滤指定范围下标方法》"+
            "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询集合对象指定属性值方法》";
    public static String 执行输出方法=
            "查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
                    "\n过滤的对象《是》￥{过滤的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
                    "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询对象指定属性值方法》"+
                    "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";
    public static String 执行输出方法1="输出的内容《是》你是对的\n《执行输出方法》";

    public static String 执行分割方法= "被分割的对象《是》￥{待处理的对象}\n分割词《是》爱\n《执行分割方法》";
    public static String 执行判断包含方法= "被判断的对象《是》2\n判断的对象《是》3\n《执行判断包含方法》"+
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    public static String 执行判断大于方法= "被判断的对象《是》2\n判断的对象《是》3\n《执行判断大于方法》"+
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    public static String 执行判断小于方法= "被判断的对象《是》2\n判断的对象《是》3\n《执行判断小于方法》"+
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    public static String 执行判断等于方法= "被判断的对象《是》3\n判断的对象《是》3\n《执行判断等于方法》"+
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";

    public static String 执行追加方法= "被追加的对象《是》3\n追加的对象《是》2\n《执行追加方法》"+
            "\n被追加的对象《是》￥{追加的结果}\n追加的对象《是》3\n《执行追加方法》"+
            "\n输出的内容《是》￥{追加的结果}\n《执行输出方法》";
    public static String 执行加法方法= "被加数《是》3\n加数《是》2\n《执行加法方法》"+
            "\n输出的内容《是》￥{相加的结果}\n《执行输出方法》";
    public static String 执行加法方法1= "被加数《是》${前面的数字}\n加数《是》#{后面的数字}\n《执行加法方法》"+
            "\n输出的内容《是》￥{相加的结果}\n《执行输出方法》";
    public static String 执行减法方法= "被减数《是》3\n减数《是》2\n《执行减法方法》"+
            "\n输出的内容《是》￥{相减的结果}\n《执行输出方法》";
    public static String 执行乘法方法= "被乘数《是》3\n乘数《是》2\n《执行乘法方法》"+
            "\n输出的内容《是》￥{相乘的结果}\n《执行输出方法》";
    public static String 执行除法方法= "被除数《是》3\n除数《是》2\n《执行除法方法》"+
            "\n输出的内容《是》￥{相除的结果}\n《执行输出方法》";

    public static String 执行新增对象方法= "新增的属性《是》被加数\n新增的属性值《是》2\n《执行新增对象方法》";

    public static String 待处理的对象中第2个字是什么= "查询的对象《是》￥{待处理的对象}\n查询的开始下标《是》1\n查询的结束下标《是》2\n《执行查询对象指定下标方法》"+
            "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";
    public static String 待处理的对象中第3个字是什么= "查询的对象《是》￥{待处理的对象}\n查询的开始下标《是》1\n查询的结束下标《是》3\n《执行查询对象指定下标方法》"+
            "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";



    /**
     * 判断条件和判断结果要分开处理     */
    @Test
    public void test(){
        执行逻辑.执行逻辑(执行新增对象方法, null);
    }
    public static List<Document> 所有逻辑对象 = new ArrayList<>();

    public static void 执行逻辑(String 逻辑, String 待处理对象){
        //分割逻辑
        List<String> 逻辑集合 = Arrays.asList(逻辑.split("\n"));
        if(待处理对象 != null){
            Document 待处理的对象 = new Document();
            待处理的对象.put(Cons.待处理的对象, 待处理对象);
            所有逻辑对象.add(待处理的对象);
        }
        //提取动作
        for (int i = 0; i <逻辑集合.size() ; i++) {
            String 当前逻辑句子 = 逻辑集合.get(i);
            String 动作 = StringUtils.substringBetween(当前逻辑句子, Cons.左尖括号, Cons.右尖括号);

            //执行动作
            try {
                功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 动作).newInstance();
                功能抽象对象.执行流程(所有逻辑对象, 当前逻辑句子, 动作);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
