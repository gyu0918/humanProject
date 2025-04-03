package day0220.newCafe;

import java.util.*;
import java.io.*;

public class ReviewService {
    public void addReview(String member, String reviewContent, String menuName, List<Review> reviews){
        reviews.add(new Review(reviewContent,menuName,member));
    }
    public void ptrReview(List<Review> reviews) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("후기를 볼려고 하는 메뉴를 입력하세요.");
        String menuName = br.readLine();
        for (Review review : reviews){
            if (review != null && review.getMenuName().equals(menuName)){
                System.out.println(" 이름 = " + review.getOrderer());
                System.out.println(" 후기 내용 = " + review.getContent());
            }

        }
    }
}
