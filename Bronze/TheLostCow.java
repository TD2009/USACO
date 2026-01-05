import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheLostCow {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("lostcow.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int currentX = x;
        int target;
        int change = 1;
        int changeBy = 1;
        int distance = 0;
        while (currentX != y) {
            target = x + change;
            if (target > x) {
                changeBy = 1;
            } else {
                changeBy = -1;
            }
            while (currentX != target) {
                currentX += changeBy;
                distance += Math.abs(changeBy);
                if (currentX == y) {
                    break;
                }
            }

            change *= -2;
        }

        pw.println(distance);

        pw.flush();
        pw.close();
    }
}
