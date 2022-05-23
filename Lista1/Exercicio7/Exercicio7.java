package Exercicio7;

import java.util.Scanner;

public class Exercicio7
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(20);

        String xCy, resul = "";
        char c = '\0';

		
		System.out.println("Calcule a expressao infixa: ");
		xCy = scanner.nextLine();

        //Formando a pilha de referencia
		int i = xCy.length() - 1;

		while ( i !=-1 )
		{
			c = xCy.charAt(i);
			pilha.push(c);
			i--;
		}


		//Verificando balanceamento
        pilha.VerificarPrioridade();

        System.out.println(resul);
        
		
		scanner.close();
	}


}