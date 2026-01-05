import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class FencePainting {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("paint.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));

        int[] nums = new int[4];
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(qwerty.readLine());
        nums[2] = Integer.parseInt(st.nextToken());
        nums[3] = Integer.parseInt(st.nextToken());

        // find if NO overlap
        // if only one is inside then Arrays.sort
        if (((nums[0] > nums[2] && nums[0] <= nums[3]) || (nums[1] > nums[2] && nums [1] <= nums[3]))) { // logic: if one or the other are inside another, there is an intersection
            Arrays.sort(nums);
            pw.println(nums[3] - nums[0]);
        } else if ((nums[2] > nums[0] && nums[2] <= nums[1]) || (nums[3] > nums[0] && nums [3] <= nums[1])) {
            Arrays.sort(nums);
            pw.println(nums[3] - nums[0]);   
        } else { // No intersection
            pw.println(Math.abs(nums[1] - nums[0]) + Math.abs(nums[3] - nums[2]));
        }

        pw.flush();
        qwerty.close();
        pw.close();
    }
}
