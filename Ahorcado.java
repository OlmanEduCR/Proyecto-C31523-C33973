public class Ahorcado {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno;          // 1 o 2
    private boolean finDelJuego;

    public Ahorcado(String palabra1, String palabra2) {
        jugador1 = new Jugador(palabra1);
        jugador2 = new Jugador(palabra2);
        turno = 1;
        finDelJuego = false;
    }

    public int getTurno() {
        return turno;
    }

    public boolean isFinDelJuego() {
        return finDelJuego;
    }

    public Jugador getJugadorActual() {
        return (turno == 1) ? jugador1 : jugador2;
    }

    public Jugador getJugadorOponente() {
        return (turno == 1) ? jugador2 : jugador1;
    }

    
    public String jugarTurno(char letra) {
        if (finDelJuego) {
            return "El juego ha terminado.";
        }

        Jugador jugadorActual = getJugadorActual();
        Jugador jugadorOponente = getJugadorOponente();
        String resultado = jugadorOponente.verificarLetra(letra);

        // Verificar si termino el juego
        if (resultado.toLowerCase().contains("incorrecta")) {
            jugadorActual.restarIntentos();
        }
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
