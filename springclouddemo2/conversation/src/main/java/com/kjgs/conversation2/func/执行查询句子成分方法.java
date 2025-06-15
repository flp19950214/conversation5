package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询句子成分方法 extends FuncAbstract {
    public 执行查询句子成分方法(){
        后面能否跟内置动作=false;
    }
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
        执行查询句子成分方法();
    }

    /**
     * 查询顺序
     * 1.键值对过滤
     * 2.方位
     */
    public void 执行查询句子成分方法(){
        //获取需要的茶树
        Document 查询的键 = Tool.指定下标前面的逻辑成分(下标, "查询句子成分的键");
        Document 查询的值 = Tool.指定下标前面的逻辑成分(下标, "查询句子成分的值");
        if(查询的键 == null || 查询的值 == null){
            return;
        }
        if(Tool.获取是或者作为的值(查询的键) == null || Tool.获取是或者作为的值(查询的值) == null){
            return;
        }
        List<Document> 查询的结果 = Tool.根据键值对过滤输入句子成分集合(
                String.valueOf(Tool.获取是或者作为的值(查询的键)),
                Tool.获取是或者作为的值(查询的值));
        Document 查询的方向 = Tool.指定下标前面的逻辑成分(下标, "查询句子成分的方向");
        if(查询的方向 != null && Tool.获取是或者作为的值(查询的方向) != null){
            String 是或者作为的值 = String.valueOf(Tool.获取是或者作为的值(查询的方向));
            if(StringUtils.equals(是或者作为的值, Cons.前)){
                查询的结果 = Tool.获取小于结束下标的子集合(查询的结果, 句子结束下标);
            }else if(StringUtils.equals(是或者作为的值, Cons.后)){
                查询的结果 = Tool.获取大于下标的子集合(查询的结果, 句子下标);
            }
        }
        if(CollectionUtils.isEmpty(查询的结果)){
            return;
        }
        逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(查询的结果));
    }

}
