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

    public char[] getPalabraArrayJ1(){
        return palabraArrayJ1;
    }
    public char[] getPalabraArrayJ2(){
        return palabraArrayJ2;
    }

    public char[] getLetrasPalabraJ1(){
        return letrasPalabraJ1;
    }
    
    public char[] getLetrasPalabraJ2(){
        return letrasPalabraJ2;
    }

    public boolean[] getVerificarPJ1(){
        return verificarPJ1;
    }

    public boolean[] getVerificarPJ2(){
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

    public boolean getFinDelJuego(){
        return finDelJuego;
    }

    //Setters
    public void setPalabra1(String palabraJ1) {
        this.palabraJ1 = palabraJ1.toLowerCase(); //toLowerCase pasa las mayusculas a minisculas y minisculas no les hace nada
    }

    public void setPalabra2(String palabraJ2) {
        this.palabraJ2 = palabraJ2.toLowerCase(); //toLowerCase pasa las mayusculas a minisculas y minisculas no les hace nada
    }

    public void setPalabraArrayJ1(char[] palabraArrayJ1) {
        this.palabraArrayJ1 = palabraArrayJ1;    
    }

    public void setPalabraArrayJ2(char[] palabraArrayJ2) {
        this.palabraArrayJ2 = palabraArrayJ2;    
    }

    public void setLetrasPalabraJ1(char[] letrasPalabraJ1) {
        this.letrasPalabraJ1 = letrasPalabraJ1;
    }

    public void setLetrasPalabraJ2(char[] letrasPalabraJ2) {
        this.letrasPalabraJ2 = letrasPalabraJ2;
    }

    public void setVerificarPJ1(boolean[] verificarPJ1) {
        this.verificarPJ1 = verificarPJ1;
    }
    
    public void setVerificarPJ2(boolean[] verificarPJ2) {
        this.verificarPJ2 = verificarPJ2;
    }
    
    public void setIntentos1(int intentos1){
        this.intentos1 = intentos1;
    }

    public void setIntentos2(int intentos2){
        this.intentos2 = intentos2;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setFinDelJuego(boolean finDelJuego) {
        this.finDelJuego = finDelJuego;
    }

    //metodos 

    public String verificarLetra(int jugador, char letra) {
        letra = Character.toLowerCase(letra);    
        if(!Character.isLetter(letra)){
            return "Ingrese una letra valida";
        }

        char[] palabraArray;
        char[] letrasPalabra;
        boolean[]verificarP;

        if(jugador == 1 ) {
            palabraArray = palabraArrayJ1;
            letrasPalabra = letrasPalabraJ1;
            verificarP = verificarPJ1;
        } else {
            palabraArray = palabraArrayJ2;
            letrasPalabra = letrasPalabraJ2;
            verificarP = verificarPJ2;
        }

        boolean letraEncontrada = false; //verificar la letra que se encotro esta o no esta en el array

        for(int i = 0; i< palabraArray.length; i++){
            if (palabraArray[i] == letra && !verificarP[i]) {
                letrasPalabra[i] = letra;
                verificarP[i] = true;
                letraEncontrada = true ;
            }
        }
       
        if(!letraEncontrada){ //si la letra no esta, resta uno a la cantidad de intentos 
            if (jugador == 1){
                intentos1--;
                if (intentos1 <= 0){
                    finDelJuego = true;
                    return "Te quedaste sin intentos";
                }
                return "Letra incorrecta te quedan " + intentos1 + " intentos";
            } else { 
                intentos2--;
                if(intentos2<= 0) {
    
                    finDelJuego =  true;
                    return "Te quedaste sin intentos";
                }
                return "Letra incorrecta te quedan " + intentos2 + " intentos";
            }
        } else {
            boolean gano = true;
            for(boolean b : verificarP) {
                if(!b) {
                    gano = false;
                    break;
                }
            } 
            if (gano){
                finDelJuego = true;
                return "Felicitaciones acerto la palabra";
            }
            return "Letra correcta";
        }
    }
    
    public String avanceEnLaPalabra(int jugador) {//Mostar los aciertos de la en las palabras dadas
        char[] letras;
        if(jugador == 1) {
            letras = letrasPalabraJ1;
        }else{
            letras = letrasPalabraJ2;
        }
        return new String(letras);
    }
        //cambio de turnos
        public void cambiarTurno() {
            if(turno == 1) {
                turno = 2;
            } else {
                turno = 1;
            }
        }
    }










