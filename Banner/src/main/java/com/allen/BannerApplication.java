package com.allen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

	public static void main(String[] args) {
		System.out.println("服务启动前:-------------------(可用CommandLineRunner来用作初始化操作)");
		SpringApplication.run(BannerApplication.class, args);
		System.out.println("服务启动后:------------------初始化完毕，执行Application.run方法");
	}
}
