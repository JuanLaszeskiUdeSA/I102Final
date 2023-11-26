public class FamiliarCar extends Car {
    public FamiliarCar(int passengers) {
        super(passengers);
    }
    @Override
    public int amountToPay() {
        return 150;
    }
}
