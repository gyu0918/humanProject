package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Dog extends Super{
    String dogname;
    int dogage;
    Scanner in = new Scanner(System.in);

    public Dog() {

    }

    @Override
    public void prt() {
        super.prt();
        System.out.println("강아지 이름 :"+this.dogname);
    }

    @Override
    public void eatting() {
        beforeeat();
        System.out.println("개밥");
    }
    private void beforeeat() {
        System.out.println("밥을 먹기전에 세수한다.");
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름입력");
        String username=in.nextLine();
        System.out.println("강아지 이름입력");
        String dogname=in.nextLine();
        super.username=username;
        this.dogname=dogname;
        System.out.println("1.등록 2.먹이주기 3.잠자기");

    }

}

