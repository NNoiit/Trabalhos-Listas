import java.util.Scanner;

public class MainPilha
{
	public static <T> void main(String args[])
	{

		Scanner scanner = new Scanner(System.in);

		PilhaGenerica<Integer> pilha = new PilhaGenerica<>(20);
		Integer remove = 3, objetos = 1;
		int i = 0;

		while(i < 10){
			pilha.push(objetos);
			objetos++;
			i++;
		}


		
		//Removendo um item da pilha
        System.out.println(PilhaGenerica.retira_elem(pilha, remove));
		
		scanner.close();
	}
}
