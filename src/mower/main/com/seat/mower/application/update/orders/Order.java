package com.seat.mower.application.update.orders;


public class Order {

    private final OrderType type;

    public Order(OrderType type) {
        this.type = type;
    }

    public static Order fromValue(String value) {
        return new Order(OrderType.fromValue(value));
    }

    public OrderType type() {
        return type;
    }

}
