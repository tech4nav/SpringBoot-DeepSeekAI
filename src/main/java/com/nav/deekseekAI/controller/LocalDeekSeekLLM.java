package com.nav.deekseekAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalDeekSeekLLM {

    private final ChatClient localChatClient;

    public LocalDeekSeekLLM(@Qualifier("chatClientOllama") ChatClient chatClient) {
        this.localChatClient = chatClient;
    }

    @GetMapping("/localDeepseek/{prompt}")
    public String promptResponse(@PathVariable String prompt) {
        return localChatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}
