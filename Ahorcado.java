public class Ahorcado{
    //atributo
    private String palabraJ1;
    private String palabraJ2;
    private char[] palabraArrayJ1;
    private char[] palabraArrayJ2;
    private char[] letrasPalabraJ1;
    private char[] letrasPalabraJ2;
    private boolean[] verificarPJ1;
    private boolean[] verificarPJ2;
    private int intentos1;
    private int intentos2;
    private int turno;
    private boolean finDelJuego;


    //constructor
    public Ahorcado(String palabra1, String palabra2) {
    this.palabraJ1 = palabra1.toLowerCase();//para evitar problemas, esro transfa todo la palabra en minuscula ya que puede generar conflicto cuando se compare las entradas del Arrays 
    this.palabraJ2 = palabra2.toLowerCase();
    this.palabraArrayJ1 = palabra1.toLowerCase().toCharArray();
    this.palabraArrayJ2 = palabra2.toLowerCase().toCharArray();
    this.letrasPalabraJ1 = new char[palabra1.length()];
    this.letrasPalabraJ2 = new char[palabra2.length()];
    //llenar el array con el signo * para empezar
    for(int i = 0; i < letrasPalabraJ1.length; i++ ){
        letrasPalabraJ1[i] = '*';
    }
    for(int i=0 ; i < letrasPalabraJ2.length; i++){
        letrasPalabraJ2[i] = '*';
    }
    this.verificarPJ1 = new boolean[palabra1.length()];
    this.verificarPJ2 = new boolean[palabra2.length()];
    //llenar el array con valores en falso para empezar a verificar la palabra
    this.intentos1 = 6;
    this.intentos2 = 6;
    this.turno = 1;
    this.finDelJuego = false;
    }

    //Getters
    public String getPalabraJ1(){
        return palabraJ1;
    }
    public String getPalabraJ2(){
        return palabraJ2;
    }

    public char getPalabraArrayJ1(){
        return palabraArrayJ1;
    }
    public char getPalabraArrayJ2(){
        return palabraArrayJ2;
    }

    public char getletrasPalabraJ1(){
        return letrasPalabraJ1;
    }
    
    public char getLetrasPalabraJ2(){
        return letrasPalabraJ2;
    }

    public boolean getVerificarPJ1(){
        return verificarPJ1;
    }

    public boolean getVerificarPJ2(){
        return verificarPJ2;
    }

    public int getIntentos1(){
        return intentos1;
    }

    public int getIntentos2(){
        return intentos2;
    }

    public int getTurno() {
        return turno;
    }

    public boolean getFinDelJuego{
        return turno;
    }

    //Setters
    public String setPalabra1(String palabraJ1) {
        this.palabraJ1 = palabraJ1.toLowerCase(); //toLowerCase pasa las mayusculas a minisculas y minisculas no les hace nada
    }

    public String setPalabra2(String palabraJ2) {
        this.palabraJ2 = palabraJ2.toLowerCase(); //toLowerCase pasa las mayusculas a minisculas y minisculas no les hace nada
    }

    public char setPalabraArrayJ1(char palabraArrayJ1) {
        this.palabraArrayJ1 = palabraArrayJ1;    
    }

    public char setPalabraArrayJ2(char palabraArrayJ2) {
        this.palabraArrayJ2 = palabraArrayJ2;    
    }

    public char setLetrasPalabraJ1(char[] letrasPalabraJ1) {
        this.letrasPalabraJ1 = letrasPalabraJ1;
    }

    public char setLetrasPalabraJ2(char[] letrasPalabraJ2) {
        this.letrasPalabraJ1 = letrasPalabraJ2;
    }

    public boolean setVerificarPJ1(boolean[] verificarPJ1) {
        this.verificarPJ1 = verificarPJ1;
    }
    
    public boolean setVerificarPJ2(boolean[] verificarPJ2) {
        this.verificarPJ2 = verificarPJ2;
    }
    
    public int setIntentos1(int intentos1){
        this.intentos1 = intentos1;
    }

    public int setIntentos2(int intentos2){
        this.intentos2 = intentos2;
    }

    public int setTurno(int turno) {
        this.turno = turno;
    }

    public boolean setFinDelJuego(boolean finDelJuego) {
        this.finDelJuego = finDelJuego;
    }

    //metodo intento 

    public boolean verificarLetraPalabraJ1(char letra) {
        letra = Character.toLowerCase(letras);
        if(!Character.isLetter(letra)){
            return "Ingrese una letra valida";
        }
        boolean letraEncontrada = false;
        for(int i = 0; i< palabraJ1.length(); i++){
            if (!verificarPJ1[i]){
                letrasPalabraJ1[i] = letra;
                verificarPJ1[i] = true;
                letraEntrada = true ;
            }
        }
    }

    if(!letraEncontrada){
        intentos1--;
        if (intentos1 <= 0){
            finDelJuego = true;
            return "cantidad de intentos agotados, has perdido";
        } else{
            return "letra incorrecta tienes " + intentos1 + "intentos"; 
        }

    } else {
        boollean gano = true;
        for(boolean b : verificarPJ1) {
            if (!b){
                gano = false;
                break;
          }
        }
        if (gano) {
            finDelJuego = true;
            return "Felicidades adivino la palabra"
        }
        return "letra correcta"
    }











    



    //metodo, contador\intento
    //este  metodo se usara para tomar el char letra que se le solicita al jugar, se toma la letra en este caso y verifica si la letra que se ingreso esta en el array de la palabra que ingreso al principio o sea la palabraJ1 y si da falso ya que ninguna entrada del array es igual empieza a bajar al contador que inicia en 6 y si es verdades cambia la entrada que corresponde a la letra que se hace 




    //metodo para verificar que todabia queden intentos o finalizar el juego
    //metodo, para imprimer la palabra y tipo (intentos, palabra,muñeco(switch por nummeri de intentos))










}







