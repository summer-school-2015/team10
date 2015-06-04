package team10;

/**
 * Created by User on 04/06/2015.
 */
public class Triangle extends figure {
    double P, H;
    double Square;
    String Typef;
    Triangle(double p, double h){
        P = p;
        H = h;
        Typef = "TRIANGLE";
    }
    public double square(){
        return Square = P * H / 2;

    }
    public String type(){
        return  Typef;
    }
}
