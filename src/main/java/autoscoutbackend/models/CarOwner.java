package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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

//    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//    private List<Car> favoriteCars;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    @JoinTable(name = "CarOwner_FavoriteCar",
//            joinColumns = @JoinColumn(name = "carowner_id"),
//            inverseJoinColumns = @JoinColumn(name = "carID"))
//    private Set<Car> favoriteCars = new HashSet<>();

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

//    public List<Car> getFavoriteCars() {
//        return favoriteCars;
//    }
//
//    public void setFavoriteCars(List<Car> favoriteCars) {
//        this.favoriteCars = favoriteCars;
//    }

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

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", dateCreated=" + dateCreated +
                //", favoriteCars=" + favoriteCars +
                '}';
    }
}
