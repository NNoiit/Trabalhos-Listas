package filaCircularSimples;
import java.util.Scanner;

public class TesteFilaSimples extends Fila
{	
	public TesteFilaSimples(int tam)
	{
		super(tam);
	}
	
	public void imprime()
	{
		int i, j;
		
		if (vazia())
			System.out.println("Fila est� vazia.");
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
		System.out.println("1. Insere elemento na fila.");
		System.out.println("2. Remove elemento da fila.");
		System.out.println("3. Imprime elementos da fila.");
		System.out.println("0. Fim.");
		System.out.print("Opcao: ");
		escolha = scanner.nextInt();
		scanner.close();
		return escolha;
	}
}