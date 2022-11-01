package filaCircularDupla;

import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		TesteFilaDupla fila = new TesteFilaDupla(5);
		Scanner scanner = new Scanner(System.in);
		int escolha, item;

		do
		{
			escolha = fila.menu();

			switch(escolha) {
			case 0:
				//Não faz nada
				break;
			case 1:
				System.out.println("Entre com o item para adicionar no fim da fila: ");
				item = scanner.nextInt();
				if ( ! fila.insere(item) )
					System.out.println("Fila cheia.");
				break;
			case 2:
				item = fila.remove();
				if (item != Integer.MIN_VALUE)
					System.out.println("Item " + item + " removido.");
				else
					System.out.println("Fila vazia.");
				break;
			case 3:
				System.out.println("Entre com o item para adicionar no início da fila: ");
				item = scanner.nextInt();
				if ( ! fila.insereInicio(item) )
					System.out.println("Fila cheia.");
				break;
			case 4:
				item = fila.removeFim();
				if (item != Integer.MIN_VALUE)
					System.out.println("Item " + item + " removido.");
				else
					System.out.println("Fila vazia.");
				break;
			case 5:
				System.out.println("Conteúdo da fila:");
				fila.imprime();
				break;
			}

		}while(escolha != 0);

		scanner.close();
	}
}