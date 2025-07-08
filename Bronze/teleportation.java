import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teleportation{
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("teleport.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("teleport.out"));

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (Math.abs(b - x) < Math.abs(b - y)) {
            if (Math.abs(a - y) + Math.abs(b - x) < Math.abs(b - a)) {
                pw.print(Math.abs(a - y) + Math.abs(b - x));
            } else {
                pw.print(Math.abs(b - a));
            }
        } else {
            if (Math.abs(a - x) + Math.abs(b - y) < Math.abs(b - a)) {
                pw.print(Math.abs(a - x) + Math.abs(b - y));
            } else {
                pw.print(Math.abs(b - a));
            }
        }

        pw.flush();
        pw.close();
    }
}
