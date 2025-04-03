package carManagerProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private List<Car> cars = new ArrayList<>();


    public void addCar() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("자동차 소유자 이름과 자동차 번호를 입력하세요.");
            Car car = new Car();
            car.setCarOwner(br.readLine());
            car.setCarNumber(br.readLine());
            cars.add(car);
    }
    public void ptrAllCar(){
        cars.stream().forEach((car) -> {
            System.out.println("자동차 소유자 =  " + car.getCarOwner());
            System.out.println("자동차 번호  = " + car.getCarNumber());
        });
    }
    public List<Car> getCars() {
        return cars;
    }
}
