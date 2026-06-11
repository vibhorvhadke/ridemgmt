package com.agenticai.ridemgmt.ai.tools;

import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.service.DriverService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverTools {

    private final DriverService driverService;

    public DriverTools(DriverService driverService) {
        this.driverService = driverService;
    }

    @Tool("Find available drivers")
    public List<Driver> getAvailableDrivers() {
        return driverService.getDrivers(true);
    }
}