/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tresenraya_profe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author A21PabloRF
 */
public class AppFluxos {

    public static void main(String[] args) throws MalformedURLException, IOException {
        System.out.println("Gola");
        
        BufferedInputStream br = new BufferedInputStream(new URL("https://dle.rae.es/app/doc/es/img/dle.jpg").openStream());
        
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("L:\\AccesoADatos\\ola.jpg"));
        
        int c;
        
        while((c=br.read())!=-1){
            bo.write(c);
        }
        
        br.close();
        bo.close();
       
    }
}
