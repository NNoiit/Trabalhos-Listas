package listaDuplamente;

public class ListaDuplamenteGenerica
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	
	protected class Elo<T>
	{
		protected T dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(T elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(T elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public void ListaDuplamente()
	{
		prim = null;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no in�cio da lista. */
	public <T> void insere(T novo)
	{
		Elo p;
		
		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;
	}
	
	/* M�todo auxiliar para busca. */
	private <T> Elo busca(T elem)
	{
		Elo p = null;
		
		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public <T> boolean remove(T elem)
	{
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim) 
			prim = prim.prox;
		else 
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se � ultimo elemento */  
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
	public void imprimeReversa()
	{
		Elo p;
		Elo ult = null;
		
		System.out.println("Elementos da lista em ordem reversa:");
		
		p = prim;
		
		while(p != null)
		{
			ult = p;
			p = p.prox;
		}
		
		for(p = ult; p != null; p = p.ant)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Resolu��o da quest�o 4 da lista auxiliar de Lista Encadeada. */
	public static ListaDuplamenteGenerica concatena(ListaDuplamenteGenerica l1, ListaDuplamenteGenerica l2)
	{
		Elo p;
		
		/* Verifica se a lista l1 � vazia. */
		if(l1.prim == null)
		{
			l1.prim = l2.prim;
		}
		else
		{
			/* Primeiramente, precisamos obter o �ltimo elo da lista l1. */
			for(p = l1.prim; p.prox != null; p = p.prox);

			/* Faz o "prox" do �ltimo elemento da lista l1, apontado por "p",
			 * apontar para o "prim" da lista l2. */
			p.prox = l2.prim;
			
			/* Faz o "ant" do "prim" da lista l2 apontar para o �ltimo elemento da
			 * lista l1, apontado por "p". */
			l2.prim.ant = p;
		}
		
		/* Nesse ponto, os elementos de l2 j� est�o encadeados ao final de l1,
		 * como desejado. Assim, vamos deixar a lista l2 vazia. */
		l2.prim = null;
		
		return l1;
	}

	
}