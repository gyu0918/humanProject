package carManagerProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 찜정보 기능을 추가한다.



public class StartMenu {
    public StartMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CarService carService = new CarService();

        CarRepairListService carRepairListService= new CarRepairListService();

        RepairHistoryService repairHistoryService = new RepairHistoryService();

        boolean flag = true;
        while (flag){
            System.out.println("1. 자동차관리 2. 수리정보 3. 자동차 수리 리스트 4. 종료");
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
                    System.out.println("수리 정비사 이름을 입력하세요.");
                    String mechanicName = br.readLine();
                    if (carRepairListService.searchMechanicName(mechanicName)) {
                        carRepairListService.ptrCarRepairList(mechanicName);
                        System.out.println("수리할 자동차를 추가하겠습니까? yes or else");
                        if (br.readLine().equals("yes")) {
                            carRepairListService.addCarRepairList(mechanicName, carService);
                        }
                    }else {
                        System.out.println(" 새로운 정비사님 환영합니다. 수리할 자동차를 추가하겠습니까? yes or else");
                        if (br.readLine().equals("yes")) {
                            carRepairListService.addCarRepairList(mechanicName, carService);
                        }
                    }

                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                    break;
            }
        }
    }



}
