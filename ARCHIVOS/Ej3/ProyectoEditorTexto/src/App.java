
public class App {
    public static void main(String[] args) throws Exception {
        //Scanner sc=new Scanner(System.in);

        //System.out.println("Introduce el nommbre ");

        Documento f=new Documento("proba.txt");

        //f.writeFromString("3 linea?");
        
        System.out.println(f.readFile());       

    }
}
