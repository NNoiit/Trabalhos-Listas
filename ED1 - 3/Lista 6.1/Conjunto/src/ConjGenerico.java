public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Refer�ncia para primeiro elemento. */

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo
	{                 
		T dado;
		Elo prox;

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

	/* Construtor que cria um conjunto vazio. */
	public ConjGenerico()
	{
		prim = null;
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	private void copia(ConjGenerico<T> conj2)
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
	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
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
	public boolean pertence(T valor)
	{
		Elo p;
		
		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;	  

		return true;
	}

	/* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento j� estava l�. */
	public boolean insere(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;
			
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
	public boolean remove(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) > 0) return false;
			if (p.dado.compareTo(valor) == 0) break;	 
			
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
	public ConjGenerico<T> uniao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>(); 
		
		while ( (p1 != null) || (p2 != null) )
		{
			if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
			}
			else
			{
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado.compareTo(p2.dado) == 0))
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
	public ConjGenerico<T> intersecao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado.compareTo(p2.dado) < 0)
			{
				p1 = p1.prox;
			}
			else if(p2.dado.compareTo(p1.dado) < 0)
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
	public boolean eIgual(ConjGenerico<T> conj2) {
		Elo p1 = prim;
		Elo p2 = conj2.prim;
	
		while (p1 != null && p2 != null) {
			if (!p1.dado.equals(p2.dado)) {
				return false; 
			}
			p1 = p1.prox;
			p2 = p2.prox;
		}

	
		if (p1 == null && p2 == null) {
			return true;
		}

		return false;
	}

	//Questão 3 - Complexidade O(m*n)
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) {
		ConjGenerico<T> complemento = new ConjGenerico<T>();
	

		for (Elo p = prim; p != null; p = p.prox) {
			if (!universo.pertence(p.dado)) {
				throw new IllegalArgumentException("O conjunto corrente possui elementos fora do conjunto universo.");
			}
		}
	
		for (Elo p = universo.prim; p != null; p = p.prox) {
			if (!pertence(p.dado)) {
				complemento.insere(p.dado);
			}
		}
	
		return complemento;
	}

	//Questão 4 - Complexidade O(m+n)
	public boolean eSubconjunto(ConjGenerico<T> conj2) {
		Elo p1 = this.prim;
		Elo p2 = conj2.prim;
	
		while (p1 != null && p2 != null) {
			if (p1.dado.compareTo(p2.dado) < 0) {
				return false;
			} else if (p1.dado.compareTo(p2.dado) == 0) {
				p1 = p1.prox;
				p2 = p2.prox;
			} else {
				p2 = p2.prox;
			}
		}
	
		return p1 == null;
	}

	//Quetão 5 - Complexidade O(n+m)
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2) {
		ConjGenerico<T> diferenca = new ConjGenerico<>();
		Elo p1 = this.prim;
		Elo p2 = conj2.prim;
	
		while (p1 != null) {
			if (p2 == null || p1.dado.compareTo(p2.dado) < 0) {
				diferenca.insere(p1.dado);
				p1 = p1.prox;
			} else if (p1.dado.compareTo(p2.dado) == 0) {
				p1 = p1.prox;
				p2 = p2.prox;
			} else {
				p2 = p2.prox;
			}
		}
	
		return diferenca;
	}
	
	//Questão 6 - Complexidade O(n)
	public boolean eIgualR(ConjGenerico<T> conj2) {
		return eIgualRecursivo(prim, conj2.prim);
	}
	
	private boolean eIgualRecursivo(Elo p1, Elo p2) {
		if (p1 == null && p2 == null) {
			return true;
		}
	
		if (p1 == null || p2 == null || !p1.dado.equals(p2.dado)) {
			return false;
		}
	
		return eIgualRecursivo(p1.prox, p2.prox);
	}

	//Questão 7 - complexidade O(n)
	public static <T extends Comparable<T>> ConjGenerico<T> aplicaDeMorgan(ConjGenerico<T> universo, ConjGenerico<T> conj1, ConjGenerico<T> conj2) {
		ConjGenerico<T> complementoConj1 = universo.complementar(conj1);
		ConjGenerico<T> complementoConj2 = universo.complementar(conj2);
		ConjGenerico<T> intersecao = complementoConj1.intersecao(complementoConj2);
		return intersecao;
	}
	
	
}