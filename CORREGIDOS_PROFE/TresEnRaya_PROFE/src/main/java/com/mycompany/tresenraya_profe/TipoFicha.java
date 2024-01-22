/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.mycompany.tresenraya_profe;

/**
 *
 * @author pepe
 */
public enum TipoFicha {
    CIRCULO('O', 1), CRUZ('X', -1), VACIA(' ', 0);
    
    private final char caracter;
    private final int valor;

//    private TipoFicha(char caracter) {
//        this.caracter = caracter;
//    }
    
    private TipoFicha(char caracter, int valor) {
        this.caracter = caracter;
        this.valor = valor;
    }
    
    public static TipoFicha getTipoFicha(char c){
        if(c== CRUZ.valor){
            return CRUZ;
        }
        else if(c==CIRCULO.valor){
            return CIRCULO;
        }
        return null;
    }

    public char getCaracter() {
        return caracter;
                
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(caracter);
    }
    
    

}
