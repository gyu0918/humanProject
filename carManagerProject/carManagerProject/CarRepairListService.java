package carManagerProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.*;
import java.util.*;


public class CarRepairListService {
    private List<CarRepairListInfo> carRepairListInfos = new ArrayList<>();

    public boolean searchMechanicName(String mechanicName) {
        return carRepairListInfos.stream()
                .anyMatch(carRepairListInfo -> carRepairListInfo != null && carRepairListInfo.getMechanicName().equals(mechanicName));
    }

    public void ptrCarRepairList(String mechanicName) {
        carRepairListInfos.stream().filter(carRepairListInfo -> carRepairListInfo != null && carRepairListInfo.getMechanicName().equals(mechanicName))
                .forEach(carRepairListInfo -> {
            System.out.println("자동차 오너  = " + carRepairListInfo.getRepairCarOwner());
            System.out.println("자동차 번호  = " + carRepairListInfo.getRepairCarNumber());
        });
    }

    public void addCarRepairList(String mechanicName, CarService carService) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 등록된 자동차를 프린터 해서 여기서 고르라고 한다.
        // 이떄 이미 자동차 수리 리스트에 있는 자동차는 제외 하도록 한다 이중포문형식?
        carService.getCars().stream()
                .filter(car -> car != null && carRepairListInfos.stream()
                        .noneMatch(carRepairListInfo -> carRepairListInfo.getRepairCarNumber().equals(car.getCarNumber())))
                .collect(Collectors.toList());

        CarRepairListInfo carRepairListInfo = new CarRepairListInfo();
        carRepairListInfo.setMechanicName(mechanicName);
        System.out.println(" 수리 할 자동차 주인과 자동차 넘버를 입력하세요." );
        carRepairListInfo.setRepairCarOwner(br.readLine());
        carRepairListInfo.setRepairCarNumber(br.readLine());
        carRepairListInfos.add(carRepairListInfo);

    }
}
