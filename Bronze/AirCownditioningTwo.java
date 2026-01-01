import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class AirCownditioningTwo {
    static Cow[] cows;
    static AirConditioner[] acs;
    static ArrayList<AirConditioner> newAcs;
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(s, t, c);
        }

        acs = new AirConditioner[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            AirConditioner ac = new AirConditioner(a, b, p, d);
            acs[i] = ac;
        }

        int minCost = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << m); ++mask) {
            newAcs = new ArrayList<AirConditioner>();
            for (int i = 0; i < m; ++i) {
                if ((mask & (1 << i)) != 0) {
                    newAcs.add(acs[i]);
                }
            }
            int currCost = 0;
            if (checkPossible(newAcs)) {
                for (AirConditioner ac : newAcs) {
                    currCost += ac.d;
                }
                minCost = Math.min(minCost, currCost);
            }
        }
        pw.println(minCost);



        pw.flush();
        pw.close();
    }

    public static boolean checkPossible(ArrayList<AirConditioner> acs) {
        int[] field = new int[101];
        for (AirConditioner ac : acs) {
            for (int i = ac.a; i <= ac.b; i++) {
                field[i] += ac.p;
            }
        }
        for (Cow cow : cows) {
            for (int i = cow.s; i <= cow.t; i++) {
                if (field[i] < cow.c) {
                    return false;
                }
            }
        }
        return true;
    }

    static class AirConditioner {
        int a;
        int b;
        int p;
        int d;

        public AirConditioner(int a, int b, int p, int d) {
            this.a = a;
            this.b = b;
            this.p = p;
            this.d = d;
        }
    }

    static class Cow {
        int s;
        int t;
        int c;

        public Cow(int s, int t, int c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }
    }
}
