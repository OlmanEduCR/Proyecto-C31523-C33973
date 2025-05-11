public class Tablero{
    //Atributos 
    private Barco[][] TableroDelJugador;

    //Método Constructor
    public Tablero(){
        this.TableroDelJugador = new Barco[5][5];        
    }

    //Getters
    public Barco[][] getTableroDelJugador(){
        return this.TableroDelJugador;
    }

    //Setters
    public void setTableroDelJugador(Barco[][] TableroDelJugadorP){
        this.TableroDelJugador = TableroDelJugadorP;
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

    public boolean derrota(){
        for(int i=0; i<TableroDelJugador.length; i++){
            for(int j=0; j<TableroDelJugador.length; j++){
                if(TableroDelJugador[i][j].getEstado() == false || TableroDelJugador[i][j] == null){
                    return true;
                }
            }
        } 
        return false;
    }
}


