package com.bianla.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bianla.admin.dao")
public class BianlaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BianlaApplication.class, args);
	}
}
