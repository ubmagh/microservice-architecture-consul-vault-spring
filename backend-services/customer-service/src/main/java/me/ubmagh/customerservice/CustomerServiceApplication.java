package me.ubmagh.customerservice;

import me.ubmagh.customerservice.dtos.requests.CustomerRequestDTO;
import me.ubmagh.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.saveCustomer( new CustomerRequestDTO( "", "AYoub", "ubmagh@gmail.com") );
            customerService.saveCustomer( new CustomerRequestDTO( "", "mohamed", "mohamed@gmail.com") );
            customerService.saveCustomer( new CustomerRequestDTO( "", "hassan", "hassan@gmail.com") );
        };
    }


}
