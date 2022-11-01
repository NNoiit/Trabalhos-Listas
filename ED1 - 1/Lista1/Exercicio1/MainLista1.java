package Exercicio1;

import java.util.Scanner;

public class MainLista1
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(20);
		Pilha pilhaComp = new Pilha(20);

        String xCy, resposta = "";
		char c = '\0';
		int i = 0;
		
		System.out.println("Verifique se uma frase esta na forma xCy: ");
		xCy = scanner.nextLine();

		//Formando a pilha de referencia
		while ( i < xCy.length() )
		{
			c = xCy.charAt(i);
			pilha.push(c);
			i++;
		}

		//Formando a pihha comparador
		
		while(c !='C'){
			c = pilha.pop();
			if(c!='C'){
			pilhaComp.push(c);
			}
		}

		//Conferindo se a pilha de referencia e a pilha comparador são xCy
		resposta = Pilha.FormaxCy(pilha, pilhaComp, resposta);

		//R: true or false
		System.out.println(resposta);

		scanner.close();
	}



}