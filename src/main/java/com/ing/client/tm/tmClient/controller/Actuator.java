package com.ing.client.tm.tmClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.client.tm.tmClient.service.HealthService;
import com.ing.client.tm.tmClient.entities.Metrics;

@CrossOrigin
@RestController
@RequestMapping("/api/actuator")
public class Actuator {
	
	@Autowired
	private HealthService travelService;
	
	@GetMapping("getHealthMetrics")
	public Metrics getMetricsWithFilter() {
		return travelService.getHealthMetrics();
	}
}
