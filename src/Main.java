import java.io.FileOutputStream;
import java.io.PrintStream;
public class Main {
    public static void main(String[] args) {
        Management m = new Management();

                try {
                    PrintStream fileOut = new PrintStream(new FileOutputStream("src/output.log", true));
                    System.setOut(fileOut);
                    System.setErr(fileOut);

                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}