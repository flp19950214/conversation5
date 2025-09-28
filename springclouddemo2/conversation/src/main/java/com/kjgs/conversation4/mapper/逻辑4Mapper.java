package com.kjgs.conversation4.mapper;

import com.kjgs.conversation3.DoneModel;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface 逻辑4Mapper {

    List<Document> 根据逻辑名查询逻辑(String 逻辑名);
    Document 根据逻辑名查询最新逻辑(String 逻辑名);
}
