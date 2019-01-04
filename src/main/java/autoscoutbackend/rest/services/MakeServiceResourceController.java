package autoscoutbackend.rest.services;

import autoscoutbackend.models.JSONList;
import autoscoutbackend.models.Make;
import autoscoutbackend.rest.handler.MakeHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class MakeServiceResourceController {

    private MakeHandler makeHandler = new MakeHandler();

    @RequestMapping("/get-all-makes")
    @CrossOrigin(origins = "http://localhost:3000")
    public JSONList getAllMakes() {

        JSONList JSONList = new JSONList();

        List makes = makeHandler.GetAllMakes();

        for (Object make : makes) {
            JSONList.addItem(make);
        }
        return JSONList;
    }

    @PostMapping(value = "/new-make")
    @CrossOrigin(origins = "http://localhost:3000")
    public void submitNewCar(@RequestBody Make make) {
        makeHandler.AddMake(make);
    }
}
