package autoscoutbackend.rest.services;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.CarOwner;
import autoscoutbackend.models.FavoriteCarPairContext;
import autoscoutbackend.models.JSONList;
import autoscoutbackend.rest.handler.CarOwnerHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CarOwnerServiceResourceController {

    private CarOwnerHandler carOwnerHandler = new CarOwnerHandler();

    @RequestMapping("/get-all-carowners")
    public JSONList getAllCarOwners() {
        JSONList jsonList = new JSONList();

        List owners = carOwnerHandler.GetAllUsers();

        for (Object carOwner : owners){
            jsonList.addItem(carOwner);
        }
        return jsonList;
    }

    @GetMapping(value = "/carowner-id/{id}")
    public CarOwner getCarOwnerById(@PathVariable int id){
        return carOwnerHandler.GetById(id);
    }

    @DeleteMapping(value = "/carowner-delete/{id}")
    public void deleteCarOwnerById(@PathVariable int id){
        carOwnerHandler.RemoveCarOwnerById(id);
    }

    @PostMapping(value = "/new-carowner")
    public void submitNewCar(@RequestBody CarOwner carOwner){
        carOwnerHandler.AddCarOwner(carOwner);
    }

    @PostMapping(value = "/add-to-favorite/{id}")
    public void addToFavorite(@RequestBody CarOwner carOwner, @PathVariable int id){
        carOwnerHandler.AddFavoriteCar(carOwner, id);
    }
}
