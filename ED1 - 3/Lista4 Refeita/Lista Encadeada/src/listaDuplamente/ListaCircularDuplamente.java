package listaDuplamente;

public class ListaCircularDuplamente extends ListaDuplamente
{
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista:");
		
		if(prim == null)
			return;
		
		p = prim;

		do
		{
			System.out.print(p.dado + " ");
			p = p.prox;

		} while (p != prim);
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
	public void imprimeReversa()
	{
		Elo p;
		System.out.println("Elementos da lista em ordem reversa:");
		
		if(prim == null)
			return;
		
		p = prim.ant;

		do
		{
			System.out.print(p.dado + ' ');
			p = p.ant;

		} while (p != prim.ant);
		
		System.out.println();
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;

		if (prim == null) return false;

		/* Percorre a lista para encontrar o elo que cont�m o dado igual a "elem". */
		
		p = prim;
		
		do
		{
			if(p.dado == elem)
				break;
			
			p = p.prox;

		} while (p != prim);

		/* Achou */
		if (p.dado == elem )
		{
			/* � o primeiro */     
			if (p == prim)
			{
				/* � o �nico */
				if (prim == prim.prox)
				{
					prim = null;  
				}
				else 
				{
					p.ant.prox = p.prox; 
					prim = prim.prox; 
					p.prox.ant = p.ant;
				}     
			}   
			else
			{
				/* No meio */
				p.ant.prox = p.prox;
				p.prox.ant = p.ant;
			}

			/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
			 * o Garbage Collector ir� liberar essa mem�ria. */
			p = null;
			return true;
		} 
		else
			return false; 
	}
	
	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo q, ult;  
		q = new Elo(novo);
		
		if (prim != null)
		{
			ult = prim.ant;
			ult.prox = q;
			q.ant = ult;
			q.prox = prim;
			prim.ant = q;
		}
		else
		{
			prim = q;
			prim.prox = q;
			prim.ant  = q;
		}
	}
		
	/* Resolu��o da quest�o 4 da lista auxiliar de Lista Encadeada. */
	public static ListaCircularDuplamente concatena(ListaCircularDuplamente l1, 
			ListaCircularDuplamente l2)
	{
		Elo p;
		
		/* Verifica se a lista l1 � vazia. */
		if(l1.prim == null)
		{
			l1.prim = l2.prim;
		}
		else
		{
			/* Primeiramente, precisamos obter o �ltimo elo da lista l1, isto �, 
			 * o elo cujo pr�ximo � o "prim". */
			for(p = l1.prim; p.prox != l1.prim; p = p.prox);

			/* Faz o "prox" do �ltimo elemento da lista l1, apontado por "p",
			 * apontar para o "prim" da lista l2. */
			p.prox = l2.prim;
			
			/* Faz o "ant" do "prim" da lista l2 apontar para o �ltimo elemento da
			 * lista l1, apontado por "p". */
			l2.prim.ant = p;
		}
		
		/* Anda at� o final da "nova" lista. Note que o "prox" do �ltimo elo ainda
		 * continua apontando para "l2.prim". */
		for(p = l1.prim; p.prox != l2.prim; p = p.prox);
		
		/* Agora ajustamos "prox" e "ant" do primeiro e �ltimo elos, 
		 * respectivamente. */
		l1.prim.ant = p;
		p.prox = l1.prim;
		
		/* Nesse ponto, os elementos de l2 j� est�o encadeados ao final de l1,
		 * como desejado. Assim, vamos deixar a lista l2 vazia. */
		l2.prim = null;
		
		return l1;
	}
}