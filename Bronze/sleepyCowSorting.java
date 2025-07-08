import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepyCowSorting {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("sleepy.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("sleepy.out"));

        int num = Integer.parseInt(st.nextToken());
        int[] nums = new int[num];
        st = new StringTokenizer(qwerty.readLine());
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int previous = Integer.MAX_VALUE;
        int sequence = 0;
        for (int i = num -1; i >=0; i--) {
            int current = nums[i];
            if (current < previous) {
                sequence++;
            } else {
                break;
            }
            previous = current;
        }

        pw.println(num - sequence);

        pw.flush();
        pw.close();
    }
}
