//package day0220;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class  Main {
//
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Function function = new Function();
//        Menu[] menu = new Menu[5];
//        OrderInfo[] orderInfos = new OrderInfo[5];
//        Review[] reviews = new Review[5];
//
//        while(true) {
//            System.out.println("1. 메뉴 등록 || 2번 주문하기 || 3번 주문 조회하기 || 4번 리뷰보기 || 5번 종료");
//            int num = Integer.parseInt(br.readLine());
//            if (num == 1) {
//                function.addmenu(menu);
//            }else if (num == 2) {
//                function.order(menu, orderInfos, reviews);
//            }else if (num == 3) {
//                function.checkOrder(orderInfos);
//            }else if (num == 4) {
//                function.ptrReview(reviews);
//            }else if (num == 5) {
//                break ;
//            }
//        }
//    }
//}
