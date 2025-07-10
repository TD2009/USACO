import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class watchingMooloo {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());
        long[] days = new long[n];
        for (int i = 0; i < n; i++) {
            days[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = k + 1; // starting a membership on the first day
        for (int i = 0; i < n - 1; i++) {
            long current = days[i];
            long next = days[i + 1];

            if (next - current <= k + 1) { // then continue the membership
                totalCost += next - current;
            } else { // end the membership
                totalCost += k + 1;
            }
        }

        pw.println(totalCost);

        pw.flush();
        pw.close();
    }
}
