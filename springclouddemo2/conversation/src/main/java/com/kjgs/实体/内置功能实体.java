package com.kjgs.实体;

import java.util.Objects;


public class 内置功能实体 {
    public Integer 下标;
    public String 功能名;//唯一主键
    public String 参数名1;
    public String 参数名2;
    public String 参数名3;
    public String 参数名4;
    public String 结果名;

    public 内置功能实体(){

    }

    public 内置功能实体(String 功能名,String 参数名1,String 参数名2,String 参数名3,String 结果名){
        this.功能名=功能名;
        this.参数名1=参数名1;
        this.参数名2=参数名2;
        this.参数名3=参数名3;
        this.结果名=结果名;
    }

    public 内置功能实体 set功能名(String 功能名){
        this.功能名=功能名;
        return this;
    }
    public 内置功能实体 set参数名1(String 参数名1){
        this.参数名1=参数名1;
        return this;
    }
    public 内置功能实体 set参数名2(String 参数名2){
        this.参数名2=参数名2;
        return this;
    }
    public 内置功能实体 set参数名3(String 参数名3){
        this.参数名3=参数名3;
        return this;
    }
    public 内置功能实体 set参数名4(String 参数名4){
        this.参数名4=参数名4;
        return this;
    }
    public 内置功能实体 set结果名(String 结果名){
        this.结果名=结果名;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        内置功能实体 内置功能实体 = (内置功能实体) o;
        return Objects.equals(功能名, 内置功能实体.功能名) &&
                Objects.equals(参数名1, 内置功能实体.参数名1) &&
                Objects.equals(参数名2, 内置功能实体.参数名2) &&
                Objects.equals(参数名3, 内置功能实体.参数名3) &&
                Objects.equals(参数名4, 内置功能实体.参数名4) &&
                Objects.equals(结果名, 内置功能实体.结果名);
    }

    @Override
    public int hashCode() {
        return Objects.hash(功能名, 参数名1, 参数名2, 参数名3, 参数名4, 结果名);
    }
}
