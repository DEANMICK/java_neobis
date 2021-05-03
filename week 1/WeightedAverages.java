import java.io.IOException;
import java.util.Scanner;

public class WeightedAverages {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        float value1, value2, value3;
        float average;
        for (int i = 1; i <= N; i++) {
            value1 = input.nextFloat();
            value2 = input.nextFloat();
            value3 = input.nextFloat();
            average = ( value1*2 + value2*3 + value3*5 ) / 10;
            System.out.printf("%.1f\n", average);
        }
    }
}