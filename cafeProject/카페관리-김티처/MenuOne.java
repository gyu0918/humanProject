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
		System.out.println("이름 : "+name);
		System.out.println("가격 : "+price);
		System.out.println("정보 : "+info);		
	}
	public void prtReview() {
		
	};

}
