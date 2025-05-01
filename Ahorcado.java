

public class Ahorcado{


    //atributo

    private String palabraJ1;
    private String palabraJ2;
    private char[] letrasPalabraJ1;
    private char[] letrasPalabraJ2;
    private boolean[] verificarPJ1;
    private boolean[] verificarPJ2;
    private int intentos1;
    private int intentos2;
    private int turno;
    private boolean FinDelJuego;

    //constructor
    public class Ahorcado(String palabra1, String palabra2){
    this.palabraJ1 = palabra1.toLowerCase();//para evitar problemas, esro transfa todo la palabra en minuscula ya que puede generar conflicto cuando se compare las entradas del Arrays 
    this.palabraJ2 = palabra2.toLowerCase();
    this.letrasPalabraJ1 = new char[palabra1.length()];
    this.letrasPalabraJ2 = new char[palabra2.length()];
    Arrays.fill(letrasPalabraJ1, "*");
    Arrays.fill(letrasPalabraJ2, "*");
    this.letrasPalabraJ1 = new char[6];
    this.letrasPalabraJ2 = new char [6];
    this.verificarPJ1 = new boolean[palabra1.length()];
    this.verificarPJ2 = new boolean[palabra2.length()];
    Arrays.fill(verificarPJ1);
    Arrays.fill(verificarPJ2);
    this.intentos1 = 0;
    this.intentos2 = 0;
    this.turno = 1;
    this.FinDelJuego = false;
    }
    //Getters
    //Setters
    

    //metodo, contador\intento
    //metodo para verificar que todabia queden intentos o finalizar el juego
    //metodo, para imprimer la palabra y tipo (intentos, palabra,muñeco(switch por nummeri de intentos))





}







/* Constructor 
public Ahorcado (String Palabra1, String palabra2){
     this.palabra1 = palabra1;-
     this.palabra2 = palabra2;-
     this.Arrays loob palabra1 [false];-
     This.Arrays loob palabra2 [false];-
     This.Arrays char1 [max 6);
     This.Arrays char2 [max 6);
     This.intentos1;
     This.intentos2;
     This.array fallos1 [max6];
     This.array fallos2 [max6];

     This.turni1 = 1;
     This.turni2 = 1;


     */