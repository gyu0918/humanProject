package carManagerProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RepairHistoryService {
    private List<RepairHistory> repairHistoryList = new ArrayList<>();

    public void addRepairHistory() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("자동차 번호를 입력하세요.");
        String carNumber = br.readLine();
        System.out.println(" 수리 내역은 다음과 같습니다. ");
        repairHistoryList.stream()
                .filter(repairHistory -> repairHistory.getRepairCarNumber().equals(carNumber))
                .forEach(repairHistory -> {
                    System.out.println("수리 날짜 = " + repairHistory.getRepairDate());
                    System.out.println("수리 내용 = " + repairHistory.getRepairContent());
                });


        System.out.println(" 수리 내역 입력하고 싶으면 날짜와 수리 내용을 입력하세요. ");

        RepairHistory repairHistory = new RepairHistory();
        repairHistory.setRepairCarNumber(carNumber);
        repairHistory.setRepairDate(br.readLine());
        repairHistory.setRepairContent(br.readLine());
        repairHistoryList.add(repairHistory);
    }
    public void ptrRepairHistory() {
        repairHistoryList.stream().forEach((repairHistory) -> {
            System.out.println("자동차 넘버 =  " + repairHistory.getRepairCarNumber());
            System.out.println("자동차 수리 날짜 = " + repairHistory.getRepairDate());
            System.out.println("자동차 수리 내용 = " + repairHistory.getRepairContent());
        });
    }
}
