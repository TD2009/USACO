import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class MilkExchange {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String directions = qwerty.readLine();
        char[] direction = directions.toCharArray();

        int[] capacity = new int[n];
        long totalSum = 0;
        st = new StringTokenizer(qwerty.readLine());
        for(int i = 0; i < n; i++) {
            capacity[i] = Integer.parseInt(st.nextToken());
            totalSum += capacity[i];
        }

        pw.println(solve(n, m, totalSum, direction, capacity));

        pw.flush();
        pw.close();
    }

    public static long solve(int n, int m, long sum, char[] direction, int[] capacity) {
        long answer = sum;

        /*
        int curr = n - 1;
        while (curr >= 0 && direction[curr] == 'R') {
            curr--;
        }
        if (curr == -1) { // only works if all are 'R'
            return sum;
        }


        int operations = 0;
        System.out.println("Started at index: " + curr);
        for (int i = curr; i % n != curr; i++) {
            System.out.println("Iter # " + operations + " : " + i + " " + i % n + " " + (curr - 1));
            operations++;
        }
        */
       //int lastLoss = -1;
       for (int i = 0; i < n; i++) {
            if (direction[(i - 1 + n) % n] == 'R' && direction[(i + 1) % n] == 'L') {
                long left = 0;
                long right = 0;
                
                int curr = (i - 1 + n) % n;
                while (direction[curr] == 'R') {
                    left += capacity[curr];
                    curr = (curr - 1 + n) % n;
                }

                curr = (i + 1) % n;
                while (direction[curr] == 'L') {
                    right += capacity[curr];
                    curr = (curr + 1) % n;
                }

                if (direction[i] == 'L') {
                    answer -= Math.min(m, right);
                    //System.out.println("Lost " + Math.min(m, capacity[(i + 1) % n]) + " at index " + i);
                } else {
                    answer -= Math.min(m, left);
                    //System.out.println("Lost " + Math.min(m, capacity[(i - 1 + n) % n]) + " at index " + i);
                }
                //answer -= Math.min(m, Math.min(capacity[(i - 1 + n) % n], capacity[(i + 1) % n]));
                //lastLoss = i;
                //System.out.println("Lost " + Math.min(m, Math.min(capacity[(i - 1 + n) % n], capacity[(i + 1) % n])) + " at index " + i);
            }
       }

        return answer;
    }
}
