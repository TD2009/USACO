import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class milkMeasurement {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("measurement.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        
        boolean[] days = new boolean[101];
        String[] names = new String[101];
        int[] values = new int[101];

        HashMap<String, Integer> cows = new HashMap<>();
        cows.put("Bessie", 7);
        cows.put("Mildred", 7);
        cows.put("Elsie", 7);

        int numDays = Integer.parseInt(st.nextToken());
        int index;
        for (int i = 0; i < numDays; i++) {
            st = new StringTokenizer(qwerty.readLine());
            index = Integer.parseInt(st.nextToken());
            days[index] = true;
            names[index] = st.nextToken();
            values[index] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        String highest = ""; String previous = "";
        int changedTimes = 0;
        for (boolean x: days) {
            if (x) {
                cows.put(names[num], cows.get(names[num]) + values[num]);
                previous = highest;
                if (cows.get("Bessie") > cows.get("Mildred") && cows.get("Bessie") >  cows.get("Elsie")) { //Bessie is greatest
                    highest = "B";
                } else if (cows.get("Mildred") > cows.get("Bessie") && cows.get("Mildred") >  cows.get("Elsie")) { //Mildred is greatest
                    highest = "M";
                } else if (cows.get("Elsie") > cows.get("Mildred") && cows.get("Elsie") >  cows.get("Bessie")) { //Elsie is greatest
                    highest = "E";
                } else if (cows.get("Bessie") == cows.get("Mildred") && cows.get("Bessie") != cows.get("Elsie")) { //B = M != E
                    highest = "BM";
                } else if (cows.get("Bessie") == cows.get("Elsie") && cows.get("Bessie") != cows.get("Mildred")) { // B = E != M
                    highest = "BE";
                } else if (cows.get("Elsie") == cows.get("Mildred") && cows.get("Elsie") != cows.get("Bessie")) { // E = M != B
                    highest = "ME";
                } else { // all are equal
                    highest = "BME";
                }

                if (!(previous.equals(highest))) {
                    changedTimes++;
                }
            }
            num++;
        }

        pw.println(changedTimes);

        pw.flush();
        pw.close();
    }

    public static int binarySearch(int[] list, int num) {
        int low = 0;
        int high = list.length;
        while (high - low != 1) {
            if (list[(high + low) / 2] < num) {
                low = (high + low) / 2;
            } else {
                high = (high + low) / 2;
            }
        }
        return low + 1;
    }
}
