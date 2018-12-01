package autoscoutbackend.dal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Make sure it auto increments the 'id'
    @Column(name = "id")
    private int id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "price")
    private int price;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    @Column(name = "date_added")
    private Date created;

    @Column(name = "date_updated")
    private Date updated;

    public Car(){

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
