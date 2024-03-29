package me.ubmagh.orderservice.repositories;

import me.ubmagh.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, String> {
    @RestResource(path = "/byCustomerId")
    List<Order> findByCustomerId(@Param("customerId") String customerId);
}
