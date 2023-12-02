package downloads;

public abstract class ParkedCar {
  protected Car car;
  
  public ParkedCar( Car car ) {
    this.car = car;
  }
  
  public abstract int fee();
  
  public int passengers() {
    return car.passengers();
  }

  public boolean holds( Car earlyCar ) {
    return car == earlyCar;
  }
}