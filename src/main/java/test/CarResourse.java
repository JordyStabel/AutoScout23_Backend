package test;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class CarResourse {
    private String model;

    public CarResourse() {
        this.model = "This is a test.";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public void addProduct(Product product) {
//        this.products.add(product);
//    }
//
//    public void removeProduct(Product product) {
//        this.products.remove(product);
////    }
//
//
//    public void addAllergy(String productId, String allergy) {
//        for (Product product :
//                this.products) {
//            if (product.getProductId().equals(productId)) {
//                product.addAllergyId(allergy);
//                return;
//            }
//        }
//    }
}
