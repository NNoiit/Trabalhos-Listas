package Exercicio2;

import java.util.Scanner;

public class Exercicio2
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(20);

        String xCy, resul = "";
		char c;
		int i = 0;
		
		System.out.println("Verifique se uma frase esta na forma xCy continuamente: ");
		xCy = scanner.nextLine();

		//Formando a pilha de referencia
		while ( i < xCy.length() )
		{
			c = xCy.charAt(i);
			pilha.push(c);
			i++;
		}

		//Verificando se esta no etado xCy recorrente
		resul = Pilha.Alfabeto(pilha, resul);

		System.out.println(resul);
		
		scanner.close();
	}



}
