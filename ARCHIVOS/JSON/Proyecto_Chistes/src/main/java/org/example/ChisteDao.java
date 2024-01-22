package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ChisteDao implements IChisteDao{

    private Gson gson;

    private final String URL_BASE="https://v2.jokeapi.dev/joke/";

    private final String URL_TEMPLATE=URL_BASE+"{cat}/{lan}";

    public ChisteDao() {
        gson=new GsonBuilder().setPrettyPrinting().serializeNulls()
                .registerTypeAdapter(Chiste.class,new ChisteTypeAdapter())
                .registerTypeAdapter(Flag.class,new FlagDeserializer())
                .create();
    }

    @Override
    public String getRandomJoke() {
        Chiste c=null;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new URI(URL_BASE+"any").toURL().openStream()))){
            c= gson.fromJson(br,Chiste.class);
        } catch (IOException | URISyntaxException e) {
            System.err.println("Erro no método getRandomJoke");
            throw new RuntimeException(e);
        }
        return c.toString();
    }

    public 

    @Override
    public String getChisteByLang(String lang) {
        return null;
    }

    @Override
    public String getChisteByCategory(String cat) {
        return null;
    }
}
