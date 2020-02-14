package com.ing.client.tm.tmClient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ing.client.tm.tmClient.common.AppConfig;
import com.ing.client.tm.tmClient.mapping.Root;
import com.ing.client.tm.tmClient.util.MetricsUtility;
import com.ing.client.tm.tmClient.vo.MetricsVO;

@Service
public class HealthServiceImpl implements HealthService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	AppConfig appConfig;

	public MetricsVO getHealthMetrics() {
		String url = appConfig.getActuatorUrl() + "/actuator/httptrace";
		Root traceData = restTemplate.getForEntity(url , Root.class).getBody();
		MetricsUtility utility = new MetricsUtility();
		MetricsVO metricsVO = utility.processAndReturnMetrics(traceData);
		return metricsVO;
	}
}