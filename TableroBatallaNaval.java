public class TableroBatallaNaval {
    //Atributos 
    private Barcos[][] arrayBarcos = new Barcos[5][5];

    //Método Constructor
    public TableroBatallaNaval(){
        char[] barcos = {'1', '2', '3'};
        int fila = 0;
        int columna = 0;
        for(int i=0; i<barcos.length; i++){
            arrayBarcos[fila][columna] = new Barcos(barcos[i]);
        }
    }
}
