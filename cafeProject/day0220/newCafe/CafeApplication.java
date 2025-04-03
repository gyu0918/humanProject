package day0220.newCafe;


import java.io.*;
import java.util.*;

public class CafeApplication {
    public CafeApplication() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MenuSerivce menuSerivce = new MenuSerivce();
        OrderService orderService = new OrderService();
        ReviewService reviewService = new ReviewService();

        List<Menu> menus = new ArrayList<>();
        List<OrderInfo> orderInfos = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();

        while(true){
            System.out.println("1. 메뉴 등록 || 2번 주문하기 || 3번 주문 조회하기 || 4번 리뷰보기 || 5번 종료");
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                menuSerivce.addMenu(menus);
            }else if (num == 2) {
                orderService.createOrder(orderInfos, menus, reviews, reviewService);
            }else if (num == 3) {
                orderService.checkOrder(orderInfos);
            }else if (num == 4) {
                reviewService.ptrReview(reviews);
            }else if (num == 5) {
                break ;
            }
        }
    }
}
