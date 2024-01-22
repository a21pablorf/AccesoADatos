import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Documento {
    File arquivo;

    Documento(String nombreArchivo) throws IOException {
        arquivo = new File(nombreArchivo);
        arquivo.createNewFile();
    }

    Documento(File arquivo) {
        this.arquivo = arquivo;
    }

    public boolean exists() {
        return arquivo.exists();
    }

    public String readFile() throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }

    public String readFileNIO() throws IOException {
        if (!exists())
            return "El archivo no existe";

        return Files.readString(arquivo.toPath());
    }

    public void writeFromString(String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write("\n"+contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFromStringPrintWriter(String contenido) {
        try (FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(contenido+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
