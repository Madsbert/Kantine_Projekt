package org.example.kantine_projekt.Domains;

import java.util.List;

public class Order {
    private List items;
    private int orderId;
    private String orderDate;

    public Order(List items, int orderId, String orderDate) {
        this.items = items;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}
