package me.ubmagh.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection( name = "full", types = Customer.class)
public interface CustomerProjection {

    public String getId();
    public String getEmail();
    public String getName();

}
