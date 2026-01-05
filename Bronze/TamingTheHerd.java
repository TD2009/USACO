import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class TamingTheHerd {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("taming.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));

        int days = Integer.parseInt(st.nextToken());
        int[] records = new int[days];
        st = new StringTokenizer(qwerty.readLine());

        boolean works = true;

        for (int i = 0; i < days; i++) {
            records[i] = Integer.parseInt(st.nextToken());
        }

        if (records[0] == -1) records[0] = 0;

        if (records[0] != -1 && records[0] != 0) {
            pw.println(-1);
            works = false;
        }else {
            for (int i = 0; i < days; i++) {
                if (!works) {
                    break;
                }
                if (records[i] != -1) {
                    if (i - records[i] < 0) {
                        pw.println(-1);
                        works = false;
                    } else {
                        for (int j = 1; j <= records[i]; j++) {
                            if (i - j < 0) {
                                works = false;
                                pw.println(-1);
                                break;
                            } else {
                                if (records[i - j] != records[i] - j) { // not equal to what is should be
                                    if (records[i - j] != -1) { // not -1 either
                                        pw.println(-1);
                                        works = false;
                                        break;
                                    } else {
                                        records[i - j] = records[i] - j;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int numZeros = 0;
        int numNumNegOnes = 0;

        for (int x: records) {
            if (x == 0) numZeros++;
            if (x == -1) numNumNegOnes++;
        }

        if (works) pw.println(numZeros + " " + (numNumNegOnes + numZeros));


        pw.flush();
        pw.close();
    
    }
}
