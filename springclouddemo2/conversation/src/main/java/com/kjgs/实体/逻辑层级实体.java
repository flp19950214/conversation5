package com.kjgs.实体;

public class 逻辑层级实体 extends 逻辑实体 {
    public int level;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <level ; i++) {
            sb.append("    ");
        }
        sb.append("'").append(逻辑名).append("','").append(逻辑).append("'");
        return sb.toString();
    }
}
