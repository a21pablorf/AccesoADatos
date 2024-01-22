import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Teclado {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static String lerString(){
        String s = "";
        try{
            s = in.readLine();
        }catch(Exception e){
            System.out.println("Erro ao ler String");
        }
        return s;
    }

    public static char lerChar(){
        char c= ' ';
        try {
            c=(char) in.read();
        } catch (Exception e) {
            System.out.println("Erro ao ler Char");
        }
        return c;
    }

    public static int lerInt(){
        int i=0;
        try {
            i=Integer.valueOf(in.readLine());
        } catch (Exception e) {
            System.out.println("Erro ao ler INT");
        }
        return i;
    }

    public static long lerLong(){
        long c=0;
        try {
            c=Long.parseLong(in.readLine());
        } catch (Exception e) {
            System.out.println("Erro ao ler Long");
        }
        return c;
    }

    public static double lerDouble(){
        double c=0;
        try {
            c=Double.parseDouble(in.readLine());
        } catch (Exception e) {
            System.out.println("Erro ao ler Double");
        }
        return c;
    }
   
}
