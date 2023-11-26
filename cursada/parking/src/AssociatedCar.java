public class AssociatedCar extends Car {
    public AssociatedCar(int passengers) {super(passengers);}
    @Override
    public int amountToPay() {
        return 100;
    }
}
