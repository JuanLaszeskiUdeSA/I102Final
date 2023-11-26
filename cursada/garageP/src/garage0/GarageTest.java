package garage0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class GarageTest {

    @Test public void testNewParkingIsEmpty() {
        assertTrue(new Garage(3).isEmpty());
    }

    @Test public void testNewParkingHasNoMoney() {
        assertEquals(0, new Garage(3).totalFees());
    }

    @Test public void testParkOneCar() {
        assertFalse(garageWithJuansCar(3).isEmpty());
    }

    @Test public void testOneCarFee() {
        assertEquals(10, garageWithJuansCar(3).totalFees());
    }

    @Test public void testManyCarsFees() {
        Garage garage = garageWithJuansCar(3);
        garage.parkCar(diegosCar());

        assertEquals(20, garage.totalFees());
    }

    @Test public void testInOutOneCar() {
        Garage garage = garageWithJuansCar(3);

        assertFalse(garage.isEmpty());
        garage.unparkCar(juansCar());

        assertTrue(garage.isEmpty());
    }

    @Test public void testInOutOneCarFees() {
        Garage garage = garageWithJuansCar(3);

        assertFalse(garage.isEmpty());
        garage.unparkCar(juansCar());

        assertEquals(10, garage.totalFees());
    }

    @Test public void testUnparkAnEmptyLot() {
        assertThrowsLike(() -> new Garage(3).unparkCar(juansCar()), Garage.missingCar);
    }

    @Test public void testFullLot() {assertTrue(garageWithJuansCar(1).isFull());}

    @Test public void testOverFillLot() {
        Garage garage = garageWithJuansCar(1);

        assertThrowsLike(() -> garage.parkCar(diegosCar()), Garage.noSpaceAvailable);

        assertEquals(1, garage.getNumCars());
    }

    @Test public void testRotateLot() {
        Garage garage = garageWithJuansCar(1);
        garage.unparkCar(juansCar());
        garage.parkCar(juansCar());

        assertEquals(1, garage.getNumCars());
        assertEquals(20, garage.totalFees());
    }

    @Test public void testParkOneCarTwice() {
        Garage garage = garageWithJuansCar(3);

        assertThrowsLike(() -> garage.parkCar(juansCar()), Garage.twinCars);
        assertEquals(1, garage.getNumCars());
    }

    @Test public void testManyCarsFeesOnMembers() {
        Garage garage = new Garage( 3 );
        garage.associate( juansCar() );
        garage.parkCar( juansCar() );
        garage.parkCar( diegosCar() );

        assertEquals( 15, garage.totalFees() );
    }
    @Test public void testOneMemberCarFee() {
        Garage garage = new Garage( 3 );
        garage.associate( juansCar() );
        garage.parkCar( juansCar() );
        assertEquals( 5, garage.totalFees() );
    }

    private Car juansCar() {
        return new Car("ABC123");
    }

    private Car diegosCar() {
        return new Car("DEF456");
    }

    private Garage garageWithJuansCar(int size) {
        Garage garage = new Garage(size);
        Car car = juansCar();
        garage.parkCar(car);
        return garage;
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
}
