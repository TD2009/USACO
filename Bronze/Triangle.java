import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class triangles {
    public static void main(String[] args) throws IOException{
        BufferedReader qwerty = new BufferedReader(new FileReader("triangles.in"));
        StringTokenizer st = new StringTokenizer(qwerty.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));

        int points = Integer.parseInt(st.nextToken());
        int[] x = new int[points];
        int[] y = new int[points];

        for (int i = 0; i < points; i++) {
            st = new StringTokenizer(qwerty.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        double maxArea = Double.MIN_VALUE;
        double area = 0.0;
        for (int i = 0; i < points; i++) {
            for (int g = i + 1; g < points; g++) {
                for (int f = g + 1; f < points; f++) { // loops through all possible combinations
                    Point2D first = new Point(x[i], y[i]);
                    Point2D second = new Point(x[g], y[g]);
                    Point2D third = new Point(x[f], y[f]);
                    
                    // FOR X FORMULA IS: (INLINE1.y - INLINE2.y) * (OTHER.x - INLINE2.x)
                    area = 0.0;

                    if ((first.getX() == second.getX() || first.getX() == third.getX()) && (first.getY() == second.getY() || first.getY() == third.getY())) {
                        //middle = first
                        area = Math.abs(second.getX() - third.getX()) * Math.abs(second.getY() - third.getY());
                    } else if ((second.getX() == first.getX() || second.getX() == third.getX()) && (second.getY() == first.getY() || second.getY() == third.getY())) {
                        //middle = second
                        area = Math.abs(first.getX() - third.getX()) * Math.abs(first.getY() - third.getY());
                    } else if ((third.getX() == second.getX() || first.getX() == third.getX()) && (third.getY() == second.getY() || first.getY() == third.getY())) {
                        //middle = third
                        area = Math.abs(first.getX() - second.getX()) * Math.abs(first.getY() - second.getY());
                    } else {
                        continue;
                    }
                    
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        int answer = (int) maxArea;
        pw.println(answer);


        pw.flush();
        pw.close();
    }
}
