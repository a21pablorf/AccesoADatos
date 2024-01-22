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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author pepecalo
 */
public class AppCopiaArquivosFC {

    public static final JFileChooser FC = new JFileChooser("e:\\");

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {
        // 

        // referencias ós arquivos orixe e destino.
        File fOrixe, fDestino;
        // mientras no se selecciona un archivo muesrtra la ventana.
        do {
//            System.out.println("Introduce nome arquivo orixe: ");

        } while (FC.showOpenDialog(null) != JFileChooser.APPROVE_OPTION);
        fOrixe = FC.getSelectedFile();

        do {
//            System.out.println("Introduce nome arquivo destino: ");
        } while (FC.showSaveDialog(null) != JFileChooser.APPROVE_OPTION);
        fDestino = FC.getSelectedFile();

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
            JOptionPane.showMessageDialog(null, 
                    "Arquivo non atopado: " + ex.getMessage(), "Arquivo non atopado",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error de lectura/escritura: " + ex.getMessage(), "Error E/S",
                    JOptionPane.ERROR_MESSAGE);
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
