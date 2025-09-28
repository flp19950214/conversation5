package com.kjgs.conversation4;

import java.util.List;

public class Tool {

    public static List<String> printLog(String log) {
        System.out.println(log);
        TalkController4.logList.add(log);
        return TalkController4.logList;
    }
}
