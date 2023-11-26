package futbol;

public class Delantero extends jugador{
    void jugar(){
        super.jugar();
        patearAlArco();
    }

    void patearAlArco(){
        System.out.println("Pateando al arco");
    }

}
