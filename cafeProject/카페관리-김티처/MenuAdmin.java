package main;

import java.util.Scanner;

public class MenuAdmin {	
	
	MenuOne[] menuList = new MenuOne[5];
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1.메뉴등록하기 2.메뉴보기 3.종료하기");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				addMenu();
			}else if(a==2) {
				prt();
			}else {
				break;
			}
		}
		
	}
	
	private void addMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("새로운 메뉴의 이름을 입력하세요");
		String name = in.nextLine();
		System.out.println("새로운 메뉴의 가격을 입력하세요");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("새로운 메뉴의 정보을 입력하세요");
		String info=in.nextLine();
		MenuOne menuone = new MenuOne(name, price, info);
		for(int i=0; i<menuList.length; i++) {
			if(menuList[i]==null) {
				menuList[i]=menuone;
				break;
			}
		}
		
	}

	public void prt() {
		//메뉴내역 출력하기
		for(int i=0; i<menuList.length; i++) {
			if(menuList[i]!=null) {
				System.out.println("--------------");
				System.out.println("메뉴번호 : "+i);
				menuList[i].prt();				
			}
		}
		
	}

}
