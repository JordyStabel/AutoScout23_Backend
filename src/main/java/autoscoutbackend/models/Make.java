package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Make")
public class Make {
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<Car> carEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String make;

    public Make(){

    }

    public Make(String make) {
        this.make = make;
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

    public List<Car> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<Car> carEntities) {
        this.carEntities = carEntities;
    }

    @Override
    public String toString() {
        return "Make{" +
                "id=" + id +
                ", make='" + make + '\'' +
                '}';
    }
}
