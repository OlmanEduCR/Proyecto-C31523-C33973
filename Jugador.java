public class Jugador{
    //Atributos
    private String nombre;
    private Tablero tableropropio;

    //Método constructor
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    //Setters
    public void setNombre(String nombrep, Tablero tableropropio){
        this.nombre = nombrep;
        this.tableropropio = new Tablero();
    }

    //Getters
    public String getNombre(){
        return this.nombre;
    }

    //Métodos
    //Batlla Naval
    public boolean moverBarco(int coorF, int coorC, int numBarco){
        int contadorF = 0;
        int contadorC = 0;
        Barco[][] tablerop = tableropropio.getTableroDelJugador(); 
        for(Barco[] fila:tablerop){
            if(contadorF == coorF){
                for(Barco casillaBarco:fila){
                    if(contadorC == coorC && casillaBarco.getEstado() != true){
                        casillaBarco.setEstado(true);
                        casillaBarco.setBarco(tableropropio.barcos[numBarco-1]);
                        return true;
                    }
                    contadorC++;                    
                }
            }
            contadorF++;   
        } return false;
    }

    public void ataque(int coorF, int coorC, int numBarco){
        Barco[][] tablerop = tableropropio.getTableroDelJugador();
        int contadorF = 0;
        int contadorC = 0; 
        for(Barco[] fila:tablerop){
            if(contadorF == coorF){
                for(Barco casillaBarco:fila){
                    if(contadorC == coorC && casillaBarco.getEstado() == true){
                        casillaBarco.setEstado(false);
                        casillaBarco.setBarco('X');
                    } else{
                        casillaBarco.setBarco('0');
                    }
                    contadorC++;                    
                }
            }
            contadorF++;   
        }
    }
}
