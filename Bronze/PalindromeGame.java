import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class PalindromeGame {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(qwerty.readLine());
            String s = st.nextToken();
            pw.println(solve(s));
        }


        pw.flush();
        pw.close();
    }

    public static char solve(String s) {
        String str = s;
        if (str.length() == 1 || new StringBuilder(str).reverse().toString().equals(str)) {
            return 'B';
        }
        if (str.charAt(str.length() - 1) == '0') {
            return 'E';
        }

        return 'B';
    }
}
