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
			System.out.println("-------[�޴�����Ʈ]---------");
			menuAdmin.prt();
			System.out.println("-------[�޴�����]---------");
			System.out.println("�޴���ȣ�� �����ϼ���. ���� 99");
			int idx = in.nextInt();
			in.nextLine();
			if(idx==99) {
				break;
			}
			System.out.println("���� �޴��� �����ϼ̽��ϴ�.");
			menuList[idx].prt();
			System.out.println("������ �Է��ϼ���");
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
		System.out.println("-------[�ֹ�����]------");
		for(int i=0; i < orderList.length; i++) {
			if(orderList[i]!=null) {
				BillMenu b= orderList[i];
				System.out.println("�޴��� : "+b.menu.name);
				System.out.println("���� : "+b.menu.price);
				System.out.println("���� : "+b.cnt);
				System.out.println("---------------------");
				sum += (b.menu.price * b.cnt);
			}
		}	
		System.out.println("�ѱݾ� : "+sum);
	}

}
