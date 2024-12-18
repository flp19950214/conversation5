package com.kjgs.算法;

import org.apache.commons.lang3.StringUtils;

public class 工具 {

    public static int strDdoubleToInt(Object arg){
//        if(StringUtils.isEmpty(arg)){
//            return 0;
//        }
//        try{
            return (int)Double.parseDouble(arg.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return 0;
    }
}
