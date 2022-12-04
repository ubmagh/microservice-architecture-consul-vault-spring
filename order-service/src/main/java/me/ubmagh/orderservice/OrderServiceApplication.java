package me.ubmagh.orderservice;

import me.ubmagh.orderservice.entities.Order;
import me.ubmagh.orderservice.entities.ProductItem;
import me.ubmagh.orderservice.enums.OrderStatus;
import me.ubmagh.orderservice.models.Customer;
import me.ubmagh.orderservice.models.Product;
import me.ubmagh.orderservice.repositories.OrderRepository;
import me.ubmagh.orderservice.repositories.ProductItemRepository;
import me.ubmagh.orderservice.services.CustomerRestClientService;
import me.ubmagh.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService){
        return args -> {
            List<Customer> customers=customerRestClientService.allCustomers().getContent().stream().toList();
            List<Product> products=inventoryRestClientService.allProducts().getContent().stream().toList();
            String customerId= customers.get(0).getId();
            Random random=new Random();
            Customer customer = customerRestClientService.customerById(customerId);
            for (int i = 0; i <20 ; i++) {
                Order order=Order.builder()
                        .id(UUID.randomUUID().toString())
                        .customerId(customers.get(random.nextInt(customers.size())).getId())
                        .status( Math.random()>0.5 ? OrderStatus.PENDING:OrderStatus.CREATED)
                        .createdAt(new Date())
                        .build();
                Order savedOrder = orderRepository.save(order);
                for (int j = 0; j < products.size() ; j++) {
                    if(Math.random()>0.70){
                        ProductItem productItem=ProductItem.builder()
                                .id(UUID.randomUUID().toString())
                                .order(savedOrder)
                                .productId(products.get(j).getId())
                                .price(products.get(j).getPrice())
                                .quantity(1+random.nextInt(10))
                                .discount(Math.random())
                                .build();
                        productItemRepository.save(productItem);
                    }
                }
            }
        };
    }

}
