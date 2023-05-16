package h2o.water.demo;

import h2o.water.demo.model.Customer;
import h2o.water.demo.model.CustomerStatus;
import h2o.water.demo.model.StudentPaymentMethod;
import h2o.water.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// 1
		//CustomerRepository customerRepository = context.getBean("customerRepository", CustomerRepository.class);
		//customerRepository.createCustomer(new Customer(0, "tomer", "avivi", "tomeravivi@gmail.com", CustomerStatus.VIP, StudentPaymentMethod.CASH));
	}

	// 2
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.createCustomer(new Customer(0, "tomer", "avivi", "tomeravivi@gmail.com", CustomerStatus.VIP, StudentPaymentMethod.CASH));
		};
	}

}
