import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;

public class WhereAmI {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("whereami.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("whereami.out"));

        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());
        String word = st.nextToken();
        int lowest = Integer.MAX_VALUE;
        for (int i = 1; i <= length; i++) { // length of each subsequence
            HashSet<String> seqs = new HashSet<String>();
            //numSeqs = length + 1 - i
            int n = 0;
            for (int numSeqs = 0; numSeqs < length + 1 - i; numSeqs++) {
                String curr = word.substring(numSeqs, numSeqs + i);
                if (seqs.contains(curr)) { // need to up i
                    n = -1;
                    break;
                } else {
                    seqs.add(curr);
                }
            }
            //for (String x : seqs) pw.print(x + " ");
            if (n == -1) { // this seq doesn't work, go up 1

            } else {
                lowest = Math.min(i, lowest);
            }
        }

        pw.println(lowest);

        
        pw.flush();
        pw.close();
    }
}
