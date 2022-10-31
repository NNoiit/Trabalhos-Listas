import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha = new Pilha(20);
		String s = "[abcde{efg]}";
		char c;
				
		int i = s.length()-1;
		
		while ( i >= 0 )
		{
			c = s.charAt(i);
			pilha.push(c);
			i--;
		}

		if(Pilha.verifica_balanceamento(pilha)){
			System.out.println("Balanceado");
		} else {
			System.out.println("Não balanceado");
		}
		
		scanner.close();
	}
}
