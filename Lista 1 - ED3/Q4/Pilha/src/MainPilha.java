import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{

		Scanner scanner = new Scanner(System.in);

		PilhaGenerica<T> pilha = new PilhaGenerica<>(20);
		T entrada, remove;
		
		System.out.println("Digite a pilha: ");
		entrada = scanner.nextLine();
		System.out.println("Digite o caractere a ser removido da pilha: ");
        remove = scanner.next();


		//Removendo um item da pilha
        pilha.retira_elemr(entrada, resul);
		
		scanner.close();
	}
}
