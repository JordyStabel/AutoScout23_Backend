package autoscoutbackend.rest.services;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.Inventory;
import autoscoutbackend.models.Make;
import autoscoutbackend.rest.handler.MakeHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MakeServiceResourceController {

    private MakeHandler makeHandler = new MakeHandler();

    @RequestMapping("/get-all-makes")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Make> getAllMakes() {
        return makeHandler.GetAllMakes();
    }
}
