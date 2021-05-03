import java.io.IOException;
import java.util.Scanner;

public class LogicalSequence {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x > 1 && x < 20 && y > x && y < 100000) {
            for (int i = 1; i <=y; i++) {
                System.out.print(i);
                if (i % x == 0) {
                    System.out.println("");
                } else {
                    System.out.print(" ");
                }
            }
            if(y % x != 0){
                System.out.println("");
            }
        }
    }
}