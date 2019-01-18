package autoscoutbackend.rest.services;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.JSONList;
import autoscoutbackend.rest.handler.CarHandler;
import autoscoutbackend.test.GetCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class CarServiceResourceController {

    private CarHandler carHandler = new CarHandler();

    @RequestMapping("/get-all-cars")
    public JSONList getAllCars() {
        JSONList jsonList = new JSONList();

        List cars = carHandler.GetAllCars();

        for (Object car : cars){
            jsonList.addItem(car);
        }
        return jsonList;
    }

    @GetMapping("/get-latest-car")
    public Car getLatestCar() {
        return carHandler.GetLatestCar();
    }

    @RequestMapping(value = "/get-time")
    public String getTimeMessage(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @GetMapping(value = "/car-id/{id}")
    public Car getCarById(@PathVariable int id){
        return carHandler.GetById(id);
    }

    @DeleteMapping(value = "/car-delete")
    public void deleteCar(@RequestBody Car car){
        carHandler.DeleteCar(car);
    }

    @DeleteMapping(value = "/car-delete/{id}")
    public void deleteCarById(@PathVariable int id){
        carHandler.DeleteCarById(id);
    }

    @GetMapping(value = "/car-make/{make}")
    public JSONList getCarByMake(@PathVariable String make){
        JSONList jsonList = new JSONList();

        List cars = carHandler.GetByMake(make);

        for (Object car : cars){
            jsonList.addItem(car);
        }
        return jsonList;
    }

    @PostMapping(value = "/car-update")
    public void updateCar(@RequestBody Car car){
        carHandler.SubmitCar(car);
    }

    @PostMapping(value = "/new-car")
    public void submitNewCar(@RequestBody Car car){
        carHandler.SubmitCar(car);
    }
}


