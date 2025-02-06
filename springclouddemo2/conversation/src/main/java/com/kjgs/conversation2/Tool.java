package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public class Tool {
    public static Document 指定下标的逻辑成分(int 下标){
        return 静态引用.逻辑句子的成分集合.stream()
                .filter (m -> m.getInteger(Cons.下标) == 下标)
                .findFirst().orElse(null);
    }
}
