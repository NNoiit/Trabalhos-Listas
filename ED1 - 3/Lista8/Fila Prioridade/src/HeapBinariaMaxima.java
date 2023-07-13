import java.util.ArrayList;
import java.util.List;

public class HeapBinariaMaxima<T>
{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho m�ximo do heap. */
	private int[] vetor;          /* Vetor com elementos. */

	/* Constr�i heap vazio. */
	public HeapBinariaMaxima(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new int[tamanho+1];
	}

	/* Constr�i heap a partir de vetor v. */
	public HeapBinariaMaxima(int tamanho, int[] v)
	{
		tam = tamanho;
		vetor = new int[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	/* Testa se a fila de prioridade est� logicamente vazia.
	   Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}
	
	/* Imprime os elementos da heap at� o tamanho m�ximo do vetor, a contar de 1.
	 * Este m�todo � utilizado somente ap�s a aplica��o do Heapsort. */
	public void imprimeTamanho()
	{
		for(int i = 1; i <= tam; i++)
			System.out.print(vetor[i] + " ");
		
		System.out.println();
	}

	/* Busca o maior item na fila de prioridades.
	   Retorna o maior item em itemMin e true, ou falso se a heap estiver vazia. */
	public int max()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MIN_VALUE;
		}

		return vetor[1];
	}

	/* Remove o maior item da lista de prioridades e coloca ele em itemMax. */
	public int removeMax()
	{
		int itemMax;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MIN_VALUE;
		}

		itemMax = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMax;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		/* As posi��es n at� a posi��o (n / 2) + 1 j� constituem uma heap,
		 * pois s�o folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho � o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se � maior que o filho esquerdo. */
				if(vetor[ filhoDir ] > vetor[ filhoEsq ])
					maiorFilho = filhoDir;
			}

			if(vetor[ maiorFilho ] > x)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x > vetor[pos/2])
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	/* Implementa o algoritmo de ordena��o Heapsort. */
	public void heapsort()
	{
		int x;           
		int resta = n;
		int raiz = 1;
		constroiHeap();
		
		while (resta > 1)
		{
			x = vetor[raiz];
			vetor[raiz] = vetor[resta];
			vetor[resta] = x;
			resta--;
			n--;
			refaz(raiz);
		}
	}

	public int getTamanho() {
		return tam;
	}

	public HeapBinariaMaxima(HeapBinariaMinima heapMinima) {
		tam = heapMinima.getTamanho();
		n = tam;
		vetor = new int[tam + 1];
	
		for (int i = 1; i <= tam; i++) {
			vetor[i] = heapMinima.removeMin();
		}
	
		constroiHeap();
	}

	public void transformaHeapMaxima(Arvbin<Integer> arvore) {
		// Obtém o número de elementos na árvore
		int tamanho = arvore.contaNos();

		List<Integer> listaArvore = new ArrayList<>();

		listaArvore = arvore.percorrerArvore(arvore);
		// Cria um vetor temporário para armazenar os elementos da árvore
		int[] elementos = new int[tamanho];

		// Percorre a árvore e armazena os elementos no vetor
		int indice = 0;
		for (int elemento : listaArvore) {
			elementos[indice] = elemento;
			indice++;
		}

		// Cria uma instância de HeapBinariaMaxima com o vetor de elementos
		HeapBinariaMaxima heap = new HeapBinariaMaxima(tamanho, elementos);

		// Transforma o heap em uma Heap Máxima usando o Heapsort
		heap.heapsort();
	}

	public boolean verificaPropriedadeHeap(int[] vetor) {
		int n = vetor.length;
	
		for (int i = 0; i < n; i++) {
			int leftChildIndex = 2 * i + 1;
			int rightChildIndex = 2 * i + 2;
	
			// Verifica se o filho esquerdo existe e é maior que o pai
			if (leftChildIndex < n && vetor[leftChildIndex] > vetor[i]) {
				return false;
			}
	
			// Verifica se o filho direito existe e é maior que o pai
			if (rightChildIndex < n && vetor[rightChildIndex] > vetor[i]) {
				return false;
			}
		}
	
		return true;
	}

	public int remove(int i) {
		if (i < 1 || i > n) {
			System.out.println("Índice inválido!");
			return Integer.MIN_VALUE;
		}
	
		int elementoRemovido = vetor[i]; 
	
		vetor[i] = vetor[n]; 
		n--;
	
		refaz(i); 
	
		return elementoRemovido; 
	}
}