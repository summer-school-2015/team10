package team10;

import com.sun.deploy.util.SystemUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by User on 03/06/2015.
 */
public class Stringsss {
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
            int charL = 0, i, k = 0;
            String [] linesAsArray = lines.toArray(new String[lines.size()]);
            for(i = 0; i < j; i++) {
                StringTokenizer st = new StringTokenizer(linesAsArray[i]);
                k += st.countTokens();
            }
            for(i = 0; i < j; i++){
               charL += linesAsArray[i].length();

            }
            System.out.println("chars " + charL);
            System.out.println("\n strings " + j);
            System.out.println("\n words " + k);
        }catch(IOException e) {
            System.out.println("IOException" + e);
        }catch(OutOfMemoryError e){
            System.out.println("OutOfMemoryError");
        }catch(SecurityException e){
            System.out.println("SecurityException");
         }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("ArrayIndexOutOfBoundsException");
        }/*catch(FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }*/

    }

}
