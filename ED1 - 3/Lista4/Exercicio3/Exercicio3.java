package Exercicio3;

import java.util.Scanner;

public class Exercicio3 { 
    /*
    A complexidade da questão é O(n), já que o metodo insere na ListaGenericaOrdenada
    tem dois ocndicionais que nao adicionam complexidade e um loop O(n).
    */
    public static void main(String[] args) {	
	int escolha;                               
	ListaGenericaOrdenada<String> lista = new ListaGenericaOrdenada<>();
	
        lista.insere("Aline");
        lista.insere("Barbara");
        lista.insere("Cris");
        lista.insere("Dio");
        lista.insere("Mari");
        lista.insere("Puala");
        lista.insere("Zoe");
        
        lista.imprime();
                    
        
    }
}
