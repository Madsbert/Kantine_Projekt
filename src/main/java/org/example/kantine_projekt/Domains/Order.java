package org.example.kantine_projekt.Domains;

import java.util.List;

public class Order {
    private List items;
    private int orderId;
    private String orderDate;

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Order(List items, int orderId, String orderDate) {
        this.items = items;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}
