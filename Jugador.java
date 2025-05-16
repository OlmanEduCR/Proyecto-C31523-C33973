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

    public int getContadorBarcos(){
        return contadorBarcos;
    }

    //Métodos
    //Batlla Naval
    public boolean moverBarco(int coorColumna, int coorFila) {
        Barco[][] tablero = tableropropio.getTableroDelJugador();
        char numBarco = (char)('1' + contadorBarcos);
        if (coorColumna < 1 || coorFila < 1 || coorColumna > tablero.length || coorFila > tablero[0].length) {
            return false;
        }
        
        if(contadorBarcos<3){
            if (tablero[(coorColumna - 1)][(coorFila - 1)] == null || tablero[(coorColumna - 1)][(coorFila - 1)].getBarco() == '*' ){
                tablero[(coorColumna - 1)][(coorFila - 1)] = new Barco(numBarco, true);
                contadorBarcos++;
                return true;
            } else {
                return false;
            }
        }
        return false;           
    }
    public boolean ataque(int coorColumna, int coorFila){
        Barco[][] tablero = tableropropio.getTableroDelJugador();
        if (coorColumna < 1 || coorFila < 1 || coorColumna > tablero.length || coorFila > tablero[0].length) {
            return false;
        }
        Barco casillaTablero = tablero[(coorFila-1)][(coorColumna-1)];

        if (casillaTablero != null && casillaTablero.getBarco() == '*'){
            tablero[(coorFila-1)][(coorColumna-1)] = new Barco('0', false);
            System.out.println("Casilla " + (coorColumna + "/" + coorFila) + " no hay impacto");
            tableropropio.mostrarTablero();
        } else {
            tablero[(coorFila-1)][(coorColumna-1)] = new Barco('X', false);
            System.out.println("¡Casilla " + (coorColumna + "/" + coorFila) + " era un barco!");
            tableropropio.mostrarTablero();
        }
        return true;
    }
}
