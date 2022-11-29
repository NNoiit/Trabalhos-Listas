package Exercicio2;

public class Lista {
	/* Referência para primeiro elemento */
	protected Elo prim;
        int tamanho = 0;
	
	protected class Elo {
		protected int dado;
		protected Elo prox;
		
		public Elo() {
			prox = null;
		}
		
		public Elo(int elem) {
			dado = elem;
			prox = null;
		}
		
		public Elo(int elem, Elo proxElem) {
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista() {
		prim = null;
	}
        
	/* Testa se a lista está vazia. */
	public boolean vazia() {
		return prim == null;
	}
	
	/* Insere elemento no início da lista. */
	public void insere(int novo) {
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
                
                tamanho = tamanho +1;
	}
	
	/* Verifica se um determinado elemento está na lista. */
	public boolean busca(int elem) {
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado == elem)
				return true;
		}
		
		return false;
	}
	
	/* Implementação recursiva do método de busca. */
	public boolean buscaRecursiva(int elem) {
		if(this.vazia())
			return false;
		
		return buscaRecursiva(elem, prim);
	}
	
	private boolean buscaRecursiva(int elem, Elo p) {
		if(p == null)
			return false;
		
		if(p.dado == elem)
			return true;
		
		return buscaRecursiva(elem, p.prox);
	}

	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(int elem) {
                Elo p;
		Elo ant = null; /* Referência para anterior. */
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;
		
		/* Se p é null, então não encontrou elemento. */
		if (p == null)
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do início. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a última referência para o elo a ser removido. Dessa forma,
		 * o Garbage Collector irá liberar essa memória. */
		p = null;
                
                tamanho = tamanho -1;
		
		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime() {
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Implementação recursiva da função de impressão. */
	public void imprimeRecursivo() {
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p) {
		if(p == null)
			return;
		
		System.out.print(p.dado + " ");
		
		imprimeRecursivo(p.prox);
	}
	
        /* Tamanho metodo do professor*/
	public int tamanho() {
		int tam = 0;
		Elo p = prim;
		while(p != null) {
			tam++;
			p = p.prox;
		}
		return tam;
	}
        
	/* Calcula e retorna o tamanho da lista de maneira recursiva. */
	public int tamanhoRecursivo() {
		if(this.vazia())
			return 0;	
		return tamanhoRecursivo(prim);
	}
	
	private int tamanhoRecursivo(Elo p) {
		if(p == null)
			return 0;	
		return 1 + tamanhoRecursivo(p.prox);
	}
	
	//Exercicio2
	public int maxRecursivo() {
		if(this.vazia())
			return 0;
		
		return maxRecursivo(prim);
	}
	
	private int maxRecursivo(Elo p) {
		if(p == null) return Integer.MIN_VALUE;
		
		int maior = maxRecursivo(p.prox);
	
		if(maior < p.dado)

			maior = p.dado; 
		
		return maior;
	}   
    // Exercicio2
    public static ListaOrdenada intercalaListas(Elo lista1, Elo lista2, ListaOrdenada mista) {
		
        if (lista1 == null) return lista2;
        if (lista2 == null) return lista1;

        if (lista1.dado < lista2.dado) {

			mista.insere(lista1.dado);
            intercalaListas(lista1.prox, lista2, mista);

        }
		else {

			mista.insere(lista1.dado);
            intercalaListas(lista1, lista2.proxm, mista);

            }
        }

	return mista;
}