
public class Tablero{
    //Atributos 
    private Barco[][] TableroDelJugador = new Barco[5][5];
    char[] barcos = {'1', '2', '3'};

    //Método Constructor
    public Tablero(){
        for(int i=0; i<barcos.length; i++){
            TableroDelJugador[0][i] = new Barco(barcos[i], true);
        }
    }

    //Métodos
    public void mostrarTablero(){
        for(int i=0; i<TableroDelJugador.length; i++){
            for(int j=0; j<TableroDelJugador.length; j++){
                if(TableroDelJugador[i][j] == null){
                    System.out.print("* ");
                } else{
                    System.out.print(TableroDelJugador[i][j].getBarco() + " ");
                }
            }
            System.out.println();
        }
    }
}
