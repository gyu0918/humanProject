package main;

import java.util.Scanner;

public class StartMenu {
	MenuAdmin menuadmin=new MenuAdmin();
	OrderAdmin orderadmin = new OrderAdmin(menuadmin);	
	StartMenu(){
		menu();
	}
	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1. 메뉴관리  2. 주문하기 3. 종료");
			int selectNum = in.nextInt();
			in.nextLine();
			
			if(selectNum==1) {
				menuadmin.menu();
			}else if(selectNum==2) {
				orderadmin.menu();
			}else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
	}
}
