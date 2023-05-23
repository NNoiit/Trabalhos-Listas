package listaSingular;

import java.text.Collator;
import java.util.Locale;

public class ListaOrdenadaGenerica
{
	protected Elo prim;
	
	protected class Elo<T>
	{
		protected T dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(T elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(T elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public ListaOrdenadaGenerica()
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

		Elo p = new Elo(novo);

		if(prim == null){
			p.prox = prim;
			prim = p;
		} else{
			OrdenaNomes(p);
		}

	}
	
	/* Verifica se um determinado elemento est� na lista. */
	public <T> boolean busca(T elem)
	{
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado == elem)
				return true;
		}
		
		return false;
	}
	
	/* Implementa��o recursiva do m�todo de busca. */
	public <T> boolean buscaRecursiva(T elem)
	{
		if(this.vazia())
			return false;
		
		return buscaRecursiva(elem, prim);
	}
	
	private <T> boolean buscaRecursiva(T elem, Elo p)
	{
		if(p == null)
			return false;
		
		if(p.dado == elem)
			return true;
		
		return buscaRecursiva(elem, p.prox);
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public <T> boolean remove(T elem)
	{
		Elo p;
		Elo ant = null; /* Refer�ncia para anterior. */
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;
		
		/* Se p � null, ent�o n�o encontrou elemento. */
		if (p == null)
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
	
	/* Implementa��o recursiva da fun��o de impress�o. */
	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		if(p == null)
			return;
		
		System.out.print(p.dado + " ");
		
		imprimeRecursivo(p.prox);
	}
	
	public int tamanho()
	{
		int tam = 0;
		Elo p = prim;
		
		while(p != null)
		{
			tam++;
			p = p.prox;
		}
		
		return tam;
	}

	public void OrdenaNomes(Elo p){

		Elo listAtual = prim;
		boolean adicionado = false;

		Collator collator = Collator.getInstance(new Locale("pt", "BR"));

		while(listAtual != null){

			int nomeOrdem = collator.compare(p.dado, listAtual.dado);

			if(nomeOrdem > 0){
				if(listAtual.prox == null){
					listAtual.prox = p;
					prim = listAtual;
				} else{
					p.prox = listAtual.prox;
					listAtual.prox = p;
					prim = listAtual;
				}
				
				adicionado = true;
			}

			listAtual = listAtual.prox;
		}

		//metodo para inserir na frete
		if(adicionado != true){
			p.prox = prim;
			prim = p;
		}
	}
}