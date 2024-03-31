package com.kjgs.常用工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.junit.Test;

/**
 * 1,句子是存储的最小单位, 对比段落、文章来说的
 * 2,分成两部分，一、统一保存对象，二、保存词语
 * 3,保存词语 依次处理每个词语，保存它的属性。
 * 4，保存属性前，先判断是否存在，存在就跳过，不存在就新增。（无更新操作）（需要解析）
 */
public class 保存对象 {

    public static void 保存对象集合(JSONArray 对象集合){
        if(对象集合 == null){
            return;
        }
        for (int i = 0; i <对象集合.size() ; i++) {
            JSONObject 单个对象 = 对象集合.getJSONObject(i);
            保存或更新对象(单个对象);
        }
    }

    @Test
    public void test_保存对象() {
        保存对象 obj = new 保存对象();
        String sen = "{\"句子\":\"岁的词性是名词\",\"词语_0\":\"的\",\"词语_0_的下标\":\"1\",\"词语_0_的词性\":\"归属介词\",\"词语_1\":\"是\",\"词语_1_的下标\":\"4\",\"词语_1_的词性\":\"指向词\",\"词语_2\":\"岁\",\"词语_2_的下标\":\"0\",\"词语_3\":\"词性\",\"词语_3_的下标\":\"1\",\"词语_2_的未知值属性\":\"词性\",\"词语_4\":\"词性\",\"词语_4_的下标\":\"1\",\"词语_5\":\"名词\",\"词语_5_的下标\":\"4\",\"词语_4_的未知属性值\":\"名词\",\"词语_2_的词性\":\"名词\"}\n";
        保存对象(JSONObject.parseObject(sen));
    }

    public static void 保存对象(JSONObject jsonObject) {
        MongoDao.insert(jsonObject);
    }
    public static void 更新对象(String _id, JSONObject jsonObject) {
        MongoDao.update(_id, jsonObject);
    }

    /**
     * 存在就更新，否则新增
     * @param jsonObject
     */
    public static void 保存或更新对象(JSONObject jsonObject) {
        //只看对象本身，两个条件，是否有新对象标识，是否有id
        Boolean 是否是新对象 = jsonObject.getBoolean(Cons.是否是新对象);
        if(是否是新对象==null){
            保存对象(jsonObject);
        }else{
            String _id = jsonObject.getString(Cons._id);
            if(_id != null){
                更新对象(_id, jsonObject);
            }else{
                保存对象(jsonObject);
            }
        }
    }
}
