
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
