public class Tablero{

    //Atributos 
    private Barco[][] TableroDelJugador;

    //Método Constructor
    public Tablero(){
        this.TableroDelJugador = new Barco[5][5];
        for(int i=0; i< TableroDelJugador.length; i++){
            for(int j=0; j< TableroDelJugador.length; j++){
                TableroDelJugador[i][j] = new Barco('*', false);
            }
        }        
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
                if(TableroDelJugador[i][j].getBarco() == '*'){
                    System.out.print("* ");
                } else {
                    System.out.print(TableroDelJugador[i][j].getBarco() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean derrota(){
        int contadorX = 0;
        for(int i=0; i<TableroDelJugador.length; i++){
            for(int j=0; j<TableroDelJugador.length; j++){
                if(this.TableroDelJugador[i][j].getBarco() == 'X'){
                    contadorX++;
                }
            }
        }
        if(contadorX<3){
            return false;
        }
        return true;
    }
}