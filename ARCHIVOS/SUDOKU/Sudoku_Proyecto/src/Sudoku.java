import java.util.Set;

public class Sudoku {
    private Set<Character> alfabeto;
    private char[][] celas;
    private final int TAMANO = 9;
    private final Set<Character> ALFABETO_POR_DEFECTO  = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');


    public Sudoku() {
        this.alfabeto = ALFABETO_POR_DEFECTO;
        this.celas = new char[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                celas[i][j] = 0;
            }
        }
    }
}
