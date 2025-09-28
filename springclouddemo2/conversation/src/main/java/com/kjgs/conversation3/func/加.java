package com.kjgs.conversation3.func;

import com.kjgs.conversation2.Tool;
import com.kjgs.conversation3.DoneModel;
import com.kjgs.conversation3.Fixed;
import com.kjgs.conversation3.FuncAbstract2;
import com.kjgs.conversation3.mapper.DoneMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("加2")
public class 加 extends FuncAbstract2 {

    @Autowired
    DoneMapper doneMapper;
    @Override
    public void method() {
        DoneModel 被加数 = doneMapper.根据词语查询最新一条("被加数");
        if(被加数 == null && 被加数.属性值 == null){
            Fixed.处理流程.add(String.format("加：从库中查到的被加数是=%s，返回", null));
            return;
        }else{
            if(Tool.是否数字(被加数.属性值)){
                Fixed.处理流程.add(String.format("加：从库中查到的被加数是=%s", 被加数.属性值));
            }else{
                Fixed.处理流程.add(String.format("加：从库中查到的被加数是=%s，不是数字，返回", 被加数.属性值));
                return;
            }
        }
        DoneModel 加数 = doneMapper.根据词语查询最新一条("加数");
        if(加数 == null && 加数.属性值 == null){
            Fixed.处理流程.add(String.format("加：从库中查到的加数是=%s", null));
            return;
        }else{
            if(Tool.是否数字(被加数.属性值)){
                Fixed.处理流程.add(String.format("加：从库中查到的加数是=%s", 加数.属性值));
            }else{
                Fixed.处理流程.add(String.format("加：从库中查到的加数是=%s，不是数字，返回", 加数.属性值));
                return;
            }
        }
        int result = Tool.转数字(被加数) + Tool.转数字(加数);
        Fixed.处理流程.add(String.format("加：相加的结果=%s", result));
        DoneModel doneModel = new DoneModel();
        doneModel.pid = Fixed.输入句子id;
        doneModel.词语 = "加";
        doneModel.属性 = "结果";
        doneModel.属性值 = String.valueOf(result);
        doneMapper.保存(doneModel);
    }
}
