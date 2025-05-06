
public class TableroBatallaNaval {
    //Atributos 
    private Barcos[][] TableroJugador1 = new Barcos[5][5];
    private Barcos[][] TableroJugador2 = new Barcos[5][5];

    //Método Constructor
    public TableroBatallaNaval(){
        char[] barco = {'1', '2', '3'};
        int fila = 0;
        int columna = 0;
        for(int i=0; i<barco.length; i++){
            TableroJugador1[fila++][columna++] = new Barcos(null, barco[i], false);
        }
        for(int j=0; j<barco.length; j++){
            TableroJugador2[fila++][columna++] = new Barcos(null, barco[j], false);
        }
    }

    //Métodos
    public void moverBarcosTableroJ1(){
        for(int i=0; i<TableroJugador1.length; i++){

        }
    }

    public void ataque(){

    }
}
