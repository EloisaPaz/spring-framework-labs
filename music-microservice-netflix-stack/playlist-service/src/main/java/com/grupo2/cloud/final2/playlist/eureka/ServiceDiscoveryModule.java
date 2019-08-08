package com.grupo2.cloud.final2.playlist.eureka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource ("classpath:application.properties")
public class ServiceDiscoveryModule {
	@Bean
	public EurekaServiceDiscovery eurekaDiscovery() {
		return new EurekaServiceDiscovery();
	}
}
