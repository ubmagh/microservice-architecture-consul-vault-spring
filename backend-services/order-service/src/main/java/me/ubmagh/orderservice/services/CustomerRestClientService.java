package me.ubmagh.orderservice.services;

import me.ubmagh.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClientService {

    @GetMapping("/customers/{id}?projection=full")
    public Customer customerById( @PathVariable String id);

    @GetMapping("/customers?projection=full")
    public PagedModel<Customer> allCustomers();

}
