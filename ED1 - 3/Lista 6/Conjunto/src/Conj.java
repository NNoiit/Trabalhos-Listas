public class Conj
{
	private Elo prim;  /* Refer�ncia para primeiro elemento. */

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo
	{                 
		int dado;
		Elo prox;

		public Elo()
		{ 
			prox = null;
		}

		public Elo(int elem)
		{
			dado = elem;
			prox = null;
		}

		public Elo(int elem, Elo proxElem)
		{ 
			dado = elem;
			prox = proxElem;
		}
	}

	/* Construtor que cria um conjunto vazio. */
	public Conj()
	{
		prim = null;
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	private void copia(Conj conj2)
	{
		Elo ult = null, q;

		prim = null;
		
		for (Elo p = conj2.prim; p != null; p = p.prox)
		{
			q = new Elo(p.dado);
			
			if (ult == null)
				prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	public void apaga()
	{
		for (Elo p = prim; p != null; p = prim)
		{
			prim = prim.prox;
			p.prox = null;
		}
	}

	/* Simula uma sobrecarga do operador de atribui��o. */
	public Conj atribui(Conj conj2){
		if (this != conj2)
		{
			apaga();
			copia(conj2);
		}
		
		return this;
	}

	/* Testa se o conjunto est� vazio. */
	public boolean vazio()
	{
		return prim == null;
	}

	/* Teste de pertin�ncia. Usa fato de estar ordenado. */
	public boolean pertence(int valor)
	{
		Elo p;
		
		for (p = prim; ((p != null) && (p.dado < valor)); p = p.prox);

		if ((p == null) || (p.dado > valor)) return false;	  

		return true;
	}

	/* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento j� estava l�. */
	public boolean insere(int valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado == valor) return false;
			if (p.dado > valor) break;
			
			ant = p;
		}
		
		Elo q = new Elo(valor);
		
		if (p == prim) 
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
		
		return true;
	}

	/* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento n�o estava l�. */
	public boolean remove(int valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado > valor) return false;
			if (p.dado == valor) break;	 
			
			ant = p;
		}
		
		if (p == null)
			return false;
		
		if (p == prim) 
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		
		return true;
	}

	/* M�todo para uni�o de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a uni�o. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public Conj uniao(Conj conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		Conj uniao = new Conj(); 
		
		while ( (p1 != null) || (p2 != null) )
		{
			if ( (p1 != null) && ( (p2 == null) || (p1.dado < p2.dado)))
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
			}
			else
			{
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado == p2.dado))
					p1 = p1.prox;
				p2 = p2.prox;
			} 

			if (ult == null) 
				uniao.prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
		
		return uniao;
	}

	/* M�todo para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public Conj intersecao(Conj conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		Conj inter = new Conj();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado < p2.dado)
			{
				p1 = p1.prox;
			}
			else if(p2.dado < p1.dado)
			{
				p2 = p2.prox;
			}
			else
			{
				q = new Elo(p1.dado);
				
				p1 = p1.prox;
				p2 = p2.prox;
				
				if (ult == null) 
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}

		return inter;
	}

	/* Retorna cardinalidade do conjunto */
	public int tamanho()
	{
		int tam = 0;
		Elo p;

		for(p = prim; p != null; p = p.prox)
			tam++;
		
		return tam;
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos do conjunto");
		
		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		
		System.out.println();
	}

	//Questão 2 - Complexidade O(n)
	public boolean eIgual(ConjGenerico<T> conj2){

		ConjGenerico<T> conjuntoCorrente = this;

		return comparaConjuntos(conj2.prim, conjuntoCorrente.prim);
	}

	public boolean comparaConjuntos(Elo conjC1, Elo conjC2){

		if(conjC2 == null && conjC2 == null){
			return true;
		}

		if(conjC1 != null && conjC2 == null || conjC1 == null && conjC2 != null){
			return false;
		}

		return (conjC1.dado == conjC2.dado) && comparaConjuntos(conjC1.prox, conjC2.prox);
	}

	//Questão 3 - Complexidade
	public ConjGenerico<T> complementar(ConjGenerico<T> universo){
		ConjGenerico<T> conjuntoCorrente = this;
		
		if(estacontidoUniverso(universo.prim, conjuntoCorrente.prim, conjuntoCorrente.prim)){
			return ConjGenerico<T> conjuntoComplemento = conjuntoComplemento(universo.prim, conjuntoCorrente.prim);
		}

	}

	public boolean estacontidoUniverso(Elo universo, Elo conjuntoCorrente, Elo referecia){
		
		if(universo.dado == conjuntoCorrente.dado){
			return (universo.dado == conjuntoCorrente.dado) && estacontidoUniverso(universo.prox, conjuntoCorrente.prox, referecia);
		} else if(universo.dado != conjuntoCorrente.dado){
			return f(universo.dado != conjuntoCorrente.dado) && estacontidoUniverso(universo, conjuntoCorrente.prox, referecia);
		} else if(conjuntoCorrente.prox == null){
			return (conjuntoCorrente.prox == null) && estacontidoUniverso(universo.prox, referecia, referecia);
		}
		
	}
	public ConjGenerico<T> conjuntoComplemento(Elo conjU, Elo conjCo, ConjGenerico<T> conjuntoComplemento){

		if(conjU == null && conjCo == null){
			return ConjGenerico<T> conjuntoComplemento;
		}
		
		if(conjU.dado != conjCo.dado){
			conjuntoComplemento.insere(conjU.dado);
			conjuntoComplemento(conjU.prox,conjCo.prox)
		} else {
			return conjuntoComplemento(conjU.prox,conjCo.prox);
		}
	}
}