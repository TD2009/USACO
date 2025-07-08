// Less than 9 min (8:55 including setup and eating 2 chocolates) + 7:40 bcuz spacing issues after testing (correct logic)
// 16:35

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class wordProcessor {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("word.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("word.out"));
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(qwerty.readLine());

        String word = "";
        int available = k;
        boolean first = true;
        boolean firstFirst = true;
        for (int i = 0; i < n; i++) {
            word = st.nextToken();
            if (available < word.length()) {
                pw.println();
                available = k;
                first = true;
            }

            available -= word.length();
            if (!first) pw.print(" " + word);
            else pw.print(word);
            first = false;
        }

        pw.flush();
        pw.close();
    }
}