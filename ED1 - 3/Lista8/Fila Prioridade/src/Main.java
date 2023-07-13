
public class Main
{
	public static void main(String args[])
	{
		/*/Q2 - Complexidade O(n long n)
		HeapBinariaMaxima heapMaxima = new HeapBinariaMaxima(6);
		heapMaxima.insere(4);
		heapMaxima.insere(9);
		heapMaxima.insere(2);
		heapMaxima.insere(7);
		heapMaxima.insere(5);
		heapMaxima.insere(1);
		
		heapMaxima.imprime(); 
		
		HeapBinariaMinima heapMinima = new HeapBinariaMinima(heapMaxima);
		
		heapMinima.imprime();
		/*/

		/*/Q3 - Complexidade O(m)

		HeapBinariaMinima heapMinima = new HeapBinariaMinima(5);
		heapMinima.insere(3);
		heapMinima.insere(8);
		heapMinima.insere(5);
		heapMinima.insere(2);
		heapMinima.insere(10);

		heapMinima.imprime();

		HeapBinariaMaxima heapMaxima = new HeapBinariaMaxima(heapMinima);

		heapMaxima.imprime();
		/*/

		/*/Q4 - Complexidade O(n log n)

		Arvbin<Integer> arvore = new Arvbin<Integer>(null, null, null);

		HeapBinariaMaxima heap = new HeapBinariaMaxima<>(null);

		heap.transformaHeapMaxima(arvore);
		/*/

		/*/Q5 - COmplexidade O(n)

		HeapBinariaMaxima heap = new HeapBinariaMaxima<>(null);

		int[] vetTrue = {10, 8, 7, 5, 6, 4};
		boolean isHeapTrue = heap.verificaPropriedadeHeap(vetTrue);
		System.out.println(isHeapTrue);

		int[] vetFalse = {10, 8, 12, 5, 6, 4};
		boolean isHeapFalse = heap.verificaPropriedadeHeap(vetFalse);
		System.out.println(isHeapFalse);
		/*/

		/*/Q6 - COmplexidade O(log n)
		int[] elementos = { 9, 4, 7, 2, 5, 1 };

		HeapBinariaMaxima<Integer> heap = new HeapBinariaMaxima<>(elementos.length, elementos);
		heap.imprime(); 

		int elementoRemovido = heap.remove(3);
		System.out.println("Elemento removido: " + elementoRemovido); 

		heap.imprime(); 
		int novoElemento = 8;
		heap.insere(novoElemento);
		heap.imprime();
		/*/
	}
}