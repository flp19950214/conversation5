package com.kjgs.实体;

import java.util.Objects;


public class 逻辑实体 {
    public Integer 下标;
    public String 逻辑名;//唯一主键
    public String 逻辑;

    public 逻辑实体(){

    }

    public 逻辑实体(String 逻辑名, String 逻辑){
        this.逻辑名=逻辑名;
        this.逻辑=逻辑;
    }

    public 逻辑实体 set逻辑名(String 逻辑名){
        this.逻辑名=逻辑名;
        return this;
    }
    public 逻辑实体 set逻辑(String 逻辑){
        this.逻辑=逻辑;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        逻辑实体 逻辑实体 = (逻辑实体) o;
        return 逻辑名.equals(逻辑实体.逻辑名) &&
                逻辑.equals(逻辑实体.逻辑);
    }

    @Override
    public int hashCode() {
        return Objects.hash(逻辑名, 逻辑);
    }
}
