package main;

public class MenuOne {
	String name=null;
	int price=0;
	String info=null;
	
	MenuOne(String name, int price, String info) {
		this.name=name;
		this.price=price;
		this.info=info;
	}
	
	public void prt() {
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+price);
		System.out.println("���� : "+info);		
	}
	public void prtReview() {
		
	};

}
