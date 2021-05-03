import java.io.IOException;
import java.util.Scanner;

public class TriangleTypes {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        if (a > 0 && b > 0 && c > 0) {
            double[] numbers = sortDecreasing(new double[]{a, b, c});
            a = numbers[0];
            b = numbers[1];
            c = numbers[2];

            if (a >= (b + c)) {
                System.out.println("NAO FORMA TRIANGULO");
            }

            else if ((a * a) == ((b * b) + (c * c))) {
                System.out.println("TRIANGULO RETANGULO");
            }

            else if ((a * a) > ((b * b) + (c * c))) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }

            else if ((a * a) < ((b * b) + (c * c))) {
                System.out.println("TRIANGULO ACUTANGULO");
            }

            if (a == b && b == c  && c==a) {
                System.out.println("TRIANGULO EQUILATERO");
            }

            else if ((a == b && a != c) || (b == c && b != a) || (a == c && a != b)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
    private static double[] sortDecreasing(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
}