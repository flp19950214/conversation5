package com.kjgs.枚举;

import org.bson.types.ObjectId;

public interface Cons {
    public String 左尖括号 = "《";
    public String 右尖括号 = "》";
    public String 左变量标识符 = "￥{";
    public String 右变量标识符 = "}";
    public String 左逻辑变量标识符 = "#{";
    public String 右逻辑变量标识符 = "}";
    public String 上级对象="上级对象";
    public String 对象="对象";
    public String 的对象="的对象";
    public String 在上级对象中的成分="在上级对象中的成分";
    public String 指向="指向";
    public String 未知属性="未知属性";
    public String 属性="属性";
    public String 动作句型="动作句型";
    public String 归属对象="归属对象";
    public String 归属对象未知属性=归属对象+未知属性;
    public String 操作对象="操作对象";
    public String 是否是对象="是否是对象";
    public String 是否是新对象="是否是新对象";
    public String 是否执行动作="是否执行动作";
    public String 动作结果="动作结果";
    public String 查询结果="查询结果";
    public String 姓名="姓名";
    public String 名字="名字";
    public String 名称="名称";
    public String 词性="词性";
    public String 句型="句型";
    public String 主键="主键";
    public String 开始下标="开始下标";
    public String 结束下标="结束下标";
    public String 下标="下标";

    public String 判断条件="判断条件";
    public String 判断条件1="判断条件1";
    public String 判断结果="判断结果";
    public String 待处理的对象="待处理的对象";


    public String 包含="包含";
    public String 新增="新增";
    public String 修改="修改";
    public String 根据="根据";
    public String 空="空";
    public String 给="给";
    public String 箭头符="->";


    public String 当前人="当前人";
    public String 当前对话人="当前对话人";
    public String 小燕="小燕";
    public String 阿欣="阿欣";

    public String 动词处理结果="动词处理结果";
    public String 疑问句处理结果="疑问句处理结果";
    public String 正向判断处理逻辑="正向判断处理逻辑";
    public String 负向判断处理逻辑="负向判断处理逻辑";


    //功能代表词
    public String 的="的";
    public String 是="是";
    public String 叫="叫";
    public String 替换成="替换成";
    public String 如果="如果";
    public String 那么="那么";
    public String 否则="否则";
    public String 遇到="遇到";//视觉词
    public String 在="在";//限定词
    public String 把="把";//限定词
    public String 左引号="“";//词语开始词
    public String 右引号="”";//词语闭合词
    public String 和="和";//联合词
    public String 之间="之间";//联合词
    public String 中="中";//限定词
    public String 或者="或者";//联合词
    public String 什么="什么";//疑问词
    public String 爱="爱";//情感词
    public String 好感度="好感度";
    public String 对="对";
    public String 找="找";//查找词
    public String 输出="输出";//查找词

    //句型种类
    public String 疑问句="疑问句";
    public String 假设句="假设句";
    public String 陈述句="陈述句";
    public String 否定句="否定句";
    public String 假设陈述句="假设陈述句";
    //词性种类
    public String 反向判断词="反向判断词";

    public String 句子结束词="句子结束词";


    public String 父id="父id";
    public String _id="_id";
    public String 值="值";
    public String 处理逻辑="处理逻辑";

    //逻辑
    public String 找待处理对象的处理逻辑 = "找待处理对象的处理逻辑";
    public ObjectId 找待处理对象的处理逻辑_id = new ObjectId("101");
//    public ObjectId 找待处理对象的处理逻辑的值 = "找包含待处理对象的值的判断条件，再找到判断条件的处理逻辑";
//    public ObjectId 找待处理对象的处理逻辑的值 = "找在判断条件中包含待处理对象的值，再找到判断条件的处理逻辑";
    public String 找待处理对象的处理逻辑的值 = "找判断条件，过滤包含待处理对象的值的判断条件";
}