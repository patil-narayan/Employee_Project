package com.example.EmployeeManagement;

/*import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "EmployeeManagment", version ="1.0" , description = ""))
public class EmployeeManagementApplication {
	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args ->{
			kafkaTemplate.send("firstTopic", "Hello Kafka");
		};

	}*/
}
