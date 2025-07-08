import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WDTCCTR3 {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("cowqueue.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

        int cows = Integer.parseInt(st.nextToken());

        int[] arrivalTime = new int[cows];
        int[] timeTaken = new int[cows];

        for (int i = 0; i < cows; i++) {
            st = new StringTokenizer(qwerty.readLine());
            arrivalTime[i] = Integer.parseInt(st.nextToken());
            timeTaken[i] = Integer.parseInt(st.nextToken());
        }
        int lowest;
        int currentIndex = -1;
        int time = 0;
        for (int i = 0; i < cows; i++) {
            lowest = 2000000;
            for (int g = 0; g < cows; g++) {
                if (arrivalTime[g] < lowest) {
                    lowest = arrivalTime[g];
                    currentIndex = g;
                }
            }
            if (!(time > arrivalTime[currentIndex])) time = arrivalTime[currentIndex];

            time += timeTaken[currentIndex];
            
            //pw.println("Current num " + arrivalTime[currentIndex] + " Time " + time);
            arrivalTime[currentIndex] = 2000000;
        }

        pw.println(time);

        pw.flush();
        pw.close();
    }
}
