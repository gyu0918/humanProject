package day0220.newCafe;

import java.util.*;
import java.io.*;

public class OrderService {
    public void createOrder(List<OrderInfo> orderInfoList, List<Menu> menus, List<Review> reviews, ReviewService reviewService) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("주문자 별명을 입력하세요.");
        String alias = br.readLine();
        System.out.println("1번 주문하기 || 2번 주문한 리스트 확인하기");
        int choice = Integer.parseInt(br.readLine());

        if (choice == 1) {
            System.out.println("메뉴는 다음과 같습니다.");
            for (Menu menu : menus){
                    if (menu != null){
                        System.out.println(" 메뉴 = " + menu.getMenuName() +  " 메뉴가격 : " + menu.getPrice() + " 메뉴 내용 : " + menu.getMenuContent());
                    }
            }
            System.out.println("메뉴와 수량을 입력해주세요");
            String menuName = br.readLine();
            int quantity = Integer.parseInt(br.readLine());

            //주문메뉴가 이미 있는경우 check
            if (checkDoubleOrder(menuName, orderInfoList)){
                // 기존 주문 찾기 및 수량 증가
                for (OrderInfo orderInfo : orderInfoList) {
                    if (orderInfo != null && orderInfo.getOrderMenuName().equals(menuName)) {
                        orderInfo.setOrderMenuQuantity(orderInfo.getOrderMenuQuantity() + quantity);
                        break;
                    }
                }
            }else {
                // 메뉴에서 가격 찾기
                int price = 0;
                for (Menu menu : menus) {
                    if (menu != null && menu.getMenuName().equals(menuName)) {
                        price = menu.getPrice();
                        break;
                    }
                }
                orderInfoList.add(new OrderInfo(alias,menuName, price,quantity));
            }
            System.out.println("후기를 남기시겠습니까? yes");
            String choiceReview = br.readLine();
            if (choiceReview.equals("yes")) {
                System.out.println("후기 내용을 입력하세요.");
                reviewService.addReview(alias,br.readLine(),menuName, reviews);
            }
        } else if (choice == 2) {
            System.out.println("주문한 리스트는 다음과 같습니다");
            for (OrderInfo orderInfo : orderInfoList){
                if (orderInfo != null && orderInfo.getOrderMember().equals(alias)){
                    System.out.println(orderInfo.getOrderMember() + " " + orderInfo.getOrderMenuName()
                            + " " + orderInfo.getOrderMenuQuantity() +
                            "개 총금액 = " + (orderInfo.getOrderMenuPrice() * orderInfo.getOrderMenuQuantity()));
                }
            }

        }
    }
    public void checkOrder(List<OrderInfo> orderInfoList) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" 주문자 별명을 적으세요.");
        String name = br.readLine();

        for (OrderInfo orderInfo : orderInfoList){
            if (orderInfo.getOrderMember().equals(name)){
                System.out.println( "메뉴 이름 = " + orderInfo.getOrderMenuName() + " 가격 = "
                        + orderInfo.getOrderMenuQuantity() + " 수량 = " + orderInfo.getOrderMenuQuantity());
            }
        }
    }
    public boolean checkDoubleOrder(String menuName, List<OrderInfo> orderInfoList) {
        return orderInfoList.stream()
                .anyMatch(orderInfo -> orderInfo != null && orderInfo.getOrderMenuName().equals(menuName));
    }
}
