package com.kjgs;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题点：逻辑足够多时，能否生成新逻辑
 *
 */
public class 执行逻辑 {
    @Test
    public void test1(){
        String sen = "ss\\nsdf";
        System.out.println(sen);
        System.out.println(Arrays.toString(sen.split("\n")));
    }

    //形成逻辑 如果遇到加 那先找到被加数 再找到加数，执行相加方法
    //小明的名字是小明
    public static String 小明的名字是小明="保存的对象《是》小明\n保存的属性《是》名字\n保存的属性值《是》小明\n《执行保存方法》";
    public static String 保存逻辑0="保存的对象《是》小明\n保存的属性《是》名字\n保存的属性值《是》小明\n《执行保存方法》";
    //待处理对象是我爱你
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
    public static String 执行查询指定属性值的对象方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
            "\n过滤的对象《是》￥{过滤的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
            "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询指定属性值的对象方法》";
    public static String 执行查询集合对象指定属性值方法="查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
            "\n过滤的对象《是》￥{查询的结果}\n过滤的开始下标《是》0\n过滤的结束下标《是》2\n《执行过滤指定范围下标方法》"+
            "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询集合对象指定属性值方法》";
    public static String 执行输出方法=
            "查询的属性《是》对象\n查询的属性值《是》你\n《执行查询方法》\n过滤的对象《是》￥{查询的结果}\n过滤的属性《是》年龄\n过滤的属性值《是》11\n《执行过滤小于方法》" +
                    "\n过滤的对象《是》￥{过滤的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
                    "\n查询的对象《是》￥{过滤的结果}\n查询的属性《是》对象\n《执行查询指定属性值的对象方法》"+
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

    public static String 查询对象的主键= "查询的对象《是》￥{待处理的对象}\n查询的属性《是》主键\n《执行查询指定属性值的对象方法》"+
            "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";



    /**
     * 判断条件和判断结果要分开处理     */
    @Test
    public void test(){
        执行逻辑.执行逻辑(查询对象的主键, "23");
    }
    public static List<Document> 所有逻辑对象 = new ArrayList<>();

    public static void  执行逻辑(String 逻辑, String 待处理的词语){
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, 待处理的词语);
        所有逻辑对象.add(待处理的对象值);

        执行逻辑(逻辑);
    }

    /**
     * @param document 执行逻辑对象
     */
    public static void 执行逻辑(Document document) {
        //逻辑有判断条件就先执行判断条件，没有直接执行处理逻辑
        if(ObjectUtils.isEmpty(document.get(Cons.处理逻辑的判断条件))){
            //直接执行结果
            if(ObjectUtils.isNotEmpty(document.get(Cons.处理逻辑))){
                执行逻辑.执行逻辑(document.getString(Cons.处理逻辑));
            }
        }else{
            //判断条件的处理结果是true才执行处理逻辑
            执行逻辑.执行逻辑(document.getString(Cons.处理逻辑的判断条件));
            功能对象 功能对象 = new 功能对象();
            String 判断的结果 = 功能对象.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.判断的结果);
            if(Boolean.parseBoolean(判断的结果)){
                //直接执行结果
                if(ObjectUtils.isNotEmpty(document.get(Cons.处理逻辑))){
                    执行逻辑.执行逻辑(document.getString(Cons.处理逻辑));
                }
            }
        }
    }


    public static void 执行逻辑(String 逻辑){
        //分割逻辑
        List<String> 逻辑集合 = Arrays.asList(逻辑.split("\n"));
        //提取动作
        for (int i = 0; i <逻辑集合.size() ; i++) {
            String 当前逻辑句子 = 逻辑集合.get(i);
            String 动作 = StringUtils.substringBetween(当前逻辑句子, Cons.左尖括号, Cons.右尖括号);
            if(StringUtils.isNotEmpty(动作)){
                //执行动作
                try {
                    功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 动作).newInstance();
                    功能抽象对象.执行流程(所有逻辑对象, 当前逻辑句子, 动作);
                }catch (ClassNotFoundException e){
                    //不是内置动作，那么就迭代到数据库获取逻辑处理
                    查询并迭代逻辑(动作);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test_查询并迭代逻辑(){
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, "2");
        所有逻辑对象.add(待处理的对象值);
        查询并迭代逻辑("#{查询这个词的类型}");
    }

    private static void 查询并迭代逻辑(String 需迭代逻辑) {
        Document document = new Document();
        document.put(Cons.对象, 需迭代逻辑);
        List<Document> select = MongoDao.select(document);
        if(CollectionUtils.isEmpty(select)){
            System.out.println("迭代逻辑= '"+需迭代逻辑 + "' 的逻辑是空的");
        }
        for (Document 逻辑对象 : select) {
            String 逻辑 = 逻辑对象.getString(Cons.处理逻辑);
            if (StringUtils.isEmpty(逻辑)) continue;
            执行逻辑.执行逻辑(逻辑);
        }
    }
}
