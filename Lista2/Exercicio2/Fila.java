package Exercicio2;

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
                

    //Exercicio2
	public void combinaFilas(Fila f1, Fila f2) {
            
            Fila FilaMista = new Fila(f1.tamanho + f2.tamanho);

            //Adicionando a fila mista
            while(!f1.vazia() || !f2.vazia()) {
                if (FilaMista.cheia()) {
                    System.out.println("A fila está cheia");
                    break;
		        }
                if(!f1.vazia()){ 
                    FilaMista.insere(f1.remove());
                } 
                if(!f2.vazia()){ 
                    FilaMista.insere(f2.remove());
                }
            }
            
            //imprime resultado 
            int i;
            if (FilaMista.vazia()) {
		    System.out.println("Fila está vazia.");
            
            } else {
                System.out.print("Fila Mista: "); 
                for( i = FilaMista.ini; i < FilaMista.n; i++){
                    if(i == FilaMista.n-1){
                        System.out.print(FilaMista.vetor[i]);
                    }else{
                        System.out.print(FilaMista.vetor[i]+", ");
                    }
                }
            }
	}       
}
	