package garage;

public class Car {
    private int passengers;
    private String plate;

    public Car( int passengers, String plate ) {
        if ( passengers <= 0 ) throw new RuntimeException( Garage.UnAutoAlMenosTieneUnPasajero );
        this.passengers = passengers;
        this.plate = plate;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car && getPlate()
                .equals(((Car) object).getPlate());
    }
}
