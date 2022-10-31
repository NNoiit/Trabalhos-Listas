package Exercicio8;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int numN;


        //input de entrada
        System.out.println("Digite o tamanho N da sequência: ");
        numN = scan.nextInt();
        
        //imprime pilha
        System.out.println("Pares únicos: ");
        PilhaGenerica.ParesUnicos(numN);
        
        scan.close();
    }
    
}
