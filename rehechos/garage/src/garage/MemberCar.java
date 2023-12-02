package garage;

public class MemberCar extends ParkedCar {

    public MemberCar(Car car) {
        super(car);
    }

    @Override
    public int getFee() {
        return 100;
    }
}
