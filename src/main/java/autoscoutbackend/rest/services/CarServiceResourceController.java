package autoscoutbackend.rest.services;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.Inventory;
import autoscoutbackend.rest.handler.CarHandler;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CarServiceResourceController {

    private CarHandler carHandler = new CarHandler();

    @RequestMapping("/get-all-cars")
    @CrossOrigin(origins = "http://localhost:3000")
    public Inventory getAllCars() {
        Inventory inventory = new Inventory();

        List cars = carHandler.GetAllCars();

        for (Object car : cars){
            inventory.addCar((Car) car);
        }
        return inventory;
    }

    @RequestMapping(value = "/get-time")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getTimeMessage(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @GetMapping(value = "/car/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Car getCarById(@PathVariable int id){
        return carHandler.GetById(id);
    }

    @PostMapping(value = "/new-car")
    @CrossOrigin(origins = "http://localhost:3000")
    public void submitNewCar(@RequestBody Car car){
        carHandler.SubmitCar(car);
    }
}


