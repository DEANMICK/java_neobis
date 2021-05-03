import java.io.IOException;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
		float input = scanner.nextFloat();
		
		int hun=(int) (input / 100);
		int fif=(int) (input % 100 / 50);
		int twe=(int) (input % 100) % 50 / 20;
		int ten=(int) (input % 100) % 50 % 20 / 10;
		int fiv=(int) (input % 100) % 50 % 20 % 10 / 5;
		int two=(int) (input % 100) % 50 % 20 % 10 % 5 / 2;
		int one=(int) (input % 100) % 50 % 20 % 10 % 5 % 2 / 1;
		int remain = (int) (input * 100);
		remain = remain % 100;
		int half = (int) ((int) (remain / 50));
		int quart = (int) ((int) (remain % 50 / 25));
		int pten = (int) ((int) (remain % 50 % 25 / 10));
		int pfiv = (int) ((int) (remain % 50 % 25 % 10 / 5));
		int pone = (int) ((int) (remain % 50 % 25 % 10 % 5 / 1));
		
		System.out.println("NOTAS:");
		System.out.printf("%d nota(s) de R$ 100.00\n", hun);
		System.out.printf("%d nota(s) de R$ 50.00\n", fif);
		System.out.printf("%d nota(s) de R$ 20.00\n", twe);
		System.out.printf("%d nota(s) de R$ 10.00\n", ten);
		System.out.printf("%d nota(s) de R$ 5.00\n", fiv);
		System.out.printf("%d nota(s) de R$ 2.00\n", two);
		
		
		System.out.println("MOEDAS:");
		System.out.printf("%d moeda(s) de R$ 1.00\n", one);
		System.out.printf("%d moeda(s) de R$ 0.50\n", half);
		System.out.printf("%d moeda(s) de R$ 0.25\n", quart);
		System.out.printf("%d moeda(s) de R$ 0.10\n", pten);
		System.out.printf("%d moeda(s) de R$ 0.05\n", pfiv);
		System.out.printf("%d moeda(s) de R$ 0.01\n", pone);
 
    }
 
}