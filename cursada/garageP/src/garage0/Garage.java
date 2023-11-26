package garage0;

import java.util.HashSet;
import java.util.Set;

public class Garage {

    public static String missingCar = "Missing car!";
    public static String noSpaceAvailable = "No space available";
    public static String twinCars = "Twin Cars!";

    public int capacity;
    public Set<Car> cars = new HashSet<>();
    public Set<Car> associatedCars = new HashSet<>();
    private int fees = 0;

    public Garage(int size) {this.capacity = size;}

    public int getNumCars() {
        return cars.size();
    }

    public void parkCar(Car car) {
        if (isFull()) {
            throw new RuntimeException(noSpaceAvailable);
        }

        if (cars.contains(car)) {
            throw new RuntimeException(twinCars);
        }

        fees += getFee(car);
        cars.add(car);
    }

    public void associate(Car car) {
        if (cars.contains(car)) {
            throw new RuntimeException(twinCars);
        }

        associatedCars.add(car);
    }

    public void unparkCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return;
        }
        throw new RuntimeException(missingCar);
    }

    public boolean isEmpty() {return cars.isEmpty();}
    public boolean isFull() {return cars.size() == capacity;}
    public int getFee(Car car) {
        if (associatedCars.contains(car)) {
            return 5;
        }
        else return 10;
    }

    public int totalFees() {return fees;}
}