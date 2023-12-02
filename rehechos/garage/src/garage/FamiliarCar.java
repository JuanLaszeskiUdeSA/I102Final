package garage;

public class FamiliarCar extends ParkedCar {

    public FamiliarCar(Car car) {
        super(car);
    }

    @Override
    public int getFee() {
        return 150;
    }
}
