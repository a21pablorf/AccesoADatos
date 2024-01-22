/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proxecto_examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

/**
 *
 * @author A21PabloRF
 */
public class Proxecto_Examen {

    public static void main(String[] args) {
        List<String> nombres=List.of("Emily","Sylvia","Maya","Gabriela","Anne");
        
        LocalDateTime fecha=LocalDateTime.of(2023, 11, 12, 9, 45);
        
        
        Examen examenAD=new Examen("Acceso A Datos", fecha , nombres);

        Jsonb jsonb=JsonbBuilder.create();

        String strJason =jsonb.toJson(examenAD);

        try{
            Files.writeString(Path.of("examen.json"), strJason);
        }
        catch(IOException e){
            System.err.println("Error escribiendo el fichero");
        }


        System.out.println("Json resultante: "+strJason);
        
        
        
        
    }
}
