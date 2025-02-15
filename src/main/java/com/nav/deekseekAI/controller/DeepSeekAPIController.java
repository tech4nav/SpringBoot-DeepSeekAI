package com.nav.deekseekAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekAPIController {

    private final ChatClient apiChatClient;

    public DeepSeekAPIController(@Qualifier("chatClientOpenAI") ChatClient chatClient) {
        this.apiChatClient = chatClient;
    }

    @GetMapping("/apiDeepseek/{prompt}")
    public String promptResponse(@PathVariable String prompt) {
        return apiChatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}
