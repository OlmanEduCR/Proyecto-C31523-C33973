public class Barcos{
    //Atributos
    private char barco1;
    private char barco2;
    private char barco3;
    private boolean estado;

    //Método Construtor
    public Barcos(char barco1, char barco2, char barco3, boolean estado){
        this.barco1 = barco1;
        this.barco2 = barco2;
        this.barco3 = barco3;
        this.estado = estado;
    }
    
    //Setters 
    public void setBarcoGrande(char barco1P){
        this.barco1 = barco1P;
    }

    public void setBarcoMediano(char barco2P){
        this.barco2 = barco2P;
    }

    public void setBarcoPequeño(char barco3P){
        this.barco3 = barco3P;
    }

    public void setEstado(boolean estadop){
        this.estado = estadop;
    }

    //Getters
    public char getBarcoGrande(){
        return this.barco1;
    }

    public char getBarco2(){
        return this.barco2;
    }

    public char getBarco3(){
        return this.barco3;
    }

    public boolean getEstado(){
        return this.estado;
    }

    //Métodos
    public boolean estadoDelBarco1(){
        boolean estado = false;
        if(barco1 != 0){
            estado = true;
        }
        return estado;
    }

    public boolean estadoDelBarco2(){
        boolean estado = false;
        if(barco2 != 0){
            estado = true;
        }
        return estado;
    }

    public boolean estadoDelBarco3(){
        boolean estado = false;
        if(barco3 != 0){
            estado = true;
        }
        return estado;
    }    
}