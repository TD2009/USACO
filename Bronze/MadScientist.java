import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MadScientist {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("breedflip.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));

        int numCows = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());
        String a = st.nextToken();
        st = new StringTokenizer(qwerty.readLine());
        String b = st.nextToken();
        
        int flipsNeeded = 0;
        boolean currently = false;
        for (int i = 0; i < numCows; i++) {
            if (a.substring(i, i + 1).equals(b.substring(i, i + 1)) && currently) { // means that the flip sequence is over
                currently = false;
                flipsNeeded++;
            } else if (!(a.substring(i, i + 1).equals(b.substring(i, i + 1)))) { // the flip sequence has started
                currently = true;
            }
        }

        pw.println(flipsNeeded);

        pw.flush();
        pw.close();
    }
}
