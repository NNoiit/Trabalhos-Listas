package Exercicio3;

import java.util.Arrays;

public class Pilha
{
	private int n;
	private char vetor[];
	private int topo;
	
	public Pilha()
	{
		n = 10;
		vetor = new char[n];
		topo = -1;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
		topo = -1;
	}
	
	public boolean vazia()
	{
		return topo == -1 ? true : false;
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public char pop()
	{
		char c = '\0';
		
		if (!this.vazia())
		{
			c = vetor[topo];
			
			topo--;
		}
		
		return c;
	}
	
	public boolean push(char elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			return true;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push n�o funcionou.\n");
			return false;
		}
	}
	
	public char retornaTopo()
	{
		char elemento = '\0';

		if(!this.vazia())
		{
			elemento = vetor[topo];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}

	//Exercicio3
	public static void arrayPilhas(String entrada1, String entrada2) {

        int tamanhoVetor = entrada1.length() + entrada2.length();
		char array[] = new char[tamanhoVetor];
        Pilha pilha1 = new Pilha(entrada1.length());
		Pilha pilha2 = new Pilha(entrada2.length());
		char c;
		tamanhoVetor = 0;

		//Pondo as entradas nas pilhas
        for (int x = 0; x < entrada1.length(); x++){
            //primeira pilha
            c = entrada1.charAt(x);
            pilha1.push(c);
            //segunda pilha
            c = entrada2.charAt(x);
            pilha2.push(c);
        }

        //Adicionando ambas ass pilhas no vetor
        while (!pilha1.vazia()){
            c = pilha1.pop();
            array[tamanhoVetor] = c;
            tamanhoVetor++;
        }
        while (!pilha2.vazia()){
            c = pilha2.pop();
            array[tamanhoVetor] = c;
            tamanhoVetor++;
        }
        
        //imprime
        System.out.println(Arrays.toString(array));
    }
}