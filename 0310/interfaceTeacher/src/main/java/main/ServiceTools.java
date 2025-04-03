package main;

import java.util.Scanner;

import inf.BloodTest;
import inf.ServiceINF;
import inf.Sobyun;
import inf.Xray;

public class ServiceTools {
    private static ServiceTools st=null;

    private ServiceTools() {
        // TODO Auto-generated constructor stub
    }
    public static ServiceTools getInstance() {
        if(st==null) {
            st = new ServiceTools();
        }
        return st;
    }
    public ServiceINF choiceService() {
        Scanner in = new Scanner(System.in);
        ServiceINF s=null;

        System.out.println("원하는 서비스를 선택하세요");
        System.out.println("1.엑스 2.소변 3.혈액");
        int a = in.nextInt();
        in.nextLine();
        switch(a) {
            case 1: s = new Xray(); break;
            case 2: s = new Sobyun();break;
            case 3: s = new BloodTest();break;
        }

        return s;
    }

}
