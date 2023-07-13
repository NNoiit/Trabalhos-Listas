package filaCircularSimples;

import filaCircularDupla.FilaDupla;

public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
		ini = 0;
		n = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	//Retiramos o elemento do in�cio da fila
	public int remove()
	{
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(int elemento)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}

	public static void convert_binari(FilaDupla fila, int N){
		FilaDupla fila_aux = new FilaDupla(N);
		int i = fila.remove(), x = 0;
		int binario = 0;
		do{
			if(i > 0){
				x = i % 2;
				fila.insereInicio(x);
				i = (int) (i*0.5);
			}

			if(i == 1){
				binario += fila_aux.remove();
			}
		}while(!fila_aux.vazia());

		System.out.print(binario + " ");

		if(fila.vazia()){
			convert_binari(fila, N);
		}
	}
}