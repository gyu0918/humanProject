package main;

import java.util.Scanner;

public class MenuAdmin {	
	
	MenuOne[] menuList = new MenuOne[5];
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1.�޴�����ϱ� 2.�޴����� 3.�����ϱ�");
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
		System.out.println("���ο� �޴��� �̸��� �Է��ϼ���");
		String name = in.nextLine();
		System.out.println("���ο� �޴��� ������ �Է��ϼ���");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("���ο� �޴��� ������ �Է��ϼ���");
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
		//�޴����� ����ϱ�
		for(int i=0; i<menuList.length; i++) {
			if(menuList[i]!=null) {
				System.out.println("--------------");
				System.out.println("�޴���ȣ : "+i);
				menuList[i].prt();				
			}
		}
		
	}

}
