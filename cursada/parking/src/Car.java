public abstract class Car {
    public static final String ACarCannotHaveLessThanOnePassenger = "A car must have at least one passenger";
    private int passengers;
    public Car(int passengers) {
        if (passengers < 1) {
            throw new RuntimeException(ACarCannotHaveLessThanOnePassenger);
        }
        this.passengers = passengers;
    }
    public int getPassengers() {
        return passengers;
    }
    public abstract int amountToPay();
}
