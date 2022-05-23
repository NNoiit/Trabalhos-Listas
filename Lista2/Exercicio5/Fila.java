package Exercicio5;

public class Fila {
    /* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected String[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam) {
		tamanho = tam;
		vetor = new String[tamanho];
		ini = 0;
		n = 0;
	}
	
	public boolean vazia() {
		return (n == 0);
	}
	
	public boolean cheia() {
		return (n == tamanho);
	}
	
	//Retiramos o elemento do início da fila
	public String remove() {
		String elemento = "";
		
		if (!this.vazia()) {
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho; //indice na fila circular
			n--;
		} 

		return elemento;
	}    
        
        //Inserimos o elemento no final da fila
	public boolean insere(String elemento) {
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho; //a primeira posicao vaga
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}
    //imprimir
    public void imprime() {
        int i, j;
        
        if (vazia()) {
                System.out.println("Fila está vazia.");
            } else {
                for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
                    System.out.println(j+ " " + vetor[i]);
                }
        }
}
	