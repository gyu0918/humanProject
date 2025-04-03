//package org.example;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Function {
//    public void addmenu(Menu[] menu) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("메뉴 이름과 가격 설명을 입력하세요.");
//        String menuName = br.readLine();
//        //중복체크!!
//        for (int i = 0; i < menu.length; i++) {
//            if (menu[i] != null && menuName.equals(menu[i].name)) {
//                System.out.println("중복메뉴가 있습니다.");
//                return ;
//            }
//        }
//        int menuPrice =  Integer.parseInt(br.readLine());
//        String menuContent = br.readLine();
//
//        for (int i = 0; i < 5; i++) {
//            if (menu[i] == null) {
//                Menu newMenu = new Menu(menuName, menuPrice, menuContent);
//                menu[i] = newMenu;
//                break;
//            }
//        }
//
//    }
//
//    public  void order(Menu[] menu, OrderInfo[] orderInfos, Review[] review) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("주문자 별명을 입력하세요.");
//        String alias = br.readLine();
//        System.out.println("1번 주문하기 || 2번 주문한 리스트 확인하기");
//        int choice = Integer.parseInt(br.readLine());
//        if (choice == 1) {
//            System.out.println("메뉴는 다음과 같습니다.");
//            for (int i = 0; i < menu.length; i++) {
//                if (menu[i] != null) {
//                    System.out.println(i + "번 메뉴이름 : " + menu[i].name +
//                            " 메뉴가격 : " + menu[i].price + " 메뉴 내용 : " + menu[i].content);
//                }
//            }
//            System.out.println("메뉴번호와 수량을 입력해주세요");
//            int menuNum = Integer.parseInt(br.readLine());
//            int quantity = Integer.parseInt(br.readLine());
//            int reviewIndex = 0;
//            //주문메뉴가 이미 있는경우 check
//
//
//            for (int i = 0; i < orderInfos.length; i++) {
//                // 주문목록안에 주문메뉴가 이미 있는 경우 //동일 메뉴주문일 경우 수량 + 된다.
//                if (orderInfos[i] != null  && menu[menuNum] != null && orderInfos[i].orderMenuName.equals(menu[menuNum].name)) {
//                    orderInfos[i].orderMenuQuantity += quantity;
//                    System.out.println("총금액 = " + orderInfos[i].orderMenuQuantity * orderInfos[i].orderMenuPrice + " 원");
//                    break ;
//                }else if (orderInfos[i] == null) {
//                    OrderInfo newOrderInfos = new OrderInfo(alias, menu[menuNum].name, menu[menuNum].price, quantity);
//                    orderInfos[i] = newOrderInfos;
//                    reviewIndex = i;
//                    System.out.println("총금액 = " + orderInfos[i].orderMenuQuantity * orderInfos[i].orderMenuPrice + " 원");
//                    break;
//                }
//            }
//            System.out.println("후기를 남기시겠습니까? yes");
//            String choiceReview = br.readLine();
//            if (choiceReview.equals("yes")) {
//                if (review[reviewIndex] == null) {
//                    System.out.println("후기 내용을 입력하세요.");
//                    Review newReview = new Review(orderInfos[reviewIndex].orderMember, br.readLine(), orderInfos[reviewIndex].orderMenuName);
//                    review[reviewIndex] = newReview;
//                } else {
//                    System.out.println("후기가 이미 있습니다. ");
//                }
//
//            }
//
//        } else if (choice == 2) {
//            System.out.println("주문한 리스트는 다음과 같습니다");
//            for (int i = 0; i < orderInfos.length; i++) {
//                if (orderInfos[i] != null && orderInfos[i].orderMember.equals(alias)) {
//                    System.out.println(orderInfos[i].orderMember + " " + orderInfos[i].orderMenuName +
//                            " " + orderInfos[i].orderMenuQuantity + "개 총금액 = " + (orderInfos[i].orderMenuPrice * orderInfos[i].orderMenuQuantity));
//                }
//            }
//        }
//    }
//
//    public void checkOrder(OrderInfo[] orderInfos) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(" 주문자 별명을 적으세요.");
//        String name = br.readLine();
//        for (int i = 0; i < orderInfos.length; i++) {
//            if (orderInfos[i] != null && orderInfos[i].orderMember.equals(name)) {
//                System.out.println( "메뉴 이름 = " + orderInfos[i].orderMenuName + " 가격 = " + orderInfos[i].orderMenuPrice + " 수량 = " + orderInfos[i].orderMenuQuantity);
//            }
//        }
//
//
//
//    }
//    public void ptrReview(Review[]reviews) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("후기를 볼려고 하는 메뉴를 입력하세요.");
//        String menuName = br.readLine();
//        for (int i = 0; i < reviews.length; i++) {
//            if (reviews[i] != null && reviews[i].reviewMenuName.equals(menuName)) {
//                System.out.println(" 이름 = " + reviews[i].reviewMember);
//                System.out.println(" 후기 내용 = " + reviews[i].reviewContent);
//            }
//        }
//    }
//
//}
