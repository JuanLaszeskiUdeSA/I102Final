package garage0;

import java.util.Objects;

public class Car {
    private String plateNumber;

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {return plateNumber;}

    public boolean equals(Object object) {
        return this == object ||
                (object != null &&
                object.getClass() == getClass() &&
                plateNumber.equals(((Car) object).plateNumber));
    }

    public int hashCode() {return Objects.hash(plateNumber);}
}