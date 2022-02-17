package com.bootcamp4.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserManagementApplication {

	public static void main(String[] args) {
		//test
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
