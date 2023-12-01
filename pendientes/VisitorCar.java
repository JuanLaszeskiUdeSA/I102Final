package garageEventos1;

public class VisitorCar extends ParkedCar {
  public static int VisitorFee = 160;
  public static int VisitorCarFee = 80;

  public VisitorCar( Car car ) {
    super( car );
  }

  public int fee() {
    return car.passengers() * VisitorFee + VisitorCarFee;
  }

}