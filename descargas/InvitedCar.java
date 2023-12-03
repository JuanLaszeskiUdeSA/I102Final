package garageEventos1;

public class InvitedCar extends ParkedCar {
  public static int InvitedFee = 150;

  public InvitedCar( Car car ) {
    super( car );
  }


  public int fee() {
    return InvitedFee;
  }

}