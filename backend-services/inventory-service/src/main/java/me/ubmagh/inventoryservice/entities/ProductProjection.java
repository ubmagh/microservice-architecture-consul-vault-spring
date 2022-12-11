package me.ubmagh.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full", types = Product.class)
public interface ProductProjection {
    public String getId();
    public double getPrice();
    public String getName();
    public int getQuantity();
}
