package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.atguigu.springboot.mapper")
@SpringBootApplication
public class ChartdiyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartdiyApplication.class, args);
	}
}
