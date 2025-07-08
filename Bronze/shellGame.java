import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shellGame {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("shell.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));

        int[][] shells = new int[3][2];
        shells[0][0] = 1;
        shells[0][1] = 0;

        shells[1][0] = 2;
        shells[1][1] = 0;

        shells[2][0] = 3;
        shells[2][1] = 0;
        int numSwaps = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numSwaps; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            swap(shells, one, two);
            shells[three - 1][1]++;
        }

        int one = shells[0][1];
        int two = shells[1][1];
        int three = shells[2][1];
        
        int most = Math.max(one, two);
        most = Math.max(three, most);
        pw.println(most);

        pw.flush();
        pw.close();
    }

    public static void swap(int[][] shells, int one, int two) {
        int temp = shells[one - 1][0];
        shells[one - 1][0] = shells[two - 1][0];
        shells[two - 1][0] = temp;

        temp = shells[one - 1][1];
        shells[one - 1][1] = shells[two - 1][1];
        shells[two - 1][1] = temp;
    }
}
