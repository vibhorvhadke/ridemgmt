# RideWise – Agentic AI Powered Ride Automation System

## Overview

RideWise is a Spring Boot–based Ride Sharing System enhanced with **Agentic AI capabilities**.

The system enables users to interact using **natural language**, for example:

"Book a ride for rider 2 for 6 km"

The AI Agent understands the request, breaks it into steps, and orchestrates backend services to complete the workflow.

---

## Core Features

### Ride-Sharing System
- Rider Registration and Retrieval
- Driver Registration and Availability Management
- Ride Booking and Management
- Fare Calculation

### Strategy Pattern
- RideMatchingStrategy → Assign best driver
- FareStrategy → Calculate ride fare

---

##  Agentic AI Capabilities

### AI Agent Responsibilities
- Accept natural language input
- Understand user intent
- Extract parameters (riderId, distance, location, etc.)
- Decide execution steps
- Call appropriate tools (services)
- Return final response

---
 Architecture
User (Natural Language Input)
↓
AI Controller (/ai/ride)
↓
AI Agent (LangChain4j / OpenAI)
↓
Tool Layer
↓
RideService | DriverService | RiderService
↓
Database (PostgreSQL)


---

## AI Workflow

1. User sends:"Book a ride for rider 2 for 6 km"
2. AI Agent processes input:
- Extracts:
  - riderId = 2
  - distance = 6 km

3. AI Agent calls tools:
- Fetch rider
- Fetch available drivers
- Apply RideMatchingStrategy
- Calculate fare using FareStrategy
- Create ride

4. Final response returned:

Ride booked successfully.
Driver: Anup
Fare: 60
Status: ASSIGNED

---

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- LangChain4j (AI orchestration)
- OpenAI API (LLM)
- Lombok

---

## Dependencies (AI)

<dependency>
 <groupId>dev.langchain4j</groupId>
 <artifactId>langchain4j</artifactId>
</dependency>

<dependency>
 <groupId>dev.langchain4j</groupId>
 <artifactId>langchain4j-open-ai</artifactId>
</dependency>

I Tools (Service Exposure)
Existing services are exposed as tools:

RideService → Book ride
DriverService → Fetch available drivers
RiderService → Fetch rider

These are invoked dynamically by the AI agent.

API Usage
 AI Endpoint
POST /ai/ride
Request:
{
  "message": "Book a ride for rider 2 for 6 km"
}

Response:
Ride booked successfully.
Driver: Anup
Fare: 60
Status: ASSIGNED

How to Run
1.Configure OpenAI API Key:
spring.ai.openai.api-key=YOUR_API_KEY

2.Start application:
RidewiseApplication.java

Test using Client:
POST http://localhost:8080/ai/ride

Database Verification
After API execution, verify:

Ride table updated 
FareReceipt created 
Driver availability updated 

Design Principles

SOLID principles followed
Strategy Pattern used for flexibility
Clean separation of concerns
AI layer decoupled from business logic

Future Enhancements

Dynamic NLP parsing (no hardcoding)
Multi-agent workflow orchestration
Real-time driver matching
Context-aware AI responses