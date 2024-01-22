/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;


import java.util.List;


/**
 * 1234 3412 4123 2341
 *
 * @author pepecalo
 */
public class SudokuApp {

    public static void main(String[] args) throws Exception {

        SudokuDAO sistema=new SudokuDAO();

        Sudoku sudo = SudokuDAO.loadSudokuFromTXT("sudokuSolver.txt");
        System.out.println(sudo);
//        System.out.println("sudo.isCompleted() = " + sudo.isCompleted());
//        System.out.println("sudo.isValid() = " + sudo.isValid());
//        List<Sudoku> sudos = sudo.getChildren();
//        if(sudos!=null) {
//            for (Object sudo1 : sudos) {
//                System.out.println(sudo1);
//            }
//        }

        sistema.saveToJson(sudo, "prueba.json");

    }
}
