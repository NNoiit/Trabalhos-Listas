package Exercicio6;
import java.util.Scanner;

public class Exercicio6
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(30);

        String xCy;
        char c = '\0';

		
		System.out.println("Digite uma frase que deseja inverter: ");
		xCy = scanner.nextLine();

		
        //Formando a pilha de referencia
		int i = xCy.length() - 1;

		while ( i !=-1 )
		{
			c = xCy.charAt(i);
			pilha.push(c);
			i--;
		}

		pilha.Inversor();
		//Verificando invertendo
		scanner.close();
	}
}