package org.example;

public class OrderInfo {
    String orderMember;
    String orderMenuName;
    int orderMenuPrice;
    int orderMenuQuantity;

    public OrderInfo(String orderMember, String orderMenuName, int orderMenuPrice, int orderMenuQuantity) {
        this.orderMember = orderMember;
        this.orderMenuName = orderMenuName;
        this.orderMenuPrice = orderMenuPrice;
        this.orderMenuQuantity = orderMenuQuantity;
    }
}
