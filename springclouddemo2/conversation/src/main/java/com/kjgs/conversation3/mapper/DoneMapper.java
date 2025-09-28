package com.kjgs.conversation3.mapper;

import com.kjgs.conversation3.DoneModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoneMapper {

    DoneModel 根据词语查询最新一条(String 词语);
    DoneModel 根据id查询(int id);
    DoneModel 根据代词指向id查询(int 代词指向id);
    List<String> 查出在句子中的所有词语(String 句子);
    int 保存(DoneModel doneModel);
}
