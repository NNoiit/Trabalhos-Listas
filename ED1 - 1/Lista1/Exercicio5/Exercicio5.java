package Exercicio5;
import java.util.Scanner;

public class Exercicio5
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(20);

        String xCy, resul = "";
        char c = '\0';
        int i = 0;

		
		System.out.println("Verifique se esta balanceada: ");
		xCy = scanner.nextLine();

        //Formando a pilha de referencia
		while ( i < xCy.length() )
		{
			c = xCy.charAt(i);
			pilha.push(c);
			i++;
		}


		//Verificando balanceamento
        resul = pilha.Balanceada(resul);

        System.out.println(resul);
        
		
		scanner.close();
	}



}