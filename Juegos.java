import java.util.Scanner;

public class Juegos{
    //Métodos
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Digite el número del juego que desee jugar:");
            System.out.println("1) Ahorcado");
            System.out.println("2) Batalla Naval");
            System.out.println("3) Salir del Sistema");
            opcion = entrada.nextInt();


            switch(opcion) {
                case 1:

                    JuegoAhorcado.juego();
                    //Juego Ahorcado se despliega si opcion es 1
                                       
                    break;
                
                case 2:
                    //Inicio
                    JuegoBatallaNaval.nombreDeLosJugadores();

                    //Mover los Barcos
                    JuegoBatallaNaval.fasePrevia();

                    //Juego y Ganador
                    JuegoBatallaNaval.juegoBatallaNaval();

                    //Juego Batalla Naval se despliega si opcion es 2
                
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Digite una opción válida");
                    break;
            }

        }
        while(opcion<3);
        entrada.close();
    }
}
