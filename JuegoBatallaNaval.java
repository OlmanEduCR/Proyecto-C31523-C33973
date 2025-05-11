import java.util.Scanner;

public class JuegoBatallaNaval{
    private static Jugador jugador1 = new Jugador("X", new Tablero(), 3);
    private static Jugador jugador2 = new Jugador("X", new Tablero(), 3);

    static Scanner entrada = new Scanner(System.in);

    //Método de inicio
    public static void nombreDeLosJugadores(){
        System.out.println("Bienvenido a Batalla Naval, por favor digite el nombre de los participantes");
        System.out.println("Jugador 1:");
        jugador1.setNombre(entrada.nextLine());
        System.out.println("Jugador 2:");
        jugador2.setNombre(entrada.nextLine());
    }

    //Prejuego
    public static void fasePrevia(){
        System.out.println(jugador1.getNombre() + " ingrese la posición de sus barcos");
        jugador1.moverBarco(entrada.nextInt(),entrada.nextInt());
        if(entrada.nextInt()>jugador1.getTableroPropio().getTableroDelJugador().length){
            System.out.println("Digite coordenadas dentro del espacio (5x5)");
        }
        jugador1.getTableroPropio().mostrarTablero();
        System.out.println(jugador2.getNombre() + " ingrese la posición de sus barcos");
        jugador2.moverBarco(entrada.nextInt(),entrada.nextInt());
        if(entrada.nextInt()>jugador1.getTableroPropio().getTableroDelJugador().length){
            System.out.println("Digite coordenadas dentro del espacio (5x5)");
        }
        jugador2.getTableroPropio().mostrarTablero();
    }

    //Juego
    public static void juegoBatallaNaval(){
        System.out.println("Empieza " + jugador1.getNombre());
        do{
            jugador2.ataque(entrada.nextInt(), entrada.nextInt());
            System.out.println("Siguinte turno de " + jugador2.getNombre());
            jugador1.ataque(entrada.nextInt(), entrada.nextInt());
            System.out.println("Siguinte turno de " + jugador1.getNombre());
        } while(jugador1.getTableroPropio().derrota() == true || jugador2.getTableroPropio().derrota() == true);
    }

    //Ganador
    public static void ganador(){
        if(jugador1.getTableroPropio().derrota() != true){
            System.out.println("¡El ganador es " + jugador1.getNombre());
        } else {
            System.out.println("¡El ganador es " + jugador2.getNombre());
        }
    }
}
