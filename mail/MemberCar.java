package garageEventos1;

public class MemberCar extends ParkedCar {
  public static int MemberFee = 100;
  
  public MemberCar( Car car ) {
    super( car );
  }

  public int fee() {
    return MemberFee;
  }

}