import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class subSequencesSummingToSeven {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("div7.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("div7.out"));

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] pRemainder = new int[n + 1];
        pRemainder[0] = 0;

        int[] exists = new int[7];
        int[] latest = new int[7];
        Arrays.fill(exists, -1);
        Arrays.fill(latest, -1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(qwerty.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
            pRemainder[i + 1] = (nums[i] + pRemainder[i]) % 7;
            if (exists[pRemainder[i + 1]] == -1) exists[pRemainder[i + 1]] = i + 1; // set to i if wanting index, not position
            //pw.println(pRemainder[i + 1] + " is current");
            latest[pRemainder[i + 1]] = i + 1;
            //pw.println("set " + latest[pRemainder[i + 1]] + " to " + (i + 1));
        }
        
        int max = 0;
        for (int i = 0; i < 7; i++) if (exists[i] != -1) max = Math.max(max, latest[i] - exists[i]);
        
        pw.println(max);

        pw.flush();
        pw.close();
    }
}
