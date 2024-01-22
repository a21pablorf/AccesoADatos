package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        //Gson gson=new Gson();

        GsonBuilder bg=new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation();

        Gson gson= bg.create();


        Chuvia hoxe=new Chuvia("Chuvascos", 3.5);

        //Escribo
        try(BufferedWriter bw= Files.newBufferedWriter(Path.of("chuvia.json"))) {
            gson.toJson(hoxe, bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Leo
        try(BufferedReader br=Files.newBufferedReader(Path.of("chuvia.json"))) {
            Chuvia chuvia =gson.fromJson(br, Chuvia.class);
            System.out.println(chuvia);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}