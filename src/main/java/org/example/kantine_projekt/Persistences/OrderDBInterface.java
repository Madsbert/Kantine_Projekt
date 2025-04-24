package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Items;
import org.example.kantine_projekt.Domains.Order;

import java.time.LocalDateTime;

public interface OrderDBInterface {
    public void makeOrder(LocalDateTime dateTime);

    public void addItemToOrder(Order order, Items item);

    public Order getOrder(int orderId);
}
