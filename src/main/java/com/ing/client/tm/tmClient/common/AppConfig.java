package com.ing.client.tm.tmClient.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.properties")
@Data
public class AppConfig {
	
	@Value("${tm.actuatorUrl}")
	private String actuatorUrl;
	@Value("${tm.server.root.url}")
	private String rootUrl;
	@Value("${tm.server.name.url}")
	private String nameUrl;
}
