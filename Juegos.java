import java.util.Scanner;

public class Juegos{
    //Métodos
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Digite el número del juego que desee jugar:");
            System.out.println("1) Batalla Naval");
            System.out.println("2) Ahorcado");
            System.out.println("3) Salir del Sistema");
            opcion = entrada.nextInt();

            switch(opcion) {
                case 1:
                        //Inicio del Juego Batalla Naval
                        System.out.println("Bienvenido a Batalla Naval, por favor digite el nombre de los participantes");
                        System.out.println("Jugador 1:");
                        jugador1 = entrada.nextLine();
                        entrada.nextLine();
                        System.out.println("Jugador 2:");
                        jugador2 = entrada.nextLine();
                        entrada.nextLine();

                        //Mover Barcos, Turno jugador 1
                        System.out.println(jugador1 + "ingrese la posición de sus barcos");

                        //Ataques por turnos
                        do{

                        }
                        
                    
                    break;
            
                default:
                    break;
            }

        }
        while(opcion<3);
    }
}
