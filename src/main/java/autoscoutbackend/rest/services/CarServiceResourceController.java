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


