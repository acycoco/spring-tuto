package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController      //view에 controller
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);//이 클래스에 대한 log
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello") //localhost:8080/hello로 접속하면       http://localhost:8080/hello?name=aaa
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello" + name;
	}

	@Bean //시작할 때 자동으로 시작     shell에 찍히겠금, log로
	public CommandLineRunner demo(CustomerRepository repository) {   //의존성 주입 자동으로 입력해줌
		return args -> {
			repository.save(new Customer("leo", "aa"));

			for (Customer customer: repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");
		};
	}
}
