import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MaximizingProductivity {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] closings = new int[n];
        st = new StringTokenizer(qwerty.readLine());
        for(int i = 0; i < n; i++) {
            closings[i] = Integer.parseInt(st.nextToken());
        }

        int[] values = new int[n];
        st = new StringTokenizer(qwerty.readLine());
        for(int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            values[i] = closings[i] - curr - 1;
        }
        Arrays.sort(values);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int V = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int x = Arrays.binarySearch(values, S);

            if (x < 0) {
                x = -(x + 1); // first index greater than S
            } else {
                while (x > 0 && values[x - 1] == S) {
                    x--;
                }
            }

            if (n - (x) >= V) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }


        pw.flush();
        pw.close();
    }
}
