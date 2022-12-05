package me.ubmagh.orderservice.services;

import me.ubmagh.orderservice.models.Customer;
import me.ubmagh.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {

    @GetMapping("/products/{id}?projection=full")
    public Product productById(@PathVariable String id);

    @GetMapping("/products?projection=full")
    public PagedModel<Product> allProducts();

}
