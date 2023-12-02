package garage;

public class VisitorCar extends ParkedCar {

    public VisitorCar(Car car) {
        super(car);
    }

    @Override
    public int getFee() {
        return getPassengers() * 60 + 50;
    }
}
