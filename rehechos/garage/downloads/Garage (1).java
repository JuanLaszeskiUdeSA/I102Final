package downloads;

import java.util.ArrayList;
import java.util.List;

public class Garage {
  private List<ParkedCar> cars = new ArrayList();

  public void parkMemberCar( Car car ) {
    cars.add( new MemberCar( car ) );
  }

  public void parkInvitedCar( Car car ) {
    cars.add( new InvitedCar( car ) );
  }

  public void parkVisitorCar( Car car ) {
    cars.add( new VisitorCar( car ) );
  }

  public int futureFees() {
    return cars.stream().reduce( 0, (total, car) -> total + car.fee(), Integer::sum ); 
  }

  public Integer guests() {
    return cars.stream().reduce( 0, (total, car) -> total + car.passengers(), Integer::sum );
  }

  public void unpark( Car earlyCar ) {
    cars.removeAll( cars.stream().filter( (parked) -> parked.holds( earlyCar ) ).toList() );    
  }

}