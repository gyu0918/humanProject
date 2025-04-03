package main;

public abstract class Super {

    String username;
    String useraddr;

    public Super() {
        // TODO Auto-generated constructor stub
    }

    public void setData(String u, String a) {
        this.useraddr=u;
        this.useraddr=a;
    }
    public void eatting() {
        System.out.println("슈퍼eat");
    }
    public abstract void menu();
    public void prt() {
        System.out.println("보호자 이름 :"+this.username);
    }

}