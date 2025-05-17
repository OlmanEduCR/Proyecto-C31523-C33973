import java.util.Scanner;

public class JuegoAhorcado {
    private static Scanner scanner = new Scanner(System.in);

    // Dibujo del ahorcado segun intentos fallados
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

    // Verifica que la cadena contenga solo letras
    public static boolean esSoloLetras(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) {
                return false;
            }
        }
        return true;
    }

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

    // Juego
    public static void juego() {
        System.out.println("Bienvenido al juego de Ahorcado");

        String palabra1 = solicitarPalabra(1);
        for (int i = 0; i < 50; i++) System.out.println(); // Limpiar pantalla

        String palabra2 = solicitarPalabra(2);
        for (int i = 0; i < 50; i++) System.out.println();

        Ahorcado juego = new Ahorcado(palabra1, palabra2);

        while (!juego.getFinDelJuego()) {
            int turnoActual = juego.getTurno();
            System.out.println("Turno del jugador " + turnoActual);
            System.out.println("Palabra para adivinar: " + juego.avanceActual());
            System.out.print("Ingrese una letra: ");

            String entrada = scanner.nextLine().trim();

            if (entrada.length() != 1 || !esSoloLetras(entrada)) {
                System.out.println("Por favor, ingrese solo una letra válida.");
                continue;
            }

            char letra = entrada.charAt(0);
            String resultado = juego.jugarTurno(letra);
            System.out.println(resultado);

            int intentosRestantes = juego.intentosRestantes();
            System.out.println(dibujarMuneco(6 - intentosRestantes));

            // Cambiar turno solo si la letra fue incorrecta y el juego no terminó
            if (resultado.toLowerCase().contains("incorrecta") && !juego.getFinDelJuego()) {
                juego.cambiarTurno();
            }

            if (juego.getFinDelJuego()) {
                System.out.println("Juego terminado.");
                System.out.println("La palabra era: " + juego.getJugadorActual().getPalabra());
                break;
            }
        }
    }

    
}
