package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    private int mileage;

    @NotNull
    private int price;

    @NotNull
    private String image;

    @PrePersist
    protected void onCreate() {
        date_created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        date_updated = new Date();
    }

    @NotNull
    private Date date_created;

    private Date date_updated;

    public Car(){

    }

    public Car(String make, String model, int mileage, int price, String image) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.image = image;
    }

    public Car(String make, String model, int mileage, int price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date created) {
        this.date_created = created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", created=" + date_created +
                ", updated=" + date_updated +
                '}';
    }

    public void setDate_updated(Date updated) {
        this.date_updated = updated;
    }
}
