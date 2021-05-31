package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		Cache<String,String> cache = CacheBuilder.newBuilder().build();
//		cache.put("word","Hello Guava Cache");
//		System.out.println(cache.getIfPresent("word"));
	}

}
