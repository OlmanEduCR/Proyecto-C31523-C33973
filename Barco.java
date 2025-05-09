public class Barco{
    //Atributos
    private char barco;
    private boolean estado;

    //Método Construtor
    public Barco(char barco, boolean estado){
        this.barco = barco;
        this.estado = estado;
    }
    
    //Setters
    public void setEstado(boolean estadop){
        this.estado = estadop;
    }

    public void setBarco(char barcop){
        this.barco = barcop;
    }

    //Getters
    public char getBarco(){
        return this.barco;
    }

    public boolean getEstado(){
        return this.estado;
    }

    //Métodos
    public boolean estadoDelBarco(){
        boolean estado = false;
        if(barco != 0){
            estado = true;
        }
        return estado;
    }    
}