package garage;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    public static String YaHayUnAutoEstacionadoConLaMismaPatente = "Ya hay un auto estacionado con la misma patente";
    public static String UnAutoAlMenosTieneUnPasajero = "Un auto al menos tiene un pasajero";
    public static String NoHayUnAutoEstacionadoConEsaPatente = "No hay un auto estacionado con esa patente";

    private List<ParkedCar> cars;

    public Garage () {
        cars = new ArrayList<>();
    }

    public Garage parkMemberCar( Car car ) {
        return park(new MemberCar(car));
    }
    public Garage parkFamiliarCar( Car car ) {
        return park(new FamiliarCar(car));
    }
    public Garage parkVisitorCar( Car car ) {
        return park(new VisitorCar(car));
    }

    private Garage park( ParkedCar car ) {
        if ( cars.contains(car) ) {
            throw new RuntimeException(YaHayUnAutoEstacionadoConLaMismaPatente);
        }
        cars.add( car );
        return this;
    }

    public Garage unpark( Car car ) {
        if ( !cars.removeIf( (parked) -> parked.holds( car ) ) ) {
            throw new RuntimeException(NoHayUnAutoEstacionadoConEsaPatente);
        }
        return this;
    }

    public int getNumberOfPeople() {
        return cars.stream().mapToInt(ParkedCar::getPassengers).sum();
    }

    public int getOutFees() {
        return cars.stream().mapToInt(ParkedCar::getFee).sum();
    }
}
