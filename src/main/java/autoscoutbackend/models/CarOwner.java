package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "CarOwner")
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carowner_id")
    private int id;

    @NotNull
    private String userName;

    @NotNull
    private Date dateCreated;

    @OneToOne
    @JoinTable(name = "CarOwner_Car")
    private Car car;

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
    }

    public CarOwner(){

    }

    public CarOwner(String userName) {
        this.userName = userName;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date created) {
        this.dateCreated = created;
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
                ", created=" + dateCreated +
                ", car=" + car +
                '}';
    }
}
