package Exercicio4;

public class Fila {
    /* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam) {
		tamanho = tam;
		vetor = new int[tamanho];
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
	public int remove() {
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia()) {
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho; //indice na fila circular
			n--;
		} 

		return elemento;
	}    
        
        //Inserimos o elemento no final da fila
	public boolean insere(int elemento) {
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
        //Exercicio 4   
    public static FilaDupla filaCircularConverteDupla(Fila filaCircSimples) {
            
        FilaDupla filaDupla = new FilaDupla(filaCircSimples.tamanho);
			
        while(!filaCircSimples.vazia()) {
		    filaDupla.insere(filaCircSimples.remove());
        }
            
        //imprime
        if (filaDupla.vazia()) {
		    System.out.println("Fila está vazia.");
        } 
        else {
            System.out.print("Fila Convertida: \n"); 
                for(int i = filaDupla.ini; i < filaDupla.n; i = (i + 1)){
                    System.out.println(filaDupla.vetor[i]); 
            }
        }
        return filaDupla;
    }    
}