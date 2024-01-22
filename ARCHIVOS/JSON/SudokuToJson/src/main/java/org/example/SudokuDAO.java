package org.example;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SudokuDAO {

    public static final ExclusionStrategy EXCLUSION_STRATEGY =new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return "alfabeto".equals(fieldAttributes.getName());
        }
        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    };

    public void saveToJson(Sudoku sudoku, String ruta){

        Gson gson = new GsonBuilder().setPrettyPrinting().setExclusionStrategies(EXCLUSION_STRATEGY).create();
        try(BufferedWriter bw= Files.newBufferedWriter(Path.of(ruta))){
            gson.toJson(sudoku,bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveSudoku(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(ruta)));) {
            oos.writeObject(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Sudoku loadSudoku(String ruta) {
        Sudoku sudo = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(ruta)));) {
            sudo = (Sudoku) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ó leer o sudoku: " + e.getMessage());
        }
        return sudo;
    }
    public static Sudoku loadSudokuFromTXT(String ruta) throws Exception {
        int fila = 0;
        char[][] celas = null;
        try (BufferedReader br
                     = new BufferedReader(new FileReader(ruta));) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (fila == 0) {
                    celas = new char[linha.length()][linha.length()];
                }
                celas[fila++] = linha.toCharArray();
            }

        } catch (Exception e) {
            System.out.println("Erro ó leer o sudoku: " + e.getMessage());
        }
        return new Sudoku(celas);
    }
}