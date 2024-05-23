package com.kjgs.功能;

import org.bson.Document;


public abstract class 功能抽象 implements 功能接口 {
    public Document 当前逻辑对象;

    public void 执行流程(Document 逻辑对象) {
        当前逻辑对象 = 逻辑对象;
        功能();
    }

}
