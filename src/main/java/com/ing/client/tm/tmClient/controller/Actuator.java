package com.ing.client.tm.tmClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.client.tm.tmClient.service.TravelService;
import com.ing.client.tm.tmClient.vo.MetricsVO;

@RestController
@RequestMapping("/api/actuator")
public class Actuator {
	
	@Autowired
	private TravelService travelService;
	
	@GetMapping("getHealthMetrics")
	public MetricsVO getMetricsWithFilter() {
		return travelService.getHealthMetrics();
	}
}
