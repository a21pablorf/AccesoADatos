import java.io.*;


/**
 * App
 */
public class App {

    public static String pullBytes(InputStream in, int count) throws IOException {
        in.mark(count);
        var sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append((char) in.read());
        }
        in.reset();
        in.skip(1);
        sb.append((char) in.read());
        return sb.toString();
    }

    private void echo() throws IOException {
        var o = new FileWriter("novo-noHayCole.txt");
        try (var f = new FileReader("noHayCole.txt");
           var b = new BufferedReader(f); o) {
              o.write(b.readLine());
         }
         o.write("");
     }

    public void copyFile(File file1, File file2) throws Exception {
	var reader = new InputStreamReader(new FileInputStream(file1));
    try (var writer = new FileWriter(file2)) {
       char[] buffer = new char[10];
       while(reader.read(buffer) != -1) {
          writer.write(buffer);
          // n1
        }
    }
    }

    public static void main(String[] args) {
        String linea;
        var c = System.console();
        Writer w = c.writer();
        try {
            try (w) {
                if ((linea = c.readLine("Introduce tu nombre: ")) != null)
                    w.append(linea);
                w.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}