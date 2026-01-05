import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class theBucketList {

    static class Cow {
        int start;
        int end;
        int buckets;
        boolean valid = true;

        Cow (int start, int end, int buckets) {
            this.start = start;
            this.end = end;
            this.buckets = buckets;
        }

        int getStart() {
            return this.start;
        }

        int getEnd() {
            return this.end;
        }

        int getBuckets() {
            return this.buckets;
        }

        boolean getValid() {
            return valid;
        }

        void setValid(boolean value) {
            valid = valid;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("blist.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("blist.out"));

        int numCows = Integer.parseInt(st.nextToken());

        int[] starts = new int[numCows];
        String[] values = new String[numCows];
        Cow[] cows = new Cow[numCows];

        for (int i = 0; i < numCows; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int buckets = Integer.parseInt(st.nextToken());

            cows[i] = new Cow(start, end, buckets);
        }


        int currentBucketsUsed = 0;
        int mostBucketsUsed = Integer.MIN_VALUE;

        for (int i = 1; i < 1001; i++) { // i is time
            if (findCurrentAction(cows, i) != -1) {
                int currentCow = findCurrentAction(cows, i);
                cows[currentCow].setValid(false);
                if (cows[currentCow].getStart() == i) { // start a new cow
                    currentBucketsUsed += cows[currentCow].getBuckets();
                } else { // end a cow
                    currentBucketsUsed -= cows[currentCow].getBuckets();
                }
            }
            mostBucketsUsed = Math.max(currentBucketsUsed, mostBucketsUsed);
        }

        pw.println(mostBucketsUsed);

        

        pw.flush();
        pw.close();
    }

    public static int findCurrentAction(Cow[] cows, int time) {
        for (int i = 0; i < cows.length; i++) {
            if (cows[i].getValid()) {
                if (cows[i].getStart() == time || cows[i].getEnd() == time) {
                    return i;
                }
            }
        }


        return -1;
    }
}
