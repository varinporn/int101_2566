package work03;

public class MyUtil {
    public static double calculateBMI(double weight, double height){
        return weight / (height*height);
    }
    public static double average(int v1, int v2, int v3) {
        return (double) (v1 + v2 + v3) / 3;
    }
}
