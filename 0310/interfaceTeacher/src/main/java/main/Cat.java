package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inf.ServiceINF;

public class Cat extends Super{
    String catname;
    ArrayList<String> l = new ArrayList<>();
    ServiceTools st = ServiceTools.getInstance();
    List<ServiceINF> serviceList = new ArrayList<>();

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
        servicePrt();
    }
    private void servicePrt() {
        System.out.println("서비스 리스트 출력");
        for(ServiceINF s:serviceList) {
            s.info();
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
        addS();
    }
    private void addS() {
        ServiceINF s = st.choiceService();
        serviceList.add(s);
    }

}
