package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Order;

public interface OrderDBInterface {
    public Order makeOrder();

    public Order updateOrder(Order order);

    public Order getOrder(int orderId);
}
