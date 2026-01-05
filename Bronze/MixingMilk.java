import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixingMilk {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("mixmilk.in"));
        //BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));
        //PrintWriter pw = new PrintWriter((System.out));


        int[] capacities = new int[3];
        int[] amounts = new int[3];

        capacities[0] = Integer.parseInt(st.nextToken());
        amounts[0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());

        capacities[1] = Integer.parseInt(st.nextToken());
        amounts[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());

        capacities[2] = Integer.parseInt(st.nextToken());
        amounts[2] = Integer.parseInt(st.nextToken());

        int toPour;

        toPour = Math.min(amounts[0], capacities[1] - amounts[1]);
        amounts[1] += toPour;
        amounts[0] -= toPour;

        toPour = Math.min(amounts[1], capacities[2] - amounts[2]);
        amounts[2] += toPour;
        amounts[1] -= toPour;

        toPour = Math.min(amounts[2], capacities[0] - amounts[0]);
        amounts[0] += toPour;
        amounts[2] -= toPour;

        toPour = Math.min(amounts[0], capacities[1] - amounts[1]);
        amounts[1] += toPour;
        amounts[0] -= toPour;
        
        for (int x : amounts) {
            pw.println(x);
        }

        pw.flush();
        pw.close();
    }
}
