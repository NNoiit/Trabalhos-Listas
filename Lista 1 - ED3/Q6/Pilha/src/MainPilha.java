import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String s = "Paula casa comigo?", resp = "";
		char c;
		
		int i = s.length() - 1;
		
		while ( i >= 0 )
		{
			c = s.charAt(i);
			pilha.push(c);
			i--;
		}
		
		resp = Pilha.inverte_palavra(pilha, resp);
		System.out.println(resp);

		scanner.close();
	}
}
