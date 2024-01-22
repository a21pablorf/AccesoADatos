import java.util.Scanner;

class RuntimeDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolle un numero do 1 ao catro: ");
        int num = sc.nextInt();

        Runtime Objrun = Runtime.getRuntime();// LINE A
        

        
        try {
            
            switch (num) {
                case 1:
                    System.out.println(Objrun.availableProcessors()); 
                    break;

                case 2:
                    Objrun.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                    break;

                case 3:
                    Objrun.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe https://www.youtube.com/");
                    break;

                case 4: //Abrir visual studio
                    Objrun.exec("C:\\Program Files (x86)\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe");
                    break;

            
                default:
                    break;
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}