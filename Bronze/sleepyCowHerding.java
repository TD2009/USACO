import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sleepyCowHerding {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("herding.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("herding.out"));

        ArrayList<Long> cows = new ArrayList<>();

        cows.add(Long.parseLong(st.nextToken()));
        cows.add(Long.parseLong(st.nextToken()));
        cows.add(Long.parseLong(st.nextToken()));
        Collections.sort(cows);

        Long minDist = Math.min(cows.get(1) - cows.get(0), cows.get(2) - cows.get(1));
        Long maxDist = Math.max(cows.get(1) - cows.get(0), cows.get(2) - cows.get(1));

        if (minDist == 1 && maxDist == 1) {
            pw.println(0);
            pw.println(0);
        } else {
            if (minDist != 2 && maxDist != 2) {
                pw.println(2);
            } else {
                pw.println(1);
            }
            pw.println(maxDist - 1);
        }

        /*
        if (minDist == 1 && maxDist == 1) {
            pw.println(0);
            pw.println(0);
        } else {
            if (minDist != 2 && maxDist != 2) {
                if (minDist > 1) { // this line somehow has the issue
                    pw.println(2);
                } else {
                    pw.println(1);
                }
            } else {
                pw.println(1);
            }
            pw.println(maxDist - 1);
        }
        */

// 3 6 9

        pw.flush();
        pw.close();
    }
}

