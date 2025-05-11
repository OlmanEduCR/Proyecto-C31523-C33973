public class Jugador{
    //Atributos
    private String nombre;
    private Tablero tableropropio;
    private int contadorBarcos;

    //Método constructor
    public Jugador(String nombre, Tablero tableropropio, int contadorBarcos){
        this.nombre = nombre;
        this.tableropropio = tableropropio;
        this.contadorBarcos = 0;
    }
    
    //Setters
    public void setNombre(String nombreP){
        this.nombre = nombreP;
    }

    public void setTablero(Tablero tableropropioP){
        this.tableropropio = tableropropioP;
    }
    //Getters
    public String getNombre(){
        return this.nombre;
    }

    public Tablero getTableroPropio(){
        return tableropropio;
    }

    //Métodos
    //Batlla Naval
    public boolean moverBarco(int coorFila, int coorColumna) {
        Barco[][] tablero = tableropropio.getTableroDelJugador();
        char numBarco = (char)('1' + contadorBarcos);
        if(contadorBarcos<3){
            if (tablero[coorFila][coorColumna] == null) {
                tablero[coorFila][coorColumna] = new Barco(numBarco, true);
                contadorBarcos++;
                return true;
            } else {
                return false;
            }
        }
        return false;           
    }
    public void ataque(int coorFila, int coorColumna){
        Barco[][] tablero = tableropropio.getTableroDelJugador();
        if (tablero[coorFila][coorColumna] != null){
            tablero[coorFila][coorColumna] = new Barco('X', false);
            System.out.println("¡Casilla " + (coorFila + "/" + coorColumna) + " era un barco!");
        } else {
            tablero[coorFila][coorColumna] = new Barco('0', false);
            System.out.println("Casilla " + (coorFila + "/" + coorColumna) + " no hay impacto");
        }
    }
}
