package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查库;
import com.kjgs.conversation2.model.Model数据;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询名词指向方法 extends FuncAbstract {

    @Autowired
    private Impl数据 impl数据;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        执行查询名词指向方法();
    }
    public void 执行查询名词指向方法(){
        //查询库
        String 操作库 = 句子成分.getString(Cons.操作库);
        if(StringUtils.isEmpty(操作库) && 静态引用.所有库.contains(操作库)){
            return;
        }
        //查询方向
        String 查询方向 = 句子成分.getString(Cons.方位词);
        if(StringUtils.isNotEmpty(查询方向) && 静态引用.所有方位.contains(查询方向)){
            return;
        }
        //查询个数
        Integer 查询个数 = 句子成分.getInteger(Cons.数字);
        //查询单位
        String 查询单位 = 句子成分.getString(Cons.单位词);
        Object res = null;
        if(StringUtils.equals(操作库, Cons.数据表)){
            List<Model数据> 查询所有数据 = impl数据.查询所有数据();
            if(查询个数 != null){
                List<Model数据> 过滤数据表个数 = Tool查库.过滤数据表个数(查询个数, 查询所有数据);
            }
        }

        if(res == null){
            return;
        }
        句子成分.put(Cons.指向, res);
    }

}
