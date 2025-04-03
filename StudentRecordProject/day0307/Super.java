package day0307;

import java.io.IOException;

public abstract class Super {

    String username;
    String useraddr;

    public Super() {
        // TODO Auto-generated constructor stub
    }

    public void eatting() {
        System.out.println("슈퍼eat");
    }
    public abstract void menu();
    public void prt() {
        System.out.println("보호자 이름 :"+this.username);
    }

}
