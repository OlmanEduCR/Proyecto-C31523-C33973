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
                return "Sin mas intentos ";
        }

    }
    //solicitar palabra 
    private static String solicitarPalabra(int jugador){
        String palabra;
        while (true) {
            System.out.println("Jugador " + jugador + " ingrese una palabra de 6 letras ");
            palabra = scanner.nextLine().trim().toLowerCase(); //
            if(palabra.length() == 6 && palabra.matches("[a-zA-Z]+")) {
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
        String palabra1 = solicitarPalabra(1);
        for(int i = 0; i < 50; i++) System.out.println(); //impreme 30 lienas en blanco

        String palabra2 = solicitarPalabra(2);
        for(int i = 0; i < 50; i++) System.out.println();
      



        Ahorcado juego = new Ahorcado(palabra1, palabra2);
            while (!juego.getFinDelJuego()) {
                int turnoActual = juego.getTurno();
                System.out.println("Turno del jugador " + turnoActual);
                System.out.println("Palabra " + juego.avanceEnLaPalabra(turnoActual));
                System.out.println("Ingresar letra ");
                String entrada = scanner.nextLine();
                //si la persona ingresa verias letras puede causar problemas enotnces para evitar eso usamos lo siguiente
                if(entrada.length() != 1|| !entrada.matches("[a-zA-Z]+")) {
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
                
                System.out.println(dibujarMu(6 - intentosRestantes));
                

                if (resultado.toLowerCase().contains("incorrecta")) {
                    juego.cambiarTurno();
                }
                
                if (juego.getFinDelJuego()){
                    System.out.println("Juego terminado");
                    System.out.println("Avance final del jugador " + turnoActual + juego.avanceEnLaPalabra(turnoActual));
                    break;
                }
            }
        }

    } 
    
