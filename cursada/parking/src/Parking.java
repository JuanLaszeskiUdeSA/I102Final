import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parking {
    public static final String MissingCar = "Missing car";
    private ArrayList<Car> cars;
    public Parking() {
        cars = new ArrayList<>();
    }
    public Parking addCar(Car car) {
        cars.add(car);
        return this;
    }
    public Parking removeCar(Car car) {
        if (!cars.contains(car)) {
            throw new RuntimeException(MissingCar);
        }
        cars.remove(car);
        return this;
    }

    public int getPeople() {
        return cars.stream().mapToInt(Car::getPassengers).sum();
    }

    public int getMoneyReceivable() {
        return cars.stream().mapToInt(Car::amountToPay).sum();
    }
}
