import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String pares = "";
		
		int[] array_N = new int[10]; 
		int i = 0;

		while ( i < array_N.length)
		{
			array_N[i] = i;
			i++;
		}
		
		i = 0;

		while ( i < array_N.length)
		{	
			pilha.push(array_N[i]);
			i++;
		}
		
		Pilha.subsequencias(pilha, pares)
		System.out.print("\n");
		
		scanner.close();
	}
}
