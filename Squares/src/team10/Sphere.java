package team10;


/**
 * Created by User on 04/06/2015.
 */
public class Sphere extends figure {
    double pi, R;
    double Square;
    String Typef;
 Sphere(double r){
     pi = 3.14;
     R = r;
     Typef = "Circle";

 }
    public double square(){
        return Square = pi*R*R;

    }
    public String type(){
        return  Typef;
    }
}
