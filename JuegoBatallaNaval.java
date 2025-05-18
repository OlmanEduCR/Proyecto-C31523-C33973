import java.util.Scanner;

public class JuegoBatallaNaval{
    private static Jugador jugador1 = new Jugador("X", new Tablero(), 3);
    private static Jugador jugador2 = new Jugador("X", new Tablero(), 3);

    static Scanner entrada = new Scanner(System.in);

    //Método de inicio
    /* Es un método que se encarga de settear los nombres de los jugadores com inicio*/
    public static void nombreDeLosJugadores(){
        System.out.println("Bienvenido a Batalla Naval, por favor digite el nombre de los participantes");
        System.out.println("Jugador 1:");
        jugador1.setNombre(entrada.nextLine());
        System.out.println("Jugador 2:");
        jugador2.setNombre(entrada.nextLine());
    }

    //Prejuego
    /* Este método se encarga de llamar al método moverBarcos para asignar los barcos dentro de los rangos del tablero, 
     * antes de empezar el juego. */
    public static void fasePrevia(){
        //Jugador 1
        System.out.println(jugador1.getNombre() + " ingrese la posición de sus barcos");
        int barcosColocadosJ1 = 0;
        while(barcosColocadosJ1<3){
            System.out.println("Barco #" + (barcosColocadosJ1 + 1));
            System.out.print("Digite la Columna: ");
            int fila = entrada.nextInt();
            System.out.print("Digite la Fila: ");
            int columna = entrada.nextInt();

            boolean exito = jugador1.moverBarco(columna, fila);

            if(exito){
                barcosColocadosJ1++;
                jugador1.getTableroPropio().mostrarTablero();
            }else{
            System.out.println("Posición inválida o ya ocupada. Intente de nuevo.");
        }
    }
    
        //Jugador 2
        System.out.println(jugador2.getNombre() + " ingrese la posición de sus barcos");
        int barcosColocadosJ2 = 0;
        while(barcosColocadosJ2<3){
            System.out.println("Barco #" + (barcosColocadosJ2 + 1));
            System.out.print("Digite la Columna: ");
            int fila = entrada.nextInt();
            System.out.print("Digite la Fila: ");
            int columna = entrada.nextInt();

            boolean exito = jugador2.moverBarco(columna, fila);

            if(exito){
                barcosColocadosJ2++;
                jugador2.getTableroPropio().mostrarTablero();
            }else{
            System.out.println("Posición inválida o ya ocupada. Intente de nuevo.");
            }
        }
    }

    //Juego
    /*Este método se divide en dos métodos exactamente iguales que se distinguen en turnos para cada jugador, es un bucle que termina hasta que alguien
     * pierda. En cada turno, le pide al jugador del turno las coordenadas por atacar, las verifica, si se digitan coordenadas erroneas, rehace la solicitud,
     * si son correctas, verifica mediante ataque la posición atacada y la registra con un simbolo distinguido ('X' si habia un barco, '0' si fue al agua)*/
    public static void juegoBatallaNaval(){
        System.out.println("Empieza " + jugador1.getNombre());
        while(!jugador1.getTableroPropio().derrota() && !jugador2.getTableroPropio().derrota()){
            boolean acierto = false;
            // Turno del Jugador 1
            while(acierto == false){
                try{
                    System.out.println(jugador1.getNombre() + ", ingrese las coordenadas para atacar: ");
                    System.out.print("Digite la columna que desea atacar: ");
                    int colAtaque = entrada.nextInt();
                    System.out.print("Digite la fila que desea atacar: ");
                    int filaAtaque = entrada.nextInt();

                    acierto = jugador2.ataque(colAtaque, filaAtaque);
                    System.out.println(jugador1.getNombre() + " ataca a " + jugador2.getNombre());

                    if(acierto == true){
                    jugador2.getTableroPropio().mostrarTablero();
                    } else{
                    System.out.println("Coordenadas fuera del mapa o ya atacadas. Penalización de turno");
                    break;
                    }

                    if (jugador2.verificarAtaque(colAtaque, filaAtaque) == true) {
                    System.out.println("[ATAQUE] ¡Casilla " + colAtaque + "/" + filaAtaque + " era un barco!");
                    } else{
                    System.out.println("[ATAQUE] Casilla " + colAtaque + "/" + filaAtaque + " no hay impacto");
                    }
                }catch(ArrayIndexOutOfBoundsException ataqueFallido){
                    System.out.println("Ingrese una coordenada válida.");
                } 

                if(jugador2.getTableroPropio().derrota()){
                    System.out.println(jugador2.getNombre() + " ha perdido todos sus barcos. ¡" + jugador1.getNombre() + " gana!");
                    break;
                }
            }

            // Turno del Jugador 2
            while(acierto == false){
                try{
                    System.out.println(jugador2.getNombre() + ", ingrese las coordenadas para atacar: ");
                    System.out.print("Digite la columna que desea atacar: ");
                    int colAtaque = entrada.nextInt();
                    System.out.print("Digite la fila que desea atacar: ");
                    int filaAtaque = entrada.nextInt();

                    acierto = jugador1.ataque(colAtaque, filaAtaque);
                    System.out.println(jugador2.getNombre() + " ataca a " + jugador1.getNombre());

                    if(acierto == true){
                    jugador1.getTableroPropio().mostrarTablero();
                    } else{
                    System.out.println("Coordenadas fuera del mapa o ya atacadas. Penalización de turno");
                    break;
                    }

                    if (jugador1.verificarAtaque(colAtaque, filaAtaque) == true) {
                    System.out.println("[ATAQUE] ¡Casilla " + colAtaque + "/" + filaAtaque + " era un barco!");
                    } else{
                    System.out.println("[ATAQUE] Casilla " + colAtaque + "/" + filaAtaque + " no hay impacto");
                    }
                }catch(ArrayIndexOutOfBoundsException ataqueFallido){
                    System.out.println("Ingrese una coordenada válida.");
                } 

                if(jugador1.getTableroPropio().derrota()){
                    System.out.println(jugador1.getNombre() + " ha perdido todos sus barcos. ¡" + jugador2.getNombre() + " gana!");
                    break;
                }
            }
        }
    }
}