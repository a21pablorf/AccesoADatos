
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * EjercicioUno
 */
public class EjercicioUno {

    public static void main(String[] args) {

        
        try(FileInputStream in = new FileInputStream("L:\\AccesoADatos\\Varios\\Hola.txt");
        FileOutputStream out = new FileOutputStream("L:\\AccesoADatos\\Varios\\Adios.txt");) {
            
            int c;

            while ((c = in.read()) != -1)
                out.write(c);
        } catch(IOException ex){
            System.out.println("Error de E/S: " + ex.getMessage());
        }
    }
}