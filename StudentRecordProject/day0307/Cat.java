package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Scanner;

public class Cat extends Super{
    String catname;
    ArrayList<String> l = new ArrayList<>();

    int catage;
    Scanner in = new  Scanner(System.in);

    public Cat() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void prt() {
        super.prt();
        System.out.println("고양이 이름 : "+this.catname);
        System.out.println("고양이 진료 리스트");
        for(String s:l) {
            System.out.println(s);
        }
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름입력");
        String username=in.nextLine();
        System.out.println("고양이 이름입력");
        String catname=in.nextLine();
        super.username=username;
        this.catname=catname;
        System.out.println("1.등록 2.먹이등록 3.진료");
        //공사중...

    }
}

