package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChisteTypeAdapter extends TypeAdapter<Chiste> {
    @Override
    public void write(JsonWriter jsonWriter, Chiste chiste) throws IOException {

    }

    @Override
    public Chiste read(JsonReader in) throws IOException {
        Chiste c=new Chiste();
        in.beginObject();
        while (in.hasNext()){
            String atributo=in.nextName();
            switch (atributo){
                case "categoria":
                    c.setCategoria(in.nextString());
                    break;
                case "tipo":
                    c.setTipo(in.nextString());
                    break;
                case "pregunta":
                    c.setPregunta(in.nextString());
                    break;
                case "respuesta":
                    c.setRespuesta(in.nextString());
                    break;
                case "seguro":
                    c.setSeguro(in.nextBoolean());
                    break;
                case "id":
                    c.setId(in.nextInt());
                    break;
                case "idioma":
                    c.setIdioma(in.nextString());
                    break;
                case "flags":
                    if (in.peek() == JsonToken.BEGIN_ARRAY) {
                        in.beginArray();
                        List<Flag> flags = new ArrayList<>();
                        while (in.hasNext()) {
                            flags.add(Flag.valueOf(in.nextString()));
                        }
                        in.endArray();
                        c.setFlags(flags);
                    }
                    else{
                        return null;
                    }
                    break;
            }
        }
        in.endObject();
        return c;
    }
}
