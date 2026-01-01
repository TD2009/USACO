import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class MooOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int q = Integer.parseInt(st.nextToken());
        for(int i = 0; i < q; i++){
            char[] letters = qwerty.readLine().toCharArray();
            pw.println(solve(letters));

        }

        pw.flush();
        pw.close();
    }

    public static int solve(char[] letters) {
        ArrayList<Integer> middles = new ArrayList<>();
        for (int i = 1; i < letters.length - 1; i++) {
            if (letters[i] == 'O') {
                middles.add(i);
            }
        }

        if (middles.size() == 0) {
            return -1;
        }

        int best = Integer.MAX_VALUE;
        for (int mid : middles) {
            int operations = letters.length - 3;
            int left = mid - 1;
            int right = mid + 1;

            if (letters[left] != 'M') {
                operations++;
            }
            if (letters[right] != 'O') {
                operations++;
            }

            best = Math.min(best, operations);
        }
        return best;
    }
}
