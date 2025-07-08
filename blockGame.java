// 27:02 (Spent lots of time on the HashMap)
// December 2016 Bronze #2
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class blockGame {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("blocks.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));

        HashMap<String, Integer> code = new HashMap<>();
        code.put("a", 0);
        code.put("b", 1);
        code.put("c", 2);
        code.put("d", 3);
        code.put("e", 4);
        code.put("f", 5);
        code.put("g", 6);
        code.put("h", 7);
        code.put("i", 8);
        code.put("j", 9);
        code.put("k", 10);
        code.put("l", 11);
        code.put("m", 12);
        code.put("n", 13);
        code.put("o", 14);
        code.put("p", 15);
        code.put("q", 16);
        code.put("r", 17);
        code.put("s", 18);
        code.put("t", 19);
        code.put("u", 20);
        code.put("v", 21);
        code.put("w", 22);
        code.put("x", 23);
        code.put("y", 24);
        code.put("z", 25);


        int pairs = Integer.parseInt(st.nextToken());
        int[] required = new int[26];

        int[] timesIn1 = new int[26];
        int[] timesIn2 = new int[26];

        for (int i = 0; i < pairs; i++) {
            st = new StringTokenizer(qwerty.readLine());
            String word1 = st.nextToken();
            String word2 = st.nextToken();

            timesIn1 = new int[26];
            timesIn2 = new int[26];


            for (int q = 0; q < word1.length(); q++) {
                String letter = word1.substring(q, q+1);
                timesIn1[code.get(letter)] += 1;
            }

            for (int q = 0; q < word2.length(); q++) {
                String letter = word2.substring(q, q+1);
                timesIn2[code.get(letter)] += 1;
            }

            for (int q = 0; q < 26; q++) {
                required[q] += Math.max(timesIn1[q], timesIn2[q]);
            }
        }
        for (int x : required) pw.println(x);

        pw.flush();
        pw.close();
    }
}
