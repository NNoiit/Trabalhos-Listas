package Exercicio3;

import java.util.Scanner;


public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada1, entrada2;

        //pegando o que por nas pilhas
        System.out.println("Digite a primeira pilha: ");
        entrada1 = scanner.next();
        System.out.println("Digite a segunda pilha: ");
        entrada2 = scanner.next();

        Pilha.arrayPilhas(entrada1, entrada2);    
        
        scanner.close();
    }
    
    
}