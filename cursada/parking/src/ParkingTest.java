import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingTest {

    private Parking parking;
    @BeforeEach
    public void setUp() {
        parking = new Parking();
    }

    @Test
    public void testEmptyParking(){
        assertEquals(0, parking.getPeople());
    }

    @Test
    public void testParkingWithOnePerson(){
        parking.addCar(new RegularCar(1));
        assertEquals(1, parking.getPeople());
    }

    @Test
    public void testCannotCreateCarWithLessThanOnePassenger(){
        assertThrowsLike( () -> new RegularCar(0), Car.ACarCannotHaveLessThanOnePassenger);
    }

    @Test
    public void testParkingWithTwoPeopleInTheSameCar(){
        parking.addCar(new RegularCar(2));
        assertEquals(2, parking.getPeople());
    }

    @Test
    public void testParkingWithTwoPeopleInDifferentCarsAndDoesNotExistTwinCars(){
        parking.addCar(new RegularCar(1)).addCar(new RegularCar(1));
        assertEquals(2, parking.getPeople());
    }

    @Test
    public void testParkAndRemoveCar(){
        Car car = new RegularCar(1);
        parking.addCar(car).removeCar(car);
        assertEquals(0, parking.getPeople());
    }

    @Test
    public void testRemoveCarNotInParking(){
        assertThrowsLike( () -> parking.removeCar(new RegularCar(1)), "Missing car");
    }

    @Test
    public void testMoneyReceivableInEmptyParking(){
        assertEquals(0, parking.getMoneyReceivable());
    }

    @Test
    public void testMoneyReceivableWithOneRegularPerson(){
        parking.addCar(new RegularCar(1));
        assertEquals(110, parking.getMoneyReceivable());
    }

    @Test
    public void testMoneyReceivableWithTwoRegularPeopleInSeparatedCars(){
        parking.addCar(new RegularCar(1)).addCar(new RegularCar(1));
        assertEquals(220, parking.getMoneyReceivable());
    }

    @Test
    public void testMoneyReceivableWithTwoRegularPeopleInTheSameCar(){
        parking.addCar(new RegularCar(2));
        assertEquals(170, parking.getMoneyReceivable());
    }

    @Test
    public void testMoneyReceivableWithOneFamiliarPerson(){
        parking.addCar(new FamiliarCar(1));
        assertEquals(150, parking.getMoneyReceivable());
    }

    @Test
    public void testMoneyReceivableWithTwoFamiliarPeopleInSeparatedCars(){
        parking.addCar(new FamiliarCar(1)).addCar(new FamiliarCar(1));
        assertEquals(300, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableWithTwoFamiliarPeopleInTheSameCar(){
        parking.addCar(new FamiliarCar(2));
        assertEquals(150, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableWithOneAssociatedPerson(){
        parking.addCar(new AssociatedCar(1));
        assertEquals(100, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableWithTwoAssociatedPeopleInSeparatedCars(){
        parking.addCar(new AssociatedCar(1)).addCar(new AssociatedCar(1));
        assertEquals(200, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableWithTwoAssociatedPeopleInTheSameCar(){
        parking.addCar(new AssociatedCar(2));
        assertEquals(100, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableInAComplexParking(){
        parking.addCar(new RegularCar(1)).addCar(new FamiliarCar(1)).addCar(new AssociatedCar(1));
        assertEquals(360, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableInAnotherComplexParking(){
        parking.addCar(new RegularCar(3)).addCar(new FamiliarCar(4)).addCar(new AssociatedCar(1))
                .addCar(new RegularCar(2)).addCar(new FamiliarCar(1)).addCar(new AssociatedCar(10));
        assertEquals(900, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableAfterRemovingARegularCar(){
        Car car = new RegularCar(1);
        parking.addCar(car).removeCar(car);
        assertEquals(0, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableAfterRemovingAFamiliarCar(){
        Car car = new FamiliarCar(1);
        parking.addCar(car).removeCar(car);
        assertEquals(0, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableAfterRemovingAnAssociatedCar(){
        Car car = new AssociatedCar(1);
        parking.addCar(car).removeCar(car);
        assertEquals(0, parking.getMoneyReceivable());
    }

    @Test void testMoneyReceivableAfterRemovingOneCarInAComplexParking(){
        Car car1 = new RegularCar(3);
        Car car2 = new FamiliarCar(2);
        Car car3 = new AssociatedCar(5);
        parking.addCar(car1).addCar(car2).addCar(car3).removeCar(car1);
        assertEquals(250, parking.getMoneyReceivable());
    }

    private void assertThrowsLike( Executable executable, String message ) {
        assertEquals( message,
                assertThrows( Exception.class, executable ).getMessage() );
    }
}