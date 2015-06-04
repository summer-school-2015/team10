package team10;

/**
 * Created by User on 04/06/2015.
 */
public class Rect extends figure {
    double A, B;
    double Square;
    String Typef;
    Rect(double a, double b){
        A = a;
        B = b;
        Typef = "RECT";
    }
    public double square(){
       return Square = A * B;
    }
    public String type(){
        return  Typef;
    }
}
