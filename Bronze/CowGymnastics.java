import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CowGymnastics {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("gymnastics.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
        
        int sessions = Integer.parseInt(st.nextToken());
        int numCows = Integer.parseInt(st.nextToken());

        int[][] data = new int[sessions][numCows];

        for (int i = 0; i < sessions; i++) {
            st = new StringTokenizer(qwerty.readLine());
            for (int j = 0; j < numCows; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ArrayList<String> pairList = new ArrayList<>();
        HashSet<String> pairSet = new HashSet<>();

        for (int j = 0; j < numCows; j++) {
            for (int f = j + 1; f < numCows; f++) {
                String pair = data[0][j] + " " + data[0][f];
                pairList.add(pair);
                pairSet.add(pair);
            }
        }


        for (int i = 1; i < sessions; i++) { // generates the remaining pairs from the other sessions
            boolean[] consistent = new boolean[pairList.size()];
            Arrays.fill(consistent, false);

            for (int f = 0; f < numCows; f++) {
                for (int j = f + 1; j < numCows; j++) {
                    String pair = data[i][f] + " " + data[i][j];
                    int idx = pairList.indexOf(pair);
                    if (idx != -1) {
                        consistent[idx] = true;
                    }
                }
            }

            for (int q = pairList.size() - 1; q >= 0; q--) {
                if (!consistent[q]) {
                    pairSet.remove(pairList.get(q));
                    pairList.remove(q);
                }
            }
        }

        pw.println(pairList.size());
        
        pw.flush();
        pw.close();
    }

    public static int factorialOf(int num) {
        int factorial = 1;
        for (int i = num; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
