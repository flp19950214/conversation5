package com.kjgs;

import com.kjgs.工具.获取内置功能名;

import java.lang.reflect.Method;
import java.util.List;

public class 处理流程 {
    public static void main(String[] args) {
        String input = "岁的词性是什么";

        初始化内置功能();
    }
    /**初始化所有动作**/
    public static void 初始化内置功能(){
        List<String> allAct = 获取内置功能名.内置功能类名;
        for(String clzName:allAct){
            try {
                Object o = Class.forName("com.kjgs.功能.内置功能." + clzName).newInstance();
                Method initMethod = o.getClass().getMethod("功能初始化");
                initMethod.invoke(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
