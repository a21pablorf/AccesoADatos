import java.io.*;
import java.awt.Point;
/**
 * APPObjetoIO
 */
public class APPObjetoIO {

    public static void main(String[] args) {
        
        try(  ObjectOutputStream oo = new ObjectOutputStream(
            new FileOutputStream("L:\\AccesoADatos\\Varios\\datos.dat"));) {
            
            oo.writeObject(new Point(0,1));

        } catch (IOException ex){
            System.out.println("MAL");
        }
        

        
    }
}