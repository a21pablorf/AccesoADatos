package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        JsonReader reader=new JsonReader(Files.newBufferedReader(Path.of("clasificacion.json")));



    }
}