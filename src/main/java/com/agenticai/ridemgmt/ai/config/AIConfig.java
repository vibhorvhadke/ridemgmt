package com.agenticai.ridemgmt.ai.config;

import com.agenticai.ridemgmt.ai.agent.RideAgent;
import com.agenticai.ridemgmt.ai.tools.DriverTools;
import com.agenticai.ridemgmt.ai.tools.RideTools;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean
    public RideAgent rideAgent(RideTools rideTools, DriverTools driverTools) {

        ChatLanguageModel model = OpenAiChatModel.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .apiKey("sk-or-v1-7------------------")
                .modelName("openai/gpt-4o-mini")     // OpenRouter model ID
                .build();

        return AiServices.builder(RideAgent.class)
                .chatLanguageModel(model)
                .tools(rideTools, driverTools)
                .build();
    }
}