import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Arrays;


public class LoadBalancing {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("balancing.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("balancing.out"));

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Point[] cows = new Point[n];
        int[] xCoords = new int[n];
        int[] yCoords = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Point(x, y);
            xCoords[i] = x;
            yCoords[i] = y;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < xCoords.length; i++) {
            for (int j = 0; j < yCoords.length; j++) {
                int split = getSplit(cows, xCoords[i] + 1, yCoords[j] + 1);
                if (split < min) {
                    min = split;
                }
            }
        }

        pw.println(min);

        pw.flush();
        pw.close();
    }

    static int getSplit(Point[] cows, int vert, int horiz) {
        int[] counts = new int[4]; // NE, NW, SW, SE

        for (Point cow : cows) {
            if (cow.x > vert && cow.y > horiz) {
                counts[0]++; // NE
            } else if (cow.x < vert && cow.y > horiz) {
                counts[1]++; // NW
            } else if (cow.x < vert && cow.y < horiz) {
                counts[2]++; // SW
            } else if (cow.x > vert && cow.y < horiz) {
                counts[3]++; // SE
            }
        }

        //System.out.println("Counts for vert " + vert + " and horiz " + horiz + ": " + Arrays.toString(counts));

        int maxCount = 0;
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
