package Exercicio4;

import java.util.Scanner;

public class Exercicio4
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		PilhaGenerica<String> pilha = new PilhaGenerica<>(20);

        String xCy;
        Character resul = '\0';

		
		System.out.println("Digite a pilha: ");
		xCy = scanner.nextLine();
		System.out.println("Digite o caractere a ser removido da pilha: ");
        resul = scanner.next().charAt(0);


		//Removendo um item da pilha
        pilha.Remover(xCy, resul);
		
		scanner.close();
	}



}
