package org.springagg.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import websocket.TextMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

@Controller
@RequestMapping("message")
public class MessageController {

    @Autowired
    public TextMessageHandler textMessageHandler;

    @RequestMapping
    public String view() {
        return "message";
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    @ResponseBody
    public String send(@RequestParam("message") String message) {
        textMessageHandler.sendMessageToUser(message);
        return "true";
    }
}
