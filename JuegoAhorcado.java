import java.util.Scanner;

public class JuegoAhorcado {
    private static Scanner scanner = new Scanner(System.in);
    
    //metodos
    public static String dibujarMu(int intentosFallados){
        switch(intentosFallados) {
            case 0:
                return  "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n";
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
                        "  /|\\  |\n" +  
                        "       |\n" +
                        "       |\n" +
                        "_______|\n";
            case 5:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|\\  |\n" +
                        "  /    |\n" +
                        "       |\n" +
                        "_______|\n";
            case 6:
                return  "   _____\n" +
                        "   |   |\n" +
                        "   0   |\n" +
                        "  /|\\  |\n" +
                        "  / \\  |\n" +
                        "       |\n" +
                        "_______|\n";
            default:
                return "Sin mas intentos ";
        }

    }
    //solicitar palabra 
    private static String solicitarPalabra(int jugador){
        String palabra;
        while (true) {
            System.out.println("Jugador " + jugador + " ingrese una palabra de 6 letras ");
            palabra = scanner.nextLine().trim().toLowerCase(); //
            if(palabra.length() == 6 && palabra.matches("[a-z]+")) {
                break;
            } else {
                System.out.println("Palabra incorrecta, debe de tener 6 letras");
            }
        }
        return palabra;
    }

    //metodo juego
    public static void juego() {
        System.out.println("bienvenido al juego de ahorcado ");
        //solicitar las palabras 
        
        System.out.println("Juegador 1, ingrese la palabra secreta de 6 letras");
        String palabra1 = scanner.nextLine().trim(); //El trim se usa para eliminar espacios blanco y evitar problemas 
        System.out.println();
        //como ban a jugar dos al mismo tiempo vamos a limpiar lo que sale en la pantalla
        for(int i = 0; i < 50; System.out.println());

        System.out.println("Juegador 2, ingrese la palabra secreta de 6 letras");
        String palabra2 = scanner.nextLine().trim(); //El trim se usa para eliminar espacios blanco y evitar problemas 
        System.out.println();
        //como ban a jugar dos al mismo tiempo vamos a limpiar lo que sale en la pantalla
        for(int i = 0; i < 50; System.out.println());


        Ahorcado juego = new Ahorcado(palabra1, palabra2);
            while (!juego.getFinDelJuego()) {
                int turnoActual = juego.getTurno();
                System.out.println("Turno del jugador " + turnoActual);
                System.out.println("Palabra " + juego.avanceEnLaPalabra(turnoActual));
                System.out.println("Ingresar letra ");
                String entrada = scanner.nextLine();
                //si la persona ingresa verias letras puede causar problemas enotnces para evitar eso usamos lo siguiente
                if(entrada.length() != 1) {
                    System.out.println("Ingrese solo una letra");
                    continue;
                }
                char letra = entrada.charAt(0);
                String resultado = juego.verificarLetra(turnoActual,letra);
                System.out.println(resultado);
                
                int intentosRestantes;
                if(turnoActual == 1) {
                    intentosRestantes = juego.getIntentos1();
                } else {
                    intentosRestantes = juego.getIntentos2();
                }
                String mensaje = "Fallaste, te queda " + intentosRestantes + "intentos";
                if(resultado.equals(mensaje)) {
                    juego.cambiarTurno();
                }
                if (juego.getFinDelJuego()){
                    System.out.println("Juego terminado");
                    System.out.println("Avance final del jugador" + turnoActual + juego.avanceEnLaPalabra(turnoActual));
                    break;
                }
            }
        }

    } 
    
