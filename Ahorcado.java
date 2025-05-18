public class Ahorcado {
    //Atributos
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno;          
    private boolean finDelJuego;
    /*
     * Metodo Constructor del ahorcado
     * parametro String palabra1, palabra que ingresa jugador 1 y adivina jugador 2   
     * parametro String palabra2, palabra que ingresa jugador 2 y adivina jugador 1
     * establece turno inicial en 1 
     * Ayuda a establecer que el juego no ha terminado
    */
    public Ahorcado(String palabra1, String palabra2) {
        jugador1 = new Jugador(palabra1);
        jugador2 = new Jugador(palabra2);
        turno = 1;
        finDelJuego = false;
    }
    //Getters
    public int getTurno() {
        return turno;
    }

    public boolean getFinDelJuego() {
        return finDelJuego;
    }

    public Jugador getJugadorActual() {
        return (turno == 1) ? jugador1 : jugador2;
    }

    public Jugador getJugadorOponente() {
        return (turno == 1) ? jugador2 : jugador1;
    }
    //Metodos
    /*
     * -esto establece al jugador actual el turno para ingresar una letra
     * letra chart es la letra que ingresa el jugador
     * return resultado informa si es correcta o incorrecta
     * -el otro verifica si la letra ingresada esta en la palabra que se tiene que adivinar
     * -el otro cambia el esatdo del juego y verifica si alguien gana o pierde
    */
    public String jugarTurno(char letra) {
        if (finDelJuego) {
            return "El juego ha terminado.";
        }

        Jugador jugadorActual = getJugadorActual();
        Jugador jugadorOponente = getJugadorOponente();
        String resultado = jugadorOponente.verificarLetra(letra);
        if(jugadorOponente.haGanado()){
            finDelJuego = true;
            return resultado + " El jugador " + turno + " gano.";
        } else if (jugadorActual.estaSinIntentos()) {
            finDelJuego = true;
            return resultado + " El jugador " + turno + " perdio.";
        }
        return resultado;
    }
    /*
     * Cambia el turno del jugador actual al siguiente 
     * Va alternando el turno entre 1 y 2
     */
    public void cambiarTurno() {
        turno = (turno == 1) ? 2 : 1;
    }
    /*
     * obtiene el avance del oponente de las letras adivinadas 
     * return devuelve las letras adivimadas Ej **y*t*
     */
    public String avanceActual() {
        return getJugadorOponente().getLetrasAdivinadas();
    }
    /*
    * Nos dice la cantidad de intentos que le quedan al jugador actual 
    * return numero de intentos que tiene le queda al juagador que tiene elm turno
    */
    public int intentosRestantes() {
        return getJugadorActual().getIntentos();
    }
}