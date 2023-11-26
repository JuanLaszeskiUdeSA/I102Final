package futbol;

public class Defensor extends jugador{
    void jugar(){
        protestar();
        super.jugar();
        quitarPelota();}

    private void protestar() {
        System.out.println("Protestando");
    }

    private void quitarPelota() {
        System.out.println("Quitando la pelota");
    }

}
