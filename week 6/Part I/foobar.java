import java.util.Scanner;

class fooBar{
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();
		if(number % 2 == 0) {
			System.out.printf("foo " + "|" + " целое число которое было дано: %d", number);
			System.out.println();
		}
		else {
			System.out.printf("bar " + "|" + " целое число которое было дано: %d", number);
			System.out.println();
		}
	}
}
