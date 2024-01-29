package set2;

public class ques2 {
    public static void main(String[] args) {
        double startFahren = 0;
        double endFahren = 100;
        double stepSize  =  10;

        for(double i = startFahren;i<=endFahren ; i+=stepSize)
        {
           double celsius = (i-32)*5/9;
            System.out.printf("%-20.2f\t\t%-20.2f",i,celsius);
        }
    }
}
