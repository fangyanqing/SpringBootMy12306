package com.neuedu.catshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.neuedu.catshop.mapper"})
public class SpringBootCatShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCatShopApplication.class, args);
	}

}
