import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircularBarn {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int rooms = Integer.parseInt(st.nextToken());


        int[] capacities = new int[rooms];
        for (int i = 0; i < rooms; i++) {
            st = new StringTokenizer(qwerty.readLine());
            capacities[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int current = 0;
        int distance = 0;
        int temp = 0;
        for (int i = 0; i < rooms; i++) {
            for (int j = i; j < rooms; j++) {
                current += capacities[j] * distance;
                distance++;
            }
            for (int h = 0; h < i; h++) {
                current += capacities[h] * distance;
                distance++;
            }
            if (current < min) {
                min = current;
            }
            current = 0; distance = 0; temp = 0;
        }

        pw.println(min);

        pw.flush();
        pw.close();
    }
}
