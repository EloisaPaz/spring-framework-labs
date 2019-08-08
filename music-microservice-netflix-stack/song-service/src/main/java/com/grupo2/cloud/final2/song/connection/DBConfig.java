package com.grupo2.cloud.final2.song.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource ("classpath:application.properties")
public class DBConfig {
	
	@Bean
	public DBConnection connection () {
		return new DBConnection ();
	}

}
