import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String s, resp = "";
		char c;
				
		System.out.println("Entre com uma frase: ");
		s = scanner.nextLine();
		
		int i = s.length() - 1;
		
		while ( i > 0 )
		{
			c = s.charAt(i);
			pilha.push(c);
			i--;
		}
		
		resp = inverte_palavra(pilha, resp);
		System.out.println(resp);

		scanner.close();
	}
}
