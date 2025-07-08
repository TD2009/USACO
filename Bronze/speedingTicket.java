import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class speedingTicket {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));

        TreeMap<Integer, Integer> limits = new TreeMap<>();
        TreeMap<Integer, Integer> speeds = new TreeMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int previousSegment = 1;
        for (int i = 0; i < n; i++) { // inputting the limits of N segments
            st = new StringTokenizer(qwerty.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            limits.put(length + previousSegment, limit);
            previousSegment += length;
        }

        int previousSpeed = 1;
        for (int i = 0; i < m; i++) { // inputting the limits of N segments
            st = new StringTokenizer(qwerty.readLine());
            int lengthss = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            speeds.put(lengthss + previousSpeed, speed);
            previousSpeed += lengthss;
        }

        int biggestInfraction = 0;
        for (int i = 1; i < 101; i++) {
            biggestInfraction = Math.max(biggestInfraction, valueOverLimit(limits, speeds, i));
        }
        pw.println(biggestInfraction);

        pw.flush();
        pw.close();
    }

    public static int valueOverLimit(TreeMap<Integer, Integer> limits, TreeMap<Integer, Integer> speeds, int point) {
        int currentLimit = limits.get(limits.higherKey(point));
        int currentSpeed = speeds.get(speeds.higherKey(point));

        return currentSpeed - currentLimit;
    }

}
