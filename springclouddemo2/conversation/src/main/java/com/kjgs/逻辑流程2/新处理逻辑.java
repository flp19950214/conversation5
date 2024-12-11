package com.kjgs.逻辑流程2;

import com.kjgs.conversation.mysql.mapper.词性Mapper;
import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.词性实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.数据库.MongoCRUDDao;
import com.kjgs.枚举.Cons;
import com.kjgs.算法.组装句子中由词性组成的句子Service;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class 新处理逻辑 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private 逻辑Impl 逻辑MapperImpl;

    @Autowired
    private 组装句子中由词性组成的句子Service 组装句子中由词性组成的句子Impl;

    @Autowired
    private 功能对象 功能对象Impl;
    @Autowired
    private ApplicationContext context;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @Autowired
    private MongoCRUDDao mongoCRUDDao;

    /**
     * 基于mysql
     * 对话语句录入到输入表
     * 输入的句子 的成分分析是放在内存中的，不是是存库的
     * 对句子的分析是基于逻辑表的
     * <p>
     * 1，第一步先划分句子，这一步有代码内置固定方法完成。
     * 划分的句子，组成词性，到逻辑表中找处理逻辑。
     * 然后执行逻辑就行了。
     * 可能组成多个逻辑。大家独立线程，互补干扰。最后应该输出那个结果，有更高级的处理逻辑给出。
     */

//    public Map<String, List<String>> 获取句子中所有词性(String 句子) {
//        List<词性实体> 词性集合 = mongoCRUDDao.查询词性(句子);
//        Map<String, List<String>> map = 词性集合.stream()
//                .collect(Collectors.toMap(词性实体::get词语,
//                        s -> {
//                            List<String> 词性List = new ArrayList<>();
//                            词性List.add(s.词性);
//                            return 词性List;
//                        },
//                        (List<String> v1, List<String> v2) -> {
//                            v1.addAll(v2);
//                            return v1;
//                        }));
//        return map;
//    }

    public void 组装句子中由词性组成的句子(String 句子, Map<String, List<String>> 词语词性集合) {
        组装句子中由词性组成的句子Impl.组装句子中由词性组成的句子(句子, 词语词性集合);
    }

    public List<逻辑实体> 根据词性句子找到对应处理逻辑() {
        if (CollectionUtils.isNotEmpty(组装句子中由词性组成的句子Service.res)) {
            return 逻辑MapperImpl.根据多个逻辑名查询List(组装句子中由词性组成的句子Service.res);
        } else {
            return new ArrayList<>();
        }
    }

    public void init(String 句子, int 处理位置, int 处理结束位置, String 词语) {
        Document 输入的句子 = new Document();
        输入的句子.put(Cons.输入的句子, 句子);
        执行逻辑Impl.所有逻辑对象.add(输入的句子);
        Document 当前处理的句子 = new Document();
        当前处理的句子.put(Cons.当前处理的句子, 句子);
        执行逻辑Impl.所有逻辑对象.add(当前处理的句子);

        Document 当前处理的词语 = new Document();
        当前处理的词语.put(Cons.当前处理的词语, 词语);
        执行逻辑Impl.所有逻辑对象.add(当前处理的词语);

        Document 当前处理的词语位置 = new Document();
        当前处理的词语位置.put(Cons.当前处理的词语位置, 处理位置);
        执行逻辑Impl.所有逻辑对象.add(当前处理的词语位置);

        Document 当前处理的词语结束位置 = new Document();
        当前处理的词语结束位置.put(Cons.当前处理的词语结束位置, 处理结束位置);
        执行逻辑Impl.所有逻辑对象.add(当前处理的词语结束位置);

        Document 当前处理的句子成分 = new Document();
        当前处理的词语位置.put(Cons.当前处理的句子成分, new Document());
        执行逻辑Impl.所有逻辑对象.add(当前处理的句子成分);
    }
    public List<String> 获取所有对象中的词语类型(String 词语){
        List<String> 词性Set = new ArrayList<>();
        for (Document document:执行逻辑.所有逻辑对象){
            if(document.containsKey(Cons.词语类型) && document.containsKey(Cons.词语)){
                if(StringUtils.equals(document.get(Cons.词语).toString(), 词语)){
                    词性Set.add(document.getString(Cons.词语类型));
                }
            }
        }
        return 词性Set;
    }
    public void process(String 词语) {
        if(词语==null){
            return;
        }
        List<String> 词性set =  mongoCRUDDao.查询词语词性(词语);
        词性set.addAll(获取所有对象中的词语类型(词语));

        if(CollectionUtils.isEmpty(词性set)){
            词性set.add(词语);
        }
        List<逻辑实体> 逻辑set = 逻辑MapperImpl.根据多个逻辑名查询List(词性set);
        if(CollectionUtils.isEmpty(逻辑set)){
            //没有处理逻辑 就记录为未知词
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.对象类型, Cons.句子成分);
            成分对象.put(Cons.词语, 词语);
            成分对象.put(Cons.词语类型, Cons.未知词);
            String 当前处理的词语位置 =功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置)+"";
            成分对象.put(Cons.在句子中的下标, 当前处理的词语位置);
            成分对象.put(Cons.在句子中的结束下标, (int)Double.parseDouble(当前处理的词语位置)+词语.length());
            执行逻辑Impl.所有逻辑对象.add(成分对象);
            String 输出结果 = String.format("%s '%s'%s", 1 ,词性set.get(0), "没有处理逻辑异常");
            静态变量.输出的内容.add(输出结果);
            静态变量.添加执行层级集合(输出结果);
            return;
        }
        执行词性处理逻辑(逻辑set);
    }

    public void 二次执行成分逻辑(String 句子){
        for(Document 成分:静态变量.上一层句子成分集合){
            try {
                String 词语 = 成分.getString(Cons.词语);
                int 处理位置 = (int) Double.parseDouble(成分.getString(Cons.在句子中的下标));
                int 处理结束位置 = (int) Double.parseDouble(成分.get(Cons.在句子中的结束下标).toString());
                init(句子, 处理位置, 处理结束位置, 词语);
                process(词语);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }

    static ThreadLocal<List<Document>> threadLocal = new ThreadLocal<>();

    public void 执行词性处理逻辑(List<逻辑实体> 所有逻辑集合) {
//        threadLocal.set(执行逻辑Impl.所有逻辑对象);
//        for (String 逻辑 : 所有逻辑集合) {
//            new Thread(() -> {
//                执行逻辑Impl.执行逻辑(逻辑, threadLocal.get() == null ? new ArrayList<>() : threadLocal.get());
//            }).start();
//        }
//        threadLocal.set(执行逻辑Impl.所有逻辑对象);

        for (逻辑实体 逻辑 : 所有逻辑集合) {
//            new Thread(() -> {
            Document 是否执行判断结果 = new Document();
            是否执行判断结果.put(Cons.是否执行判断结果, "true");
            执行逻辑Impl.所有逻辑对象.add(是否执行判断结果);

            Document 当前处理逻辑 = new Document();
            是否执行判断结果.put(Cons.当前处理逻辑, 逻辑.逻辑); //只是最外层
            是否执行判断结果.put(Cons.当前处理逻辑名, 逻辑.逻辑名); //只是最外层
            执行逻辑Impl.所有逻辑对象.add(当前处理逻辑);

            执行逻辑(逻辑);
//            }).start();
        }
    }

    public Object 执行逻辑(逻辑实体 逻辑Obj) {
        return 执行逻辑(逻辑Obj, UUID.randomUUID().toString(),0);
    }

    public Object 执行逻辑(逻辑实体 逻辑Obj, String uuidLevel, int level) {
        //分割逻辑
        List<String> 逻辑集合 = Arrays.asList(逻辑Obj.逻辑.split(Cons.分号));
        //提取动作
        for (int i = 0; i < 逻辑集合.size(); i++) {
            String 当前逻辑句子 = 逻辑集合.get(i);
            if(level==0){//记录顶层逻辑
                Document 顶层逻辑doc = 功能对象Impl.获取最近的对象(执行逻辑.所有逻辑对象, Cons.顶层逻辑);
                if(顶层逻辑doc==null){
                    顶层逻辑doc = new Document();
                }
                int 处理位置 =(int) Double.parseDouble(功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置).toString());
                int 处理结束位置 =(int) Double.parseDouble(功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语结束位置).toString());
                String 词语 = 功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语).toString();
                顶层逻辑doc.put(Cons.顶层逻辑, 逻辑Obj);
                顶层逻辑doc.put(Cons.在句子中的下标, 处理位置);
                顶层逻辑doc.put(Cons.在句子中的结束下标, 处理结束位置);
                顶层逻辑doc.put(Cons.词语, 词语);
                执行逻辑.所有逻辑对象.add(顶层逻辑doc);
            }
            静态变量.添加执行层级集合(String.format("%s %s", level, 当前逻辑句子));
            //可能有多个动作
            String[] 动作集合 = StringUtils.substringsBetween(当前逻辑句子, Cons.左尖括号, Cons.右尖括号);
            if (ArrayUtils.isEmpty(动作集合)) {
                String 异常信息 = String.format("%s='%s '%s","逻辑" ,当前逻辑句子 ,"没有用《》括起来");
                System.out.println(异常信息);
                throw new RuntimeException(异常信息);
            }
            for (String 动作 : 动作集合) {
                //执行动作
                try {
                    String 是否执行 = 功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.是否执行判断结果).toString();
                    if(StringUtils.equals(动作, Cons.将是否执行判断结果设置为true)){
                        是否执行 = "true";
                    }
                    if (StringUtils.equals(是否执行, "false") ) {
                        continue;
                    }
                    功能抽象 功能抽象对象 = (功能抽象) context.getBean(Class.forName("com.kjgs.功能.内置功能." + 动作));
                    功能抽象对象.执行流程(执行逻辑.所有逻辑对象, 当前逻辑句子, 动作,uuidLevel, level);
                } catch (NoSuchBeanDefinitionException | ClassNotFoundException e) {
                    //不是内置动作，那么就迭代到数据库获取逻辑处理
                    查询并迭代逻辑(动作, level+1);
                } catch (Exception e) {
                    //实在报错就记录下来这个逻辑，以及是那个词语触发的，最后再执行
                    Document 异常逻辑 = new Document();
                    Document 顶层逻辑doc = 功能对象Impl.获取最近的对象(执行逻辑.所有逻辑对象, Cons.顶层逻辑);
                    异常逻辑.put(Cons.异常逻辑, 顶层逻辑doc);
                    e.printStackTrace();
//                    break;
                }
            }
        }
        Document 结果的对象 = new Document();
        结果的对象.put(逻辑Obj.逻辑名, 功能抽象.动作结果);
        结果的对象.put(Cons.动作结果, 功能抽象.动作结果);
        执行逻辑.所有逻辑对象.add(结果的对象);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 动作结果："+功能抽象.动作结果));
        return 功能抽象.动作结果;
    }

    private void 查询并迭代逻辑(String 逻辑名, int level) {
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        if (逻辑Obj == null) {
            String 异常信息 = "迭代逻辑= '" + 逻辑名 + "' 的逻辑是空的";
            System.out.println(异常信息);
           throw new RuntimeException(异常信息);
        }
        执行逻辑(逻辑Obj,UUID.randomUUID().toString(), level);
    }

    private boolean 判断是否有非内置处理逻辑(String 逻辑名){
        逻辑实体 逻辑Obj = 逻辑MapperImpl.根据逻辑名查询单个处理逻辑(逻辑名);
        if(逻辑Obj!= null){
            return true;
        }
        return false;
    }
}