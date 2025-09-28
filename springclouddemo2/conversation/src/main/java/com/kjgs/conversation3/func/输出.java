package com.kjgs.conversation3.func;

import com.kjgs.conversation3.DoneModel;
import com.kjgs.conversation3.Fixed;
import com.kjgs.conversation3.FuncAbstract2;
import com.kjgs.conversation3.mapper.DoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("输出2")
public class 输出 extends FuncAbstract2 {
    @Autowired
    DoneMapper doneMapper;

    @Override
    public void method() {
        //输出的内容：2
        //查库
        DoneModel 输出的内容 = doneMapper.根据词语查询最新一条("输出的内容");
        if (输出的内容 == null || 输出的内容.属性值 == null) {
            Fixed.处理流程.add(String.format("输出：从库中查到的输出内容是=%s", null));
            Fixed.输出的内容 = null;
        }
        if (输出的内容.代词指向id == null) {
            Fixed.处理流程.add(String.format("输出：从库中查到的输出内容是=%s", 输出的内容.属性值));
            Fixed.输出的内容 = 输出的内容.属性值;
        }
        DoneModel 输出代词指向的内容 = doneMapper.根据id查询(输出的内容.代词指向id);
        Fixed.处理流程.add(String.format("输出：从库中查到的输出内容是=%s,真实指向是=%s", 输出的内容.属性值, 输出代词指向的内容.属性值));
        Fixed.输出的内容 = 输出代词指向的内容.属性值;
    }
}
