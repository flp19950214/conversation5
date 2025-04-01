package com.kjgs.conversation2;

import com.kjgs.conversation2.model.Model数据;
import com.kjgs.conversation2.model.Model逻辑;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Tool查库 {

   public static List<Model数据> 过滤数据表个数(int 个数, List<Model数据> list){
       if(CollectionUtils.isEmpty(list) || 个数 <= 0){
           return new ArrayList();
       }
       List result = list.subList(list.size() - 个数 - 1, list.size());
       return result;
    }

}
