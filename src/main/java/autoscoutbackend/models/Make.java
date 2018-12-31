package autoscoutbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "Make")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Make sure it auto increments the 'id'
    @Column(name = "id")
    private int id;

    @Column(name = "make")
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

    @Override
    public String toString() {
        return "Make{" +
                "id=" + id +
                ", make='" + make + '\'' +
                '}';
    }
}
