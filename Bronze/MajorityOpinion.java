import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;


public class MajorityOpinion {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));
        String ans;

        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] hays = new int[n];
            TreeSet<Integer> solutions = new TreeSet<>();
            st = new StringTokenizer(qwerty.readLine());
            for (int j = 0; j < n; j++) {
                hays[j] = Integer.parseInt(st.nextToken());
                try {
                    if (hays[j] == hays[j - 1] || hays[j] == hays[j - 2]) {
                        solutions.add(hays[j]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Do nothing
                }
            }
            if (solutions.size() == 0) {
                ans = "-1";
            } else {
                ans = "";
                for (int x : solutions) {
                    ans +=(x + " ");
                }
                ans = ans.stripTrailing();
            }
            pw.println(ans);
        }

        pw.flush();
        pw.close();
    }
}
