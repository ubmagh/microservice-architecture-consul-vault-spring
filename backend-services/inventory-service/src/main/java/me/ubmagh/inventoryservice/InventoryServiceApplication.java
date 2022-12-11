package me.ubmagh.inventoryservice;

import me.ubmagh.inventoryservice.entities.Product;
import me.ubmagh.inventoryservice.repositoties.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder().id(UUID.randomUUID().toString()).name("product1").price(Math.random()*374).quantity(10).build(),
                            Product.builder().id(UUID.randomUUID().toString()).name("product2").price(Math.random()*377).quantity(22).build(),
                            Product.builder().id(UUID.randomUUID().toString()).name("product3").price(Math.random()*255).quantity(19).build(),
                            Product.builder().id(UUID.randomUUID().toString()).name("product4").price(Math.random()*123).quantity(1).build()
                    )
            );
        };
    }
}
