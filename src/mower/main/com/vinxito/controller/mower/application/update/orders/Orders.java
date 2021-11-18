package com.vinxito.controller.mower.application.update.orders;


import java.util.List;
import java.util.stream.Collectors;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public static Orders fromValue(List<String> orders) {
        return new Orders(orders.stream().map(Order::fromValue).collect(Collectors.toList()));
    }

    public List<Order> orders() {
        return orders;
    }
}
