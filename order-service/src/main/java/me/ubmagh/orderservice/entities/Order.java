package me.ubmagh.orderservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ubmagh.orderservice.enums.OrderStatus;
import me.ubmagh.orderservice.models.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "orders")
public class Order {

    @Id
    private String id;
    private Date createdAt;
    private OrderStatus status;
    private String customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems=new ArrayList<ProductItem>();
}
