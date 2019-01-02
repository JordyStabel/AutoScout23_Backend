package autoscoutbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Make")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private int makeID;

    @NotNull
    private String make;

    public Make() {

    }

    public Make(String make) {
        this.make = make;
    }

    public int getMakeID() {
        return makeID;
    }

    public void setMakeID(int id) {
        this.makeID = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Make{" +
                "id=" + makeID +
                ", make='" + make + '\'' +
                '}';
    }
}
