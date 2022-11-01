package filaCircularSimples;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		TesteFilaSimples fila = new TesteFilaSimples(5);
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
				System.out.println("Entre com o item para adicionar: ");
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
				System.out.println("Conteúdo da fila:");
				fila.imprime();
				break;        
			}
			
		}while(escolha != 0);
	
		scanner.close();
	}
}
