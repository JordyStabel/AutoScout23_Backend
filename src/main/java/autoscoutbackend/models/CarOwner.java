package autoscoutbackend.models;

import javax.persistence.*;
import java.util.Date;

public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carowner_id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "date_created")
    private Date created;

    @OneToOne
    private Car car;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    public CarOwner(){

    }

    public CarOwner(String userName, Date created) {
        this.userName = userName;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", created=" + created +
                ", car=" + car +
                '}';
    }
}
