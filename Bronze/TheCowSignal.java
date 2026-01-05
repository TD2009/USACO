import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheCowSignal {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("cowsignal.out"));

        int m = Integer.parseInt(st.nextToken()); // vertical
        int n = Integer.parseInt(st.nextToken()); // horizontal
        int k = Integer.parseInt(st.nextToken()); // dilation size

        for (int i = 0; i < m; i++) { // going line by line
            st = new StringTokenizer(qwerty.readLine());
            String line = st.nextToken();
            String extendedLine = "";
            for (int j = 0; j < n; j++) { // going character by character
                String character = line.substring(j, j + 1);
                for (int p = 0; p < k; p++) {
                    pw.print(character);
                    extendedLine += character;
                }
            }
            pw.println();
            for (int o = 0; o < k - 1; o++) pw.println(extendedLine);
        }


        pw.flush();
        pw.close();
    }
}
