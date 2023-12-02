package garage;

public abstract class ParkedCar {
    private Car car;

    public ParkedCar(Car car ) {
        this.car = car;
    }
    public abstract int getFee();

    @Override
    public boolean equals(Object object) {
        return object instanceof ParkedCar && car.equals(((ParkedCar) object).car);
    }

    public Car getCar() {
        return car;
    }

    public int getPassengers() {
        return car.getPassengers();
    }

    public boolean holds(Car car) {
        return this.car.equals(car);
    }
}
