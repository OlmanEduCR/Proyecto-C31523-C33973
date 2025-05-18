public class Ahorcado {
    //Atributos
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno;          // 1 o 2
    private boolean finDelJuego;

    //Método Constructor
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

    //Métodos
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

    public void cambiarTurno() {
        turno = (turno == 1) ? 2 : 1;
    }
    
    public String avanceActual() {
        return getJugadorOponente().getLetrasAdivinadas();
    }

    public int intentosRestantes() {
        return getJugadorActual().getIntentos();
    }
}
