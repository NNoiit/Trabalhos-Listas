package filaCircularSimples;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		TesteFilaSimples fila_adultos = new TesteFilaSimples(10);
		TesteFilaSimples fila_idosos = new TesteFilaSimples(10);
		Scanner scanner = new Scanner(System.in);
		int escolha, item, i = 0, a = 0;
		char idoso;
		
		do
		{
			escolha = fila_adultos.menu();
			
			switch(escolha) {
			case 0:
				//N�o faz nada
				break;
			case 1:
				System.out.println("A pessoa é idosa? Y/N");
				idoso = scanner.next();
				if(idoso = 'Y'){
					if ( ! fila_idosos.insere(i) )
					System.out.println("Fila cheia.");
					i++;
				} else {
					if ( ! fila_adultos.insere(a) )
					System.out.println("Fila cheia.");
					a++;
				}
				break;
			case 2:
				if(!fila_idosos.vazia()){
					item = fila_idosos.remove();
					i--;	
				} else {
					item = fila_adultos.remove();
					a--;
				}

				if (item != Integer.MIN_VALUE)
					System.out.println("Item " + item + " removido.");
				else
					System.out.println("Fila vazia.");
				break;

			case 3:
				System.out.println("Conte�do da fila:");
				fila.imprime();
				break;        
			}
			
		}while(escolha != 0);
	
		scanner.close();
	}
}
