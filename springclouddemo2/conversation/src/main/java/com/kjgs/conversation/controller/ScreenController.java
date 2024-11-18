package com.kjgs.conversation.controller;

import com.kjgs.conversation.service.ScreenRecorder;
import com.kjgs.conversation.service.TestDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ScreenController {

    @Autowired
    private ScreenRecorder screenRecorder;

    @RequestMapping("/startRecorder")
    public void startRecorder() throws IOException {
        screenRecorder.recordScreen();
    }
}
