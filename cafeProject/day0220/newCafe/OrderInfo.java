package day0220.newCafe;

public class OrderInfo {
    private String orderMember;
    private String orderMenuName;
    private int orderMenuPrice;
    private int orderMenuQuantity;

    public OrderInfo(String orderMember, String orderMenuName, int orderMenuPrice, int orderMenuQuantity) {
        this.orderMember = orderMember;
        this.orderMenuName = orderMenuName;
        this.orderMenuPrice = orderMenuPrice;
        this.orderMenuQuantity = orderMenuQuantity;
    }

    public String getOrderMember() {
        return orderMember;
    }

    public void setOrderMember(String orderMember) {
        this.orderMember = orderMember;
    }

    public String getOrderMenuName() {
        return orderMenuName;
    }

    public void setOrderMenuName(String orderMenuName) {
        this.orderMenuName = orderMenuName;
    }

    public int getOrderMenuPrice() {
        return orderMenuPrice;
    }

    public void setOrderMenuPrice(int orderMenuPrice) {
        this.orderMenuPrice = orderMenuPrice;
    }

    public int getOrderMenuQuantity() {
        return orderMenuQuantity;
    }

    public void setOrderMenuQuantity(int orderMenuQuantity) {
        this.orderMenuQuantity = orderMenuQuantity;
    }
}
