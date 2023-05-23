package listaDuplamente;

public class ListaDuplamente
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected int dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(int elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no in�cio da lista. */
	public void insere(int novo)
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
	private Elo busca(int elem)
	{
		Elo p = null;
		
		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
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
	public static ListaDuplamente concatena(ListaDuplamente l1, ListaDuplamente l2)
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

	// Exercicio 2 - Complexidade O(n*m)
	public ListaDuplamente intersecao(ListaDuplamente l1, ListaDuplamente l2){
		ListaDuplamente l3 = new ListaCircularDuplamente();

		Elo p1 = l1.prim,  p2 = l2.prim;

		while(p1 !=  null){

			if(p1.dado == p2.dado){
				l3.insere(p2.dado);
				if(p2.prox != null){
					p2 = p2.prox;
				} else {
					p2 = l2.prim;
				}
			}

			p1 = p1.prox;

		}

		return l3;
	}

	//Exercicio 4 - Complexidade O(n)
	public void trocaElos(int indiceElo1, int indiceElo2) {
		Elo elo1 = obterEloPorIndice(indiceElo1);
		Elo elo2 = obterEloPorIndice(indiceElo2);
	
		if (elo1 == null || elo2 == null) {
			return;
		}
	
		if (elo1 == elo2) {
			return;
		}
	
		
		if (elo1.ant != null) {
			elo1.ant.prox = elo2;
		} else {
			prim = elo2;
		}
		if (elo1.prox != null) {
			elo1.prox.ant = elo2;
		}
	
		
		if (elo2.ant != null) {
			elo2.ant.prox = elo1;
		} else {
			prim = elo1;
		}
		if (elo2.prox != null) {
			elo2.prox.ant = elo1;
		}
	
		
		Elo temp = elo1.ant;
		elo1.ant = elo2.ant;
		elo2.ant = temp;
	
		temp = elo1.prox;
		elo1.prox = elo2.prox;
		elo2.prox = temp;
	}
	

	private Elo obterEloPorIndice(int indice) {
		Elo elo = prim;
		int i = 0;
	
		while (elo != null && i < indice) {
			elo = elo.prox;
			i++;
		}
	
		return elo;
	}
	
	//Exercicio 5 - Complexidade O(n)
	public boolean verificaIgualdade(ListaDuplamente lista2) {
		return verificaIgualdadeRecursiva(prim, lista2.prim);
	}
	
	private boolean verificaIgualdadeRecursiva(Elo elo1, Elo elo2) {

		if (elo1 == null && elo2 == null) {
			return true;
		}
		
		if (elo1 == null || elo2 == null) {
			return false;
		}
		return (elo1.dado == elo2.dado) && verificaIgualdadeRecursiva(elo1.prox, elo2.prox);
	}

	
	
}