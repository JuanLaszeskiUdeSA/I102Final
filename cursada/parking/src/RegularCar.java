public class RegularCar extends Car {
    public RegularCar(int passengers) {
        super(passengers);
    }
    @Override
    public int amountToPay() {
        return 50 + 60 * getPassengers();
    }
}
