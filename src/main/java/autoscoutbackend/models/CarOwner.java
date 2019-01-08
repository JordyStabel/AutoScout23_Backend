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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CarOwner_FavoriteCar",
            joinColumns = { @JoinColumn(name = "carowner_id") },
            inverseJoinColumns = { @JoinColumn(name = "carID") })
    private Set<Car> favoriteCars = new LinkedHashSet<>();

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

    public Set<Car> getFavoriteCars() {
        return favoriteCars;
    }

    public void setFavoriteCars(Set<Car> favoriteCars) {
        this.favoriteCars = favoriteCars;
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

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", dateCreated=" + dateCreated +
                ", favoriteCars=" + favoriteCars +
                '}';
    }
}
