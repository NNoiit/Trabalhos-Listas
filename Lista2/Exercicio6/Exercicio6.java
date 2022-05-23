package Exercicio6;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); 
        System.out.println("Digite um valor para N: ");
        int N = scan.nextInt();
        
        Exercicio6.convBi(N);
        
        scan.close();
    }

    public static void convBi (int N) {
        Fila filaBi = new Fila(N);
        int numBi;

        System.out.println("Representações binárias: "); 
        for (int i = 1; i <= N; i++) {
            numBi = Integer.parseInt(Integer.toBinaryString(i));
            filaBi.insere(numBi);
        }
        filaBi.imprime();
    }
}
