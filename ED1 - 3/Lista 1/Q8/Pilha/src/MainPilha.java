import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String pares = "";
		char c; 
		char[] array_N = new char[10]; 
		int i = 1;

		while ( i < array_N.length)
		{
			array_N[i] = (char)i;
			i++;
		}
		
		i = array_N.length - 1;

		while ( i > 0)
		{	
			c = Integer.toString(array_N[i]).charAt(0);
			pilha.push(c);
			i--;
		}
		
		Pilha.subsequencias(pilha, pares);
		System.out.print("\n");
		
		scanner.close();
	}
}
