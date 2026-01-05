import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BovineShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("shuffle.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));

        int cows = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());
        int[] shifts = new int[cows];
        for (int i = 0; i < cows; i++) {
            shifts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(qwerty.readLine());
        int[] locations = new int[cows];
        for (int i = 0; i < cows; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        int[] moveTo = new int[cows + 1];
        for (int i = 1; i < cows + 1; i++) {
            moveTo[shifts[i - 1]] = i;
        }

        int[] clone = new int[locations.length];
        for (int i = 0; i < 3; i++) { // Happening 3 times
            for (int q = 0; q < locations.length; q++) {
                clone[q] = locations[q];
            }
            //pw.println("CLONED LIST: " + Arrays.toString(clone) + " VS. ORIGINAL LIST: " + Arrays.toString(locations));
            for (int f = 1; f < cows + 1; f++) { //Happening 5 times
                int moveToThisLocation = moveTo[f];
                //pw.println("Moving " + locations[f - 1] + "to index " + (moveToThisLocation - 1));
                locations[moveToThisLocation - 1] = clone[f - 1];
            }
        }
        for (int x: locations) {
            pw.println(x);
        }
        pw.flush();
        pw.close();
    }
}
