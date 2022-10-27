import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{

		Pilha pilha1_q3 = new Pilha(20); 
		Pilha pilha2_q3 = new Pilha(20);

		int i = 0, opc_q3 = 0;

		//entradas de teste
		String s_q3 = chocolate, s2_q3 = puala;
		int tamanho = s_q3.length() + s2_q3.length();

		while (i < s_q3.length())
		{
			c = s_q3.charAt(i);
			pilha1_q3.push(c);
			
			c2 = s2_q3.charAt(i);
			pilha2_q3.push(c);
			i++;
		
		}

		System.out.print(vetor_pilha(pilha1_q3, pilha2_q3, tamanho));
			
	}
}
