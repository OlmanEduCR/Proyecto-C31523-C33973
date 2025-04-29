public class Barcos{
    //Atributos
    private char barcoGrande;
    private char barcoMediano;
    private char barcoPequeño;
    private String jugadorBatallaNaval1;
    private String jugadorBatallaNaval2;
    private boolean estado;

    //Método Construtor
    public Barcos(char barcoGrande, char barcoMediano, char barcoPequeño, String jugadorBatallaNaval1, String jugadorBatallaNaval2, boolean estado){
        this.barcoGrande = barcoGrande;
        this.barcoMediano = barcoMediano;
        this.barcoPequeño = barcoPequeño;
        this.jugadorBatallaNaval1 = jugadorBatallaNaval1;
        this.jugadorBatallaNaval2 = jugadorBatallaNaval2;
        this.estado = estado;
    }
    
    //Setters 
    public void setBarcoGrande(char barcoGrandeP){
        this.barcoGrande = barcoGrandeP;
    }

    public void setBarcoMediano(char barcoMedianoP){
        this.barcoMediano = barcoMedianoP;
    }

    public void setBarcoPequeño(char barcoPequeñoP){
        this.barcoPequeño = barcoPequeñoP;
    }

    public void setJugadorBatallaNaval1(String jugadorBatallaNaval1P){
        this.jugadorBatallaNaval1 = jugadorBatallaNaval1P;
    }

    public void setJugadorBatallaNaval2(String jugadorBatallaNaval2P){
        this.jugadorBatallaNaval2 = jugadorBatallaNaval2P;
    }

    public void setEstado(boolean estadop){
        this.estado = estadop;
    }

    //Getters
    public char getBarcoGrande(){
        return this.barcoGrande;
    }

    public char getBarcoMediano(){
        return this.barcoMediano;
    }

    public char getBarcoPequeño(){
        return this.barcoPequeño;
    }

    public String getJugadorBatallaNaval1(){
        return this.jugadorBatallaNaval1;
    }

    public String getJugadorBatallaNaval2(){
        return this.jugadorBatallaNaval2;
    }

    public boolean getEstado(){
        return this.estado;
    }

    //Métodos
    public boolean estadoDelBarcoGrande(){
        boolean estado = false;
        if(barcoGrande != 0){
            estado = true;
        }
        return estado;
    }

    public boolean estadoDelBarcoMediano(){
        boolean estado = false;
        if(barcoGrande != 0){
            estado = true;
        }
        return estado;
    }

    public boolean estadoDelBarcoPequeño(){
        boolean estado = false;
        if(barcoGrande != 0){
            estado = true;
        }
        return estado;
    }
    
}