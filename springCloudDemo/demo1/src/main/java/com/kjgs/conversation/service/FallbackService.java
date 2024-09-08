package com.kjgs.conversation.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("fallbackService2")
public class FallbackService implements FeignClientImpl{

    @Override
    public Map getHealth() {
        Map map = new HashMap();
        map.put("exception","服务异常，请等待2");
        return map;
    }
}
