package org.example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    public static void copiarArchivos(Path origen, Path destino) throws IOException {
        if (!destino.toFile().exists()){
            Files.createDirectory(destino);
        }
        try{
            if(Files.isDirectory(origen)){
                try(Stream<Path> s=Files.list(origen).filter(p -> p.toString().endsWith(".java"))){
                    s.forEach(c -> {
                        try {
                            copiarArchivos(c, destino.resolve(c.getFileName()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                catch (IOException ex){
                    System.out.println("Erro en copiado");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String dOrigen="L:\\AccesoADatos\\CORREGIDOS_PROFE";
        String dDestino="L:\\AccesoADatos\\JavaNIO\\PROBAS";

        copiarArchivos(Path.of(dOrigen),Path.of(dDestino));
    }
}