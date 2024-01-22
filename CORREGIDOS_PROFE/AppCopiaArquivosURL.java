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
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author pepecalo
 */
public class AppCopiaArquivosURL {

    public static final JFileChooser FC = new JFileChooser("e:\\");

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {
        // 

        // referencias ós arquivos orixe e destino.
        File fDestino;
        InputStream in = null;
        // mientras no se escriba una URL váldia un archivo muestra la ventana.
        String url;
        do {
            url = JOptionPane.showInputDialog(null, 
                    "Introduce una URL válida", 
                    "Descarga de recursos", JOptionPane.INFORMATION_MESSAGE);
            try {
                in = new URL(url).openStream();
            } catch (MalformedURLException ex) {

            } catch (IOException ex) {

            }
        } while (url == null || in == null);

        do {
            System.out.println("Introduce nome arquivo destino: ");
        } while (FC.showSaveDialog(null) != JFileChooser.APPROVE_OPTION);
        fDestino = FC.getSelectedFile();

        // f2: fluxo de saída (escritura) con buffer
        try(BufferedOutputStream f2 = new BufferedOutputStream(
                    new FileOutputStream(fDestino));) {
            int c; // o método read le un byte, pero devolve un enteiro, porque o fin de fluxo é -1
            while ((c = in.read()) != -1) {
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
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }

        }

    }

}
