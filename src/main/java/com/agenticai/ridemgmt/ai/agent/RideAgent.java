package com.agenticai.ridemgmt.ai.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface RideAgent {

    @SystemMessage("""
        You are an AI Ride Booking Assistant.
        Break user request into steps:
        1. Identify rider
        2. Find driver
        3. Calculate fare
        4. Book ride
        """)
    String process(@UserMessage String userInput);
}