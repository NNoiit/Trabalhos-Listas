package filaCircularSimples;

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

	//Q3
	public void fila_pilha(Pilha pilhaF){
		FilaGeneriaca<Fila> fila_pilha = new FilaGenerica<>;

		if(!fila_pilha.cheia()){
			fila_pilha.insere(pilhaF);
		}
	}

	public void pilha_fila(Fila filaP){
		PilhaGenerica<Pilha> pilha_fila = new PilhaGenerica<>;

		if(!pilha_fila.cheia()){
			pilha_fila.push(filaP);
		}
	}

	public void fila_fila(Fila filaF){
		FilaGeneriaca<Fila> fila_fila = new FilaGenerica<>;

		if(!fila_pilha.cheia()){
			fila_pilha.insere(filaF);
		}		
	}
}