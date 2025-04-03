package carManagerProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public CarManager() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CarService carService = new CarService();

        RepairHistoryService repairHistoryService = new RepairHistoryService();

        boolean flag = true;
        while (flag){
            System.out.println("1. 자동차관리 2. 수리정보 3. 종료");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("1. 자동차 등록 2. 자동차 전체 보기");
                    int carType = Integer.parseInt(br.readLine());
                    if (carType == 1) {
                        carService.addCar();
                    }else if (carType == 2) {
                        carService.ptrAllCar();
                    }
                    break;
                case 2:
                    System.out.println("1. 수리내역 입력 2. 수리내역 전체 보기");
                    int repairNum = Integer.parseInt(br.readLine());
                    if (repairNum == 1) {
                        repairHistoryService.addRepairHistory();
                    }else if (repairNum == 2) {
                        repairHistoryService.ptrRepairHistory();
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                    break;
            }
        }
    }



}
