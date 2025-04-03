package main;

import java.util.Scanner;

public class OrderAdmin {
	MenuAdmin menuadmin=null;
	BillOrder[] orderinfo=new BillOrder[5];
	
	OrderAdmin(MenuAdmin menuadmin){
		this.menuadmin=menuadmin;
	}

	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1. �ֹ��ϱ� 2. �ֹ�����Ʈ Ȯ���ϱ�");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				order();
			}else if(a==2) {
				viewOrder();
			}else {
				break;
			}
		}
	}
	
	public void order() {
		Scanner in = new Scanner(System.in);
		System.out.println("���� �ֹ��� �̾ �Ͻðڽ��ϱ�? 1.yes 2.no");
		int a =in.nextInt();
		in.nextLine();
		System.out.println("�ֹ����� �̸��� �Է��ϼ���");
		String name = in.nextLine();
		if(a==1) {			
			for(int i=0;i<orderinfo.length; i++) {
				if(orderinfo[i]!=null) {
					if(orderinfo[i].userName.equals(name)) {
						orderinfo[i].menu();	
					}
				}
			}
		}else {
			BillOrder order = new BillOrder(menuadmin);
			order.userName=name;
			order.menu();
			for(int i=0; i<orderinfo.length; i++) {
				if(orderinfo[i]==null) {
					orderinfo[i]=order;
					break;
				}
			}
		}
		
	}
	
	public void viewOrder() {
		Scanner in = new Scanner(System.in);
		System.out.println("�ֹ����̸��� �Է��ϼ���");
		String username=in.nextLine();
		for(BillOrder b: orderinfo) {
			if(b != null) {
				if(b.userName.equals(username)) {
					b.prt();
					System.out.println("�ı⸦ ����ڽ��ϱ�? 1.yes 2.no");
					break;
				}
			}
		}
		
	}
}
