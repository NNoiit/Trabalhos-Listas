package listaSingular;

public class ListaOrdenada extends Lista
{
	/* Insere elemento na lista na posi��o adequada, mantendo-a ordenada. */
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* refer�ncia para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p � null ou p.dado != elem, ent�o n�o encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
		 * o Garbage Collector ir� liberar essa mem�ria. */
		p = null;
		
		return true;
	}

	//Questão 2 - Complexidade O(n+m), pois ambas as listas serão percoridas
	public static ListaOrdenada intercalaLista(ListaOrdenada l1, ListaOrdenada l2)
	{
		Elo p1, p2;

		p1 = l1.prim;
		p2 = l2.prim;
		ListaOrdenada listaIntercalada = new ListaOrdenada();
		
		while(p1 != null || p2 != null){
		
			if(p1 == null){
				listaIntercalada.insere(p2.dado);
				p2 = p2.prox;

			}else if(p2 == null){
				listaIntercalada.insere(p1.dado);
				p1 = p1.prox;

			}else if(p1.dado < p2.dado){
				listaIntercalada.insere(p1.dado);
				p1 = p1.prox;
				
				
			} else {
				listaIntercalada.insere(p2.dado);
				p2 = p2.prox;
			}
		}
		
		return listaIntercalada;
	}
}