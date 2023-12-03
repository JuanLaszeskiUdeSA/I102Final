package garageEventos1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GarageTest {

  @Test public void testNewParkingHasNoMoney() {
    assertEquals( 0, new Garage().futureFees() );
  }

  @Test public void testParkOneMemberCar() {
    Garage garage = new Garage();
    garage.parkMemberCar( new Car( 3 ) );
    assertEquals( 3, garage.guests() );

    assertEquals( MemberCar.MemberFee, garage.futureFees() );
  }

  @Test public void testParkTwoMemberCars() {
    Garage garage = new Garage();
    garage.parkMemberCar( new Car( 3 ) );
    garage.parkMemberCar( new Car( 4 ) );

    assertEquals( 7, garage.guests() );
    
    assertEquals( 2 * MemberCar.MemberFee, garage.futureFees() );
  }
  
  @Test public void testParkTwoMemberCarsAndThenOneLeave() {
    Garage garage = new Garage();
    Car earlyCar = new Car( 3 ) ;
    garage.parkMemberCar( earlyCar );
    garage.parkMemberCar( new Car( 4 ) );

    garage.unpark( earlyCar );
    
    assertEquals( 4, garage.guests() );
    
    assertEquals( MemberCar.MemberFee, garage.futureFees() );
  }

  @Test public void testParkOneInvitedCars() {
    Garage garage = new Garage();
    garage.parkInvitedCar( new Car( 3 ) );

    assertEquals( InvitedCar.InvitedFee, garage.futureFees() );
  }

  @Test public void testParkTwoInvitedCars() {
    Garage garage = new Garage();
    garage.parkInvitedCar( new Car( 3 ) );
    garage.parkInvitedCar( new Car( 4 ) );

    assertEquals( 2 * InvitedCar.InvitedFee, garage.futureFees() );
  }

  @Test public void testParkOneVisitorCars() {
    Garage garage = new Garage();
    garage.parkVisitorCar( new Car( 3 ) );

    assertEquals( VisitorCar.VisitorCarFee + 3 * VisitorCar.VisitorFee, garage.futureFees() );
  }

  @Test public void testParkTwoVisitorCars() {
    Garage garage = new Garage();
    garage.parkVisitorCar( new Car( 3 ) );
    garage.parkVisitorCar( new Car( 4 ) );

    assertEquals( 2 * VisitorCar.VisitorCarFee + 
                  7 * VisitorCar.VisitorFee, garage.futureFees() );
  }

  
}