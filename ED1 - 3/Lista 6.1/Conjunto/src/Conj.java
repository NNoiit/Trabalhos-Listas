public class Conj
{
	private Elo prim;  /* Refer�ncia para primeiro elemento. */

	//alteração para o exercicio 1
	private int menor; /* Armazena o menor elemento */
    private int maior; /* Armazena o maior elemento */
	//----------------------------------

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

		//alteração para quesstão 1
		menor = Integer.MAX_VALUE;
        maior = Integer.MIN_VALUE;
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

	//Alterado ara questão 1
	public boolean insere(int valor)
	{
		// Verifica se o elemento já está no conjunto
        if (pertence(valor)) {
            return false;
        }

        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox) {
            if (p.dado == valor)
                return false;
            if (p.dado > valor)
                break;

            ant = p;
        }

        Elo q = new Elo(valor);

        if (p == prim)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;

        // Atualiza o menor e o maior elementos
        if (valor < menor)
            menor = valor;
        if (valor > maior)
            maior = valor;

        return true;
	}

	
	//Alterado para questão 1
	public boolean remove(int valor)
	{
		Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox) {
            if (p.dado > valor)
                return false;
            if (p.dado == valor)
                break;

            ant = p;
        }

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        // Verifica se o menor ou o maior elemento foram removidos
        if (valor == menor) {
            atualizaMenor();
        }
        if (valor == maior) {
            atualizaMaior();
        }

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


	//Questão 1 - Complexidade será O(1) para cada metodo
	/* Atualiza o menor elemento */
    private void atualizaMenor() {
        if (prim == null) {
            menor = Integer.MAX_VALUE;
        } else {
            menor = prim.dado;
        }
    }

    /* Atualiza o maior elemento */
    private void atualizaMaior() {
        Elo p = prim;
        while (p.prox != null) {
            p = p.prox;
        }
        maior = p.dado;
    }

    /* Retorna o menor elemento do conjunto */
    public int getMenor() {
        return menor;
    }

    /* Retorna o maior elemento do conjunto */
    public int getMaior() {
        return maior;
    }
}