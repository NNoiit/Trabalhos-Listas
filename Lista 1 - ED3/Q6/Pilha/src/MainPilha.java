import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String s;
		char c;
				
		System.out.println("Entre com uma frase: ");
		s = scanner.nextLine();
		
		int i = 0;
		
		while ( i < s.length() )
		{
			c = s.charAt(i);
			pilha.push(c);
			i++;
		}
		
		System.out.println("Frase invertida: ");
		
		while (!pilha.vazia()) {
			c = pilha.pop();
			System.out.print(c);
		}
		
		System.out.print("\n");
		
		scanner.close();
	}
}
