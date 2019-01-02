package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
