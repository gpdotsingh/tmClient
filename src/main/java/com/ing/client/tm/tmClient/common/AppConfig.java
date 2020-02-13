package com.ing.client.tm.tmClient.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.properties")
public class AppConfig {
	
	@Value("${travel.actuatorUrl}")
	private String actuatorUrl;

	public String getActuatorUrl() {
		return actuatorUrl;
	}
	public void setActuatorUrl(String actuatorUrl) {
		this.actuatorUrl = actuatorUrl;
	}
}
