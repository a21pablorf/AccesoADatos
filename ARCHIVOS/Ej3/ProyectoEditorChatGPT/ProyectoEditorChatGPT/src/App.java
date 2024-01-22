import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        try {
            // Intenta abrir el archivo para lectura
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            

            bufferedReader.close();

        } catch (IOException e) {
            // Si el archivo no existe, crea uno nuevo para escribir en él
            System.out.println("El archivo no existe. Se creará uno nuevo.");

            try {
                FileWriter fileWriter = new FileWriter(nombreArchivo);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Escribe el contenido del archivo (Escribe 'fin' para finalizar la escritura):");

                String linea;
                while (!(linea = scanner.nextLine()).equals("fin")) {
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                System.out.println("Contenido escrito en el archivo.");

            } catch (IOException ex) {
                System.err.println("Error al crear o escribir en el archivo.");
            }
        }

        scanner.close();
    }
}
