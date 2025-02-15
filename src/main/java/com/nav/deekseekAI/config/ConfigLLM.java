package com.nav.deekseekAI.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigLLM {

    @Bean
    public ChatClient chatClientOpenAI(OpenAiChatModel apiModel) {
        return ChatClient.create(apiModel);
    }

    @Bean
    public ChatClient chatClientOllama(OllamaChatModel ollamaModel) {
        return ChatClient.create(ollamaModel);
    }
}
