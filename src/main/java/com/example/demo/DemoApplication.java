package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController      //view에 controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello") //localhost:8080/hello로 접속하면       http://localhost:8080/hello?name=aaa
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello" + name;
	}

}
