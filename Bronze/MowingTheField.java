import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MowingTheField {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("mowing.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));

        int lowest = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        String[] directions = new String[n + 1];
        int[] lengths = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(qwerty.readLine());
            directions[i] = st.nextToken();
            lengths[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] points = new int[2001][2001];
        for (int i = 0; i < 2001; i++) {
            for (int g = 0; g < 2001; g++) {
                points[i][g] = -1;
            }
        }

        points[1000][1000] = 0;

        int currX = 1000;
        int currY = 1000;

        int targetY = 0;
        int targetX = 0;        
        int changeBy = 0;
        int time = 1;
        String m;
        String way = "";
        for (int i = 1; i < directions.length; i++) {
            m = directions[i];
            if(m.equals("N")) {
                targetY = currY + lengths[i];
                way = "Y";
            } else if (m.equals("S")) {
                targetY = currY - lengths[i];
                way = "Y";
            } else if (m.equals("E")) {
                targetX = currX + lengths[i];
                way = "X";
            } else if (m.equals("W")) {
                targetX = currX - lengths[i];
                way = "X";
            }

            if (way.equals("X")) {
                if (currX < targetX) {
                    changeBy = 1;
                } else if (currX > targetX) {
                    changeBy = -1;
                }                

                while (currX != targetX) {
                    currX += changeBy;                    
                    if (points[currX][currY] != -1) {
                        if (time - points[currX][currY] < lowest) {
                            lowest = time - points[currX][currY];
                        }
                    }
                    points[currX][currY] = time;
                    time++;
                }
            } else {
                if (currY < targetY) {
                    changeBy = 1;
                } else {
                    changeBy = -1;
                }

                while (currY != targetY) {
                    currY += changeBy;
                    if (points[currX][currY] != -1) {
                        if (time - points[currX][currY] < lowest) {
                            lowest = time - points[currX][currY];
                        }                    }
                    points[currX][currY] = time;
                    time++;
                }
            }
        }
        if (lowest == Integer.MAX_VALUE) {
            pw.println(-1);
        } else {
            pw.println(lowest);
        }

        pw.flush();
        pw.close();
    }
}
