public class Barcos{
    //Atributos
    private String nombre;
    private char barco;
    private boolean estado;

    //Método Construtor
    public Barcos(String nombre, char barco, boolean estado){
        this.nombre = nombre;
        this.barco = barco;
        this.estado = estado;
    }
    
    //Setters
    public void setEstado(boolean estadop){
        this.estado = estadop;
    }

    //Getters
    public String getNombre(){
        return this.nombre;
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