package me.ubmagh.orderservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ubmagh.orderservice.models.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class ProductItem {
    @Id
    private String id;
    private String productId;
    private double price;
    private int quantity;
    private double discount;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    @Transient
    private Product product;

    public double getAmount(){
        return price*quantity*(1-discount);
    }
}

