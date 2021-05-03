import java.io.IOException;
import java.util.Scanner;

public class PopulationIncrease {
 
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
		
		int voice = scanner.nextInt();
		
		for(int i = 0; i < voice; i++) {
			int cityA = scanner.nextInt();
			int cityB = scanner.nextInt();
			double popA = scanner.nextDouble();
			double popB = scanner.nextDouble();
			int counter = 0;
			
			while(cityA <= cityB) {
				cityA += (int) ((cityA * popA) / 100);
				cityB += (int) ((cityB * popB) / 100);
				counter++;
			}
			
			if(counter > 100) {
				System.out.println("Mais de 1 seculo.");
			}else {
				System.out.println(counter + " anos.");
			}
		}
    }
}