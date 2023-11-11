package work01;

public class Utilitor {

    public static String testString(String value){
        if (value == null) throw new NullPointerException();
        if (value.isBlank()) throw new IllegalArgumentException();
        else return value;
    }

    public static double testPositive(double value){
        if (value>0) return value;
        else throw new IllegalArgumentException();
    }

    public static long computeIsbn10(long isbn10){
        long digit;
        long sum = 0;
        for (int i = 2; i <= 10; i++){
            digit = isbn10 % 10;
            digit*=i;
            sum += digit;
            isbn10 /= 10;
        }
        long lastDigit = 11-(sum%11);
        return lastDigit;
    }
}
