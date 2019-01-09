package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "Car")
public class Car {

    @ManyToOne
    @JoinTable(name = "Car_Make") // @JoinColumn to add a column to the Car table with the correct Make_Id instead of crating an extra table
    private Make carMake;

    @ManyToOne
    @JoinTable(name = "Car_CarOwner")
    private CarOwner carOwner;

//    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//    private List<CarOwner> carOwners = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER) //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CarOwner_FavoriteCar",
            joinColumns = @JoinColumn(name = "carID"),
            inverseJoinColumns = @JoinColumn(name = "carowner_id"))
    private Set<CarOwner> carOwners = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carID;

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    private int mileage;

    @NotNull
    private String description;

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

    public Car(String make, String model, String description, int mileage, int price, String image) {
        this.make = make;
        this.model = model;
        this.description = description;
        this.mileage = mileage;
        this.price = price;
        this.image = image;
    }

    public Car(String make, String model, String description, int mileage, int price) {
        this.make = make;
        this.model = model;
        this.description = description;
        this.mileage = mileage;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int id) {
        this.carID = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Make getCarMake() {
        return carMake;
    }

    public void setCarMake(Make carMake) {
        this.carMake = carMake;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public Set<CarOwner> getCarOwners() {
        return carOwners;
    }

    public void setCarOwners(Set<CarOwner> carOwners) {
        this.carOwners = carOwners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMake=" + carMake +
                ", carOwner=" + carOwner +
                ", carOwners=" + carOwners +
                ", carID=" + carID +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", date_created=" + date_created +
                ", date_updated=" + date_updated +
                '}';
    }

    public void setDate_updated(Date updated) {
        this.date_updated = updated;
    }
}
