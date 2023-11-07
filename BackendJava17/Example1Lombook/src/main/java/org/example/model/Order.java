package org.example.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @ToString.Include
    private LocalDateTime moment;

    private OrderStatus status;
   @ToString.Include
    private Client client;
    @ToString.Include
    private List<OrderItem> items;

    public void additem(OrderItem item){
        items.add(item);
    }
}
