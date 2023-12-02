package garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {

    @BeforeEach public void setUp() {
        garage = new Garage();
    }

    @Test public void testNewGarageIsEmpty() {
        assertEquals( new Garage().getNumberOfPeople(), 0 );
    }

    @Test public void testNewGarageHasNoOutFees() {
        assertEquals( new Garage().getOutFees(), 0 );
    }

    @Test public void testParkOneMemberCar() {
        garage.parkMemberCar( new Car( 3 , "AAA000") );
        assertPeopleAndFees( 3, 100);
    }

    @Test public void testParkTwoMemberCars() {
        garage.parkMemberCar( new Car( 3 , "AAA000") );
        garage.parkMemberCar( new Car( 4 , "BBB111") );
        assertPeopleAndFees( 7, 200);
    }

    @Test public void testParkOneFamiliarCar() {
        garage.parkFamiliarCar( new Car( 3 , "AAA000") );
        assertPeopleAndFees( 3, 150);
    }

    @Test public void testParkTwoFamiliarCars() {
        garage.parkFamiliarCar( new Car( 3 , "AAA000") );
        garage.parkFamiliarCar( new Car( 4 , "BBB111") );
        assertPeopleAndFees( 7, 300);
    }

    @Test public void testParkOneVisitorCar() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        assertPeopleAndFees( 3, 230);
    }

    @Test public void testParkTwoVisitorCars() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        garage.parkVisitorCar( new Car( 4 , "BBB111") );
        assertPeopleAndFees( 7, 520);
    }

    @Test public void testParkVisitorFamiliarAndMemberCar() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        garage.parkFamiliarCar( new Car( 4 , "BBB111") );
        garage.parkMemberCar( new Car( 5 , "CCC222") );
        assertPeopleAndFees( 12, 480);
    }

    @Test public void testParkACarWithTheSamePlateThrowsError() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        assertThrowsLike(() -> garage.parkVisitorCar( new Car( 5 , "AAA000") ),
                Garage.YaHayUnAutoEstacionadoConLaMismaPatente );
    }

    @Test public void testUnParkACarThatIsNotParkedThrowsError() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        assertThrowsLike(() -> garage.unpark( new Car( 5 , "BBB111") ),
                Garage.NoHayUnAutoEstacionadoConEsaPatente );
        assertPeopleAndFees( 3, 230);
    }

    @Test public void testUnParkACarOnlyLookInThePlate() {
        garage.parkVisitorCar( new Car( 3 , "AAA000") );
        garage.unpark( new Car( 3 , "AAA000") );
        assertPeopleAndFees( 0, 0);
    }

    @Test public void testComplexGarageSituationWithParkAndUnPark(){
        garage.parkMemberCar( new Car( 3 , "AAA000") );
        garage.parkFamiliarCar( new Car( 4 , "BBB111") );
        garage.parkVisitorCar( new Car( 5 , "CCC222") );
        garage.parkMemberCar( new Car( 3 , "DDD333") );
        garage.parkFamiliarCar( new Car( 4 , "EEE444") );
        garage.parkVisitorCar( new Car( 5 , "FFF555") );
        garage.unpark( new Car( 3 , "AAA000") );
        garage.unpark( new Car( 4 , "BBB111") );
        garage.unpark( new Car( 5 , "CCC222") );
        assertPeopleAndFees( 12, 600);

    }


    private void assertPeopleAndFees(int people, int fees) {
        assertEquals( people, garage.getNumberOfPeople() );
        assertEquals( fees, garage.getOutFees() );
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private Garage garage;
}
