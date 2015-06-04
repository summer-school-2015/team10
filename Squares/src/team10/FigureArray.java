package team10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by User on 04/06/2015.
 */
public class FigureArray {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
            int j = 0;
            String line = null;
            List<String> lines = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                j++;
            }
            int charL = 0;
            String [] linesAsArray = lines.toArray(new String[lines.size()]);
            int n = Integer.valueOf(linesAsArray[0]);
            figure[] figures;
            figure buf;
            figures = new figure[n];
            for(int i = 0; i < j - 1; i++) {
                StringTokenizer st = new StringTokenizer(linesAsArray[i + 1]);
                String s = st.nextToken();
                if(s.equals("TRIANGLE"))
                    figures[i] = new Triangle(Double.valueOf(st.nextToken()), Double.valueOf(st.nextToken()));

                if (s.equals("RECT"))
                    figures[i] = new Rect(Double.valueOf(st.nextToken()), Double.valueOf(st.nextToken()));
                if(s.equals("CIRCLE"))
                    figures[i] = new Sphere(Double.valueOf(st.nextToken()));
            }
            int i = 0, f = 0;
            for( i = 0; i < n; i++) {
                for ( f = i + 1; f < n - 1; f++) {
                    if (figures[f].square() > figures[f + 1].square()) {
                        buf = figures[f];
                        figures[f] = figures[f + 1];
                        figures[f + 1] = buf;
                    }
                }
            }
            for(i = 0; i < n; i++) {
                System.out.println(figures[i].type() + " " + figures[i].square());
            }
        }catch(IOException e) {
            System.out.println("IOException" + e);
        }catch(OutOfMemoryError e){
            System.out.println("OutOfMemoryError");
        }catch(SecurityException e){
            System.out.println("SecurityException");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }

    }
}
