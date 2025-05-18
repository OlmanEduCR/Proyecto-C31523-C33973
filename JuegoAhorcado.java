import java.util.Scanner;

public class JuegoAhorcado {
    private static Scanner scanner = new Scanner(System.in);
    /*
     * dibuja el muneco del ahorcado mediante los intentos que se van fallando 
     * parametro intentosFallados es el que indica o guarda la cantidad de intentos que van quedando
     * return el dubujo del ahorcado segun el los intentos y este dibujo cambiendo segun como disminuye los intentos
     */
    // metodo Dibujo ahorcado 
    public static String dibujarMuneco(int intentosFallados) {
        switch (intentosFallados) {
            case 0:
                return  "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "_______\n";
            case 1:
                return  "  _____\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "______|\n";
            case 2:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "       |\n" +
                        "       |\n" +
                        "       |\n" +
                        "_______|\n";
            case 3:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|   |\n" +
                        "       |\n" +
                        "       |\n" +
                        "_______|\n";
            case 4:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|\\ |\n" +  
                        "       |\n" +
                        "       |\n" +
                        "_______|\n";
            case 5:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|\\ |\n" +
                        "  /    |\n" +
                        "       |\n" +
                        "_______|\n";
            case 6:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|\\ |\n" +
                        "  / \\ |\n" +
                        "       |\n" +
                        "_______|\n";
            default:
                return "Sin mas intentos.";
        }
    }
    /*
     * Esta ayuda a verificar la cadena ingresada sea letras
     * lo guarda en la cadena y se va a verificar
     * si solo son letras da treu y si tiene numero... entonces devuelve false 
     */
    // Verifica que la cadena 
    public static boolean esSoloLetras(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /* 
     * Esto solicita la palabra del jugador para su oponente 
     * int jugador  nos indica que jugar ingresa la palabra para el oponente
     * return si la palabra es balida
     * no deja seguir el bucle si la palabra no cumple los requisitos de 6 letras y que solo sea letra
     * return avisa que no es valida la palabra
    */
    // Solicitar palabra al jugador
    private static String solicitarPalabra(int jugador) {
        String palabra;
        while (true) {
            System.out.println("Jugador " + jugador + ", ingrese una palabra de 6 letras para su oponente:");
            palabra = scanner.nextLine().trim().toLowerCase();

            if (palabra.length() == 6 && esSoloLetras(palabra)) {
                break;
            } else {
                System.out.println("La palabra debe tener exactamente 6 letras y solo letras.");
            }
        }
        return palabra;
    }
    /* 
     * controla la logica
     * es un metodo static void
     * en el se inicia el juego solicitando la palabra, lleva los turnos, 
     * recibe letras, muestra el estado del juego y determina el estado del juego 
     */
    // metodo principal Juego
    public static void juego() {
        System.out.println("Bienvenido al juego de Ahorcado");

        String palabra1 = solicitarPalabra(1);
        for (int i = 0; i < 50; i++) System.out.println(); 
        String palabra2 = solicitarPalabra(2);
        for (int i = 0; i < 50; i++) System.out.println();
        Ahorcado juego = new Ahorcado(palabra1, palabra2);
 
        //blucle del juego hasta que este termine
        while (!juego.getFinDelJuego()) {
            int turnoActual = juego.getTurno();
            System.out.println("Turno del jugador " + turnoActual);
            System.out.println("Palabra para adivinar: " + juego.avanceActual());
            System.out.print("Ingrese una letra: ");

            String entrada = scanner.nextLine().trim();
            //valida que la entrada sea valida
            if (entrada.length() != 1 || !esSoloLetras(entrada)) {
                System.out.println("Por favor, ingrese solo una letra valida.");
                continue;
            }

            char letra = entrada.charAt(0);
            String resultado = juego.jugarTurno(letra);
            System.out.println(resultado);

            int intentosRestantes = juego.intentosRestantes();
            System.out.println(dibujarMuneco(6 - intentosRestantes));
            // Cambiar turno solo si la letra fue incorrecta y el juego no termino
            if (resultado.toLowerCase().contains("incorrecta") && !juego.getFinDelJuego()) {
                juego.cambiarTurno();
            }
            //cuando termina el juego muestra el mensaje si gano o perdio y la pabra
            if (juego.getFinDelJuego()) {
                System.out.println("Juego terminado.");
                System.out.println("La palabra era: " + juego.getJugadorActual().getPalabra());
                break;
            }
        }
    }

    
}
