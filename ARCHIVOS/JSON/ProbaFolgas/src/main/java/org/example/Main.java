package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CreadorDePoetas cp=new CreadorDePoetas();

        GsonBuilder gb = new GsonBuilder();

        Gson gson = gb.setPrettyPrinting().serializeNulls().registerTypeAdapter(Poeta.class, cp).create();

        String poetaJson = "{ \"nome\" : \"Anne Sexton\",  \"idade\" : 45}";

        Poeta poeta = gson.fromJson(poetaJson, Poeta.class);

        System.out.println(poeta);
    }
}