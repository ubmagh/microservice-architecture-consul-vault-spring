package me.ubmagh.orderservice.entities;
import me.ubmagh.orderservice.enums.OrderStatus;
import org.springframework.data.rest.core.config.Projection;
import java.util.Date;

@Projection(name="full",types = Order.class)
public interface OrderProjection {
    String getId();
    Date getCreatedAt();
    String getCustomerId();
    OrderStatus getStatus();
}
