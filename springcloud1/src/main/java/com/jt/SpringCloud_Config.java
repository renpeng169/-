package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class SpringCloud_Config {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Config.class);

	}

}
