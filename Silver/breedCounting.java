import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class breedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader qwerty = new BufferedReader(new FileReader("bcount.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("bcount.out"));

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(qwerty.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] one = psum(nums, 1);
        int[] two = psum(nums, 2);
        int[] three = psum(nums, 3);

        //for (int x: one) pw.println(x);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(qwerty.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pw.print(one[end] - one[start - 1] + " ");
            pw.print(two[end] - two[start - 1] + " ");
            pw.println(three[end] - three[start - 1]);
        }

        pw.flush();
        pw.close();
    }

    public static int[] psum(int[] nums, int num) {
        int[] psum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) psum[i + 1] += 1;
            psum[i + 1] += psum[i];
        }
        return psum;
    }
}
