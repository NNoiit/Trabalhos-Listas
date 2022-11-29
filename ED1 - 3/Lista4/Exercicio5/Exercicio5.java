package Exercicio5;

import java.util.Scanner;

public class Exercicio5 {
    /*
    A complexidade da questão é O(n²)
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um texto para ser revertido:");
        String input = scanner.nextLine();
       
        System.out.println("\nFrase revertida na lista:");   
                
        //chama método pra inverter frase e palavras
        Exercicio5.reverteFrase(input);
        scanner.close();
    }
    
    //método para reverter frase: O(n²)
    public static void reverteFrase(String input){
        ListaGenerica<String> lista = new ListaGenerica<>();
        input = new StringBuilder(input).reverse().toString();
        
        String[] palavras = input.split(" ");
        for (String palavra : palavras) {
            for (char ch: palavra.toCharArray()) {
                lista.insere(Character.toString(ch));
            }
        }
        lista.imprime();
        System.exit(0);
    }
}