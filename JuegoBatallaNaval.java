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
        //Jugador 1
        System.out.println(jugador1.getNombre() + " ingrese la posición de sus barcos");
        int barcosColocadosJ1 = 0;
        while (barcosColocadosJ1 < 3) {
            System.out.println("Barco #" + (barcosColocadosJ1 + 1));
            System.out.print("Digite la Fila: ");
            int fila = entrada.nextInt();
            System.out.print("Digite la Columna: ");
            int columna = entrada.nextInt();

            boolean exito = jugador1.moverBarco(columna, fila);

            if (exito) {
                barcosColocadosJ1++;
                jugador1.getTableroPropio().mostrarTablero();
            } else {
            System.out.println("Posición inválida o ya ocupada. Intente de nuevo.");
        }
    }
    
        //Jugador 2
        System.out.println(jugador2.getNombre() + " ingrese la posición de sus barcos");
        int barcosColocadosJ2 = 0;
        while (barcosColocadosJ2 < 3) {
            System.out.println("Barco #" + (barcosColocadosJ2 + 1));
            System.out.print("Digite la Fila: ");
            int fila = entrada.nextInt();
            System.out.print("Digite la Columna: ");
            int columna = entrada.nextInt();

            boolean exito = jugador2.moverBarco(columna, fila);

            if (exito) {
                barcosColocadosJ2++;
                jugador2.getTableroPropio().mostrarTablero();
            } else {
            System.out.println("Posición inválida o ya ocupada. Intente de nuevo.");
            }
        }
    }

    //Juego
    public static void juegoBatallaNaval(){
        System.out.println("Empieza " + jugador1.getNombre());
        while(!jugador1.getTableroPropio().derrota() && !jugador2.getTableroPropio().derrota()){
            // Turno del Jugador 1
            System.out.println(jugador1.getNombre() + ", ingrese las coordenadas para atacar:");
            int colAtaque1 = entrada.nextInt();
            int filaAtaque1 = entrada.nextInt();
            jugador2.ataque(colAtaque1, filaAtaque1);

            if (jugador2.getTableroPropio().derrota()) {
                System.out.println(jugador2.getNombre() + " ha perdido todos sus barcos. ¡" + jugador1.getNombre() + " gana!");
                break;
            }

            // Turno del Jugador 2
            System.out.println(jugador2.getNombre() + ", ingrese las coordenadas para atacar:");
            int colAtaque2 = entrada.nextInt();
            int filaAtaque2 = entrada.nextInt();
            jugador1.ataque(colAtaque2, filaAtaque2);

            if (jugador1.getTableroPropio().derrota()) {
                System.out.println(jugador1.getNombre() + " ha perdido todos sus barcos. ¡" + jugador2.getNombre() + " gana!");
                break;
            }
        }
    }
}
