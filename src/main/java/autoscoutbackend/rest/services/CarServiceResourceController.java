package autoscoutbackend.rest.services;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.JSONList;
import autoscoutbackend.rest.handler.CarHandler;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CarServiceResourceController {

    private CarHandler carHandler = new CarHandler();

    @RequestMapping("/get-all-cars")
    @CrossOrigin(origins = "http://localhost:3000")
    public JSONList getAllCars() {
        JSONList JSONList = new JSONList();

        List cars = carHandler.GetAllCars();

        for (Object car : cars){
            JSONList.addItem(car);
        }
        return JSONList;
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

    @GetMapping(value = "/bugatti")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Car> getAllBugatti(){
        return carHandler.GetBugatti();
    }

    @GetMapping(value = "/porsche")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Car> getAllPorsche(){
        return carHandler.GetPorsche();
    }
}


