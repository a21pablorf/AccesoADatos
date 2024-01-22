package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonReader reader=new JsonReader(Files.newBufferedReader(Path.of("tiempo.json")));

        while (reader.hasNext()){
            JsonToken siguienteToken= reader.peek();
            System.out.println(siguienteToken);

            if (siguienteToken!=null){
                switch (siguienteToken){
                    case BEGIN_ARRAY ->
                        reader.beginArray();

                    case BEGIN_OBJECT ->
                        reader.beginObject();

                    case NAME -> {
                        String nomeAtributo = reader.nextName();
                        System.out.println(nomeAtributo);
                    }

                }
            }
        }
    }
}