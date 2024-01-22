/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.e01copiar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author pepecalo
 */
public class AppCopiaArquivos {

    public static Scanner SC = new Scanner(System.in);
    

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {
        // 

        // referencias ós arquivos orixe e destino.
        File fOrixe, fDestino;
        // pide a introducción do nome do arquivo mentres non exista:
        do {
            System.out.println("Introduce nome arquivo orixe: ");
            fOrixe = new File(SC.nextLine()); // pasamos directamente a cadea ó construtor do arquivo.
            //System.out.println("O arquivo " + fOrixe + " non existe");
        } while (!fOrixe.exists());

        do {
            System.out.println("Introduce nome arquivo destino: ");
            fDestino = new File(SC.nextLine());
           // System.out.println("O arquivo " + fDestino + " non existe");
        } while (fDestino.exists());

        BufferedInputStream f1 = null; // fluxo de entrada (lectura) con buffer
        BufferedOutputStream f2 = null; // fluxo de saída (escritura) con buffer
        try {
            int c; // o método read le un byte, pero devolve un enteiro, porque o fin de fluxo é -1
            f1 = new BufferedInputStream(
                    new FileInputStream(fOrixe));
            f2 = new BufferedOutputStream(
                    new FileOutputStream(fDestino));
            while ((c = f1.read()) != -1) {
                f2.write(c);
            }

        } catch (FileNotFoundException ex) {
            // aínda que no programa facemos un control de que o arquivo
            // ten que existir, é preciso capturar a excepción.
            System.out.println("Arquivo non atopado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro de lectura/escritura: " + ex.getMessage());
        } finally {
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException ex) {
                }
            }
            if (f2 != null) {
                try {
                    f2.close();
                } catch (IOException ex) {
                }
            }
        }

    }

}
