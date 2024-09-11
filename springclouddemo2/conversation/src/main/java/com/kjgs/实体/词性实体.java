package com.kjgs.实体;

public class 词性实体 {
    public Integer 下标;
    public String 词语;//词语 + 词性  唯一主键
    public String 词性;

    public Integer get下标() {
        return 下标;
    }

    public void set下标(Integer 下标) {
        this.下标 = 下标;
    }

    public String get词语() {
        return 词语;
    }

    public void set词语(String 词语) {
        this.词语 = 词语;
    }

    public String get词性() {
        return 词性;
    }

    public void set词性(String 词性) {
        this.词性 = 词性;
    }
}
