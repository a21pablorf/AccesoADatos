package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClasificacionDAO {

    private static final Path OBJECT_FILE= Path.of("clasificacion.dat");
    private static final String JSON_FILE= "clasificacion.json";

    private final Gson gson;

    public ClasificacionDAO() {
        gson=new GsonBuilder().setPrettyPrinting().create();
    }

    public void savetoObject(Clasificacion c){
        try(BufferedWriter bw= Files.newBufferedWriter(OBJECT_FILE)){
            bw.write(String.valueOf(c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToJson(Clasificacion c, String p){
        //String json=gson.toJson(Path.of(p));
        try(BufferedWriter bw=Files.newBufferedWriter(Path.of(p))){
            gson.toJson(Path.of(p), bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
