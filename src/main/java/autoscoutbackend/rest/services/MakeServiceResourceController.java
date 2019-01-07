package autoscoutbackend.rest.services;

import autoscoutbackend.models.JSONList;
import autoscoutbackend.models.Make;
import autoscoutbackend.rest.handler.MakeHandler;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "https://autoscout23.herokuapp.com")
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

    @RequestMapping(value = "/get-time-test")
    public String getTimeMessage(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date + " This is a test...");
    }
}
