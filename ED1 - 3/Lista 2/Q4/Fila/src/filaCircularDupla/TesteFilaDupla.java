package filaCircularDupla;

import java.util.Scanner;

public class TesteFilaDupla extends FilaDupla
{
	public TesteFilaDupla(int tam)
	{
		super(tam);
	}
	
	public void imprime()
	{
		int i, j;
		
		if(vazia())
			System.out.println("Fila est� vazia");
		else
			for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.println(j + " " + vetor[i]);
	}
	
	public int menu()
	{
		Scanner scanner = new Scanner(System.in);
		int escolha;
		
		System.out.println("--------------------------");
		System.out.println("Selecione a opcao:");
		System.out.println("1. Insere elemento no fim da fila.");
		System.out.println("2. Remove elemento do in�cio da fila.");
		System.out.println("3. Insere elemento no in�cio da fila.");
		System.out.println("4. Remove elemento do fim da fila.");  
		System.out.println("5. Imprime elementos a partir do in�cio da fila.");
		System.out.println("0. Fim.");
		System.out.println("Opcao: ");
		escolha = scanner.nextInt();
		scanner.close();
		return escolha;
	}
}
