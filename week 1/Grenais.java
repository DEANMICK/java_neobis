import java.io.IOException;
import java.util.Scanner;

public class Grenais {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int inter = 0, gremio = 0, empates = 0;
        int total = 0;
        int p = 1;
        do {
            if (p == 1) {
                total++;
                int i = scanner.nextInt();
                int g = scanner.nextInt();
                if (i > g) {
                    inter++;
                } else if (g > i) {
                    gremio++;
                } else {
                    empates++;
                }
            }
            System.out.println("Novo grenal (1-sim 2-nao)");
            p = scanner.nextInt();
        } while (p != 2);
        System.out.println(total + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + empates);
        if (inter > gremio) {
            System.out.println("Inter venceu mais");
        } else if (inter < gremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}