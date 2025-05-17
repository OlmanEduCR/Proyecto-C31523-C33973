public class Jugador{
    //Atributos
    private String nombre;
    private Tablero tableropropio;
    private int contadorBarcos;

    private String palabra;          
    private char[] palabraArray;     
    private char[] letrasAdivinadas; 
    private boolean[] letrasVerificadas; 
    private int intentos;  

    //Metodo constructor
    public Jugador(String nombre, Tablero tableropropio, int contadorBarcos){
        this.nombre = nombre;
        this.tableropropio = tableropropio;
        this.contadorBarcos = 0;
    }

    public Jugador(String palabra) {
        this.palabra = palabra.toLowerCase();
        this.palabraArray = this.palabra.toCharArray();
        this.letrasAdivinadas = new char[palabra.length()];
        this.letrasVerificadas = new boolean[palabra.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '*';
            letrasVerificadas[i] = false;
        }
        this.intentos = 6;
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

    public String getPalabra() {
        return palabra;
    }

    public int getIntentos() {
        return intentos;
    }

    public String getLetrasAdivinadas() {
        return new String(letrasAdivinadas);
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

    public String verificarLetra(char letra) {
        letra = Character.toLowerCase(letra);
        if (!Character.isLetter(letra)) {
            return "Ingrese una letra válida.";
        }

        boolean letraEncontrada = false;

        for (int i = 0; i < palabraArray.length; i++) {
            if (palabraArray[i] == letra && !letrasVerificadas[i]) {
                letrasAdivinadas[i] = letra;
                letrasVerificadas[i] = true;
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            intentos--;
            if (intentos <= 0) {
                return "Te quedaste sin intentos.";
            }
            return "Letra incorrecta. Te quedan " + intentos + " intentos.";
        } else {
            // Verificar si ganó
            for (boolean b : letrasVerificadas) {
                if (!b) {
                    return "Letra correcta.";
                }
            }
            return "¡Felicitaciones! Adivinaste la palabra.";
        }
    }
    
    public void restarIntentos(){
        intentos--;
    }

    public boolean estaSinIntentos() {
        return intentos <= 0;
    }

    public boolean haGanado() {
        for (boolean b : letrasVerificadas) {
            if (!b) return false;
        }
        return true;
    }
}