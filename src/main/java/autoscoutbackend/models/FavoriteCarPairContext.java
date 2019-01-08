package autoscoutbackend.models;

public class FavoriteCarPairContext {

    private CarOwner carOwner;

    private int carId;

    public FavoriteCarPairContext(CarOwner carOwner, int carId) {
        this.carOwner = carOwner;
        this.carId = carId;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "FavoriteCarPairContext{" +
                "carOwner=" + carOwner +
                ", carId=" + carId +
                '}';
    }
}
