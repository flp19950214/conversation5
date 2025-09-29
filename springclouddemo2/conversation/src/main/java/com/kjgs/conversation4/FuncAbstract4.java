package com.kjgs.conversation4;


import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public abstract class FuncAbstract4 {


    public Document 当前逻辑;
    public Map<String, Object> map上层逻辑内存;
    public Map<String, Object> map当前逻辑内存;

    public abstract void method( ) throws Exception;

}
