package main;

import java.util.Scanner;

public class BillOrder {
	String userName=null;
	BillMenu[] orderList = new BillMenu[5];
	MenuAdmin menuAdmin = null;
	
	BillOrder(MenuAdmin menuAdmin) {
		this.menuAdmin = menuAdmin;
	}
		
	public void menu() {
		Scanner in = new Scanner(System.in);
		MenuOne[] menuList = menuAdmin.menuList;
		while(true) {
			System.out.println("-------[메뉴리스트]---------");
			menuAdmin.prt();
			System.out.println("-------[메뉴선택]---------");
			System.out.println("메뉴번호를 선택하세요. 종료 99");
			int idx = in.nextInt();
			in.nextLine();
			if(idx==99) {
				break;
			}
			System.out.println("다음 메뉴를 선택하셨습니다.");
			menuList[idx].prt();
			System.out.println("수량을 입력하세요");
			int cnt= in.nextInt();
			in.nextLine();
			
			for(int i=0; i < orderList.length; i++) {
				if(orderList[i]==null) {
					BillMenu billorder = new BillMenu();
					billorder.menu=menuList[idx];
					billorder.cnt=cnt;
					orderList[i]=billorder;
					break;
				}
			}	
			prt();
		}	
	}
	
	public void prt() {
		int sum=0;
		System.out.println("-------[주문내역]------");
		for(int i=0; i < orderList.length; i++) {
			if(orderList[i]!=null) {
				BillMenu b= orderList[i];
				System.out.println("메뉴명 : "+b.menu.name);
				System.out.println("가격 : "+b.menu.price);
				System.out.println("수량 : "+b.cnt);
				System.out.println("---------------------");
				sum += (b.menu.price * b.cnt);
			}
		}	
		System.out.println("총금액 : "+sum);
	}

}
