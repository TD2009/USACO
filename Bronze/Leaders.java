import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class Leaders {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter((System.out));

        int firstG = -1;
        int firstH = -1;
        int lastG = -1;
        int lastH = -1;

        int n = Integer.parseInt(st.nextToken());
        String str = qwerty.readLine();
        char[] cows = str.toCharArray();

        int ans = 0;

        int q = 0;
        while (firstG == -1 || firstH == -1 || lastG == -1 || lastH == -1) {
            if (lastG == -1 && cows[n - 1 - q] == 'G') {
                lastG = n - 1 - q;
            }
            if (lastH == -1 && cows[n - 1 - q] == 'H') {
                lastH = n - 1 - q;
            }
            if (firstG == -1 && cows[q] == 'G') {
                firstG = q;
            }
            if (firstH == -1 && cows[q] == 'H') {
                firstH = q;
            }
            q++;
        }

        int[] ends = new int[n];
        st = new StringTokenizer(qwerty.readLine());
        for (int i = 0; i < n; i++) {
            ends[i] = (Integer.parseInt(st.nextToken()) - 1);
        }

        if (ends[firstG] >= lastG) { // contains all gs
            for (int i = 0; i < firstG; i++) {
                if (cows[i] == 'H' && ends[i] >= firstG) {
                    ans++;
                }
            }
        }
        if (ends[firstH] >= lastH) { // contains all hs
            for (int i = 0; i < firstH; i++) {
                if (cows[i] == 'G' && ends[i] >= firstH) {
                    ans++;
                }
            }
        }

        if (ends[firstG] >= lastG && ends[firstH] >= lastH) {
            ans++;
        }

        pw.println(ans);
        /*
        for (int i = 0; i < n; i++) {
            char cow = cows[i];
            int end = ends[i];
        }
            */

        pw.flush();
        pw.close();
    }
}
