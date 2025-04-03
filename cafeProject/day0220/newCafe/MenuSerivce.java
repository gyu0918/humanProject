package day0220.newCafe;

import java.io.*;
import java.util.*;

public class MenuSerivce {
    public void addMenu(List<Menu> menus) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("메뉴 이름과 가격 설명을 입력하세요.");
        String menuName = br.readLine();

        //중복체크!!
        if (menus.stream().anyMatch(menu -> menu != null && menu.getMenuName().equals(menuName))) {
            System.out.println("중복 메뉴 입니다!!");
            return;
        }

        int menuPrice =  Integer.parseInt(br.readLine());
        String menuContent = br.readLine();

        //개수 제한
        if (menus.size() >= 5){
            System.out.println("메뉴는 5개 까지 등록가능합니다.");
            return ;
        }

        //넣기
        menus.add(new Menu(menuName,menuPrice, menuContent));
    }
}
