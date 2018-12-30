package autoscoutbackend.models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Inventory(){
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car){
        this.cars.add(car);
    }
}
