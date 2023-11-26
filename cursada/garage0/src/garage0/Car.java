package garage0;

import java.util.Objects;

public class Car {
  private String plateNumber;
  
  public Car(String plateNumber ) {
      this.plateNumber = plateNumber;
  }
  
  public String getPlateNumber() {
      return plateNumber;
  }
    public boolean equals(Object obj) {
        return this == obj ||
                (obj != null && getClass() == obj.getClass() && plateNumber.equals(((Car)obj).plateNumber));
    }

    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}