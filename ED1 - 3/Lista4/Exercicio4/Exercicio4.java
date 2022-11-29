package Exercicio4;
import java.util.Scanner;

public class Exercicio4 {
    /*
    A complexidade da questão: O(n) 
    fraseToken(n) + remontaFrase(n) + insere(n)
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um texto para ser dividido em tokens:");
        String input = scanner.nextLine();
           
        Exercicio4.fraseToken(input);
        scanner.close();
    }
    
    //método para tokenizar as palavras da frase: O(n)
    public static void fraseToken(String input){
        ListaGenerica<String> lista = new ListaGenerica<>();
        
        String[] tokens = input.split(" ");
        //Mostrar os tokens
        System.out.println("\nOs tokens da frase são:");
        for (String item : tokens) {
            System.out.println(item);
            lista.insere(item);
        }      
        System.out.println("\nFrase inteira na lista:");
        String frase = remontaFrase(lista);
        System.out.println(frase);
        System.exit(0);
    }
    
    //"algoritmo para retornar a frase" inteira-concatenar: O(n)
    public static String remontaFrase (ListaGenerica<String> lista) {
        String frase = "";
        for(ListaGenerica.Elo p = lista.prim; p!= null; p = p.prox){
            frase = frase + p.dado + " ";
        }
        return frase;
    }
}

