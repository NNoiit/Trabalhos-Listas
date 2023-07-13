import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
		/*/ Questão 1
        Arvbin<Integer> arvore = new Arvbin<>(5);
        arvore.defineEsq(new Arvbin<>(3, new Arvbin<>(2), new Arvbin<>(4)));
        arvore.defineDir(new Arvbin<>(8, new Arvbin<>(7), new Arvbin<>(9)));

        // Testando os métodos de impressão
        System.out.println("Impressão em Pré-ordem:");
        arvore.imprimePreOrdem();

        System.out.println("\nImpressão em Pós-ordem:");
        arvore.imprimePosOrdem();

        System.out.println("\nImpressão em Ordem:");
        arvore.imprimeEmOrdem();
		/*/


		/*/Quetão 2
        Arvbin<Integer> arvore = new Arvbin<>(5);
        arvore.defineEsq(new Arvbin<>(3, new Arvbin<>(2), new Arvbin<>(4)));
        arvore.defineDir(new Arvbin<>(8, new Arvbin<>(7), new Arvbin<>(9)));

        
        Arvbin<Integer> no = arvore.getEsq();
        int soma = Arvbin.retornaSomaSubArvore(no);

        System.out.println("Soma da subárvore enraizada em " + no.getInfo() + ": " + soma);
		/*/

		/*/Quetão 3
		Arvbin<Integer> arvore1 = new Arvbin<>(1);
		Arvbin<Integer> no2 = new Arvbin<>(2);
		Arvbin<Integer> no3 = new Arvbin<>(3);
		Arvbin<Integer> no4 = new Arvbin<>(4);

		arvore1.defineEsq(no2);
		arvore1.defineDir(no3);
		no3.defineEsq(no4);

		Arvbin<Integer> arvore2 = new Arvbin<>(1);
		Arvbin<Integer> no5 = new Arvbin<>(5);
		Arvbin<Integer> no6 = new Arvbin<>(6);
		Arvbin<Integer> no7 = new Arvbin<>(7);

		arvore2.defineEsq(no5);
		arvore2.defineDir(no6);
		no5.defineDir(no7);

		// Testando o método eSimilar
		boolean resultado1 = arvore1.eSimilar(arvore2);
		System.out.println("As árvores são similares? " + resultado1);
		/*/

		/*/Questão 4
        Arvbin<Integer> arvore = new Arvbin<>(5,
                new Arvbin<>(3, new Arvbin<>(2), new Arvbin<>(4)),
                new Arvbin<>(7, new Arvbin<>(6), new Arvbin<>(8)));

        System.out.println("Árvore antes da remoção:");
        arvore.mostra();

        arvore = arvore.delete(3);

        System.out.println("\n\nÁrvore após a remoção:");
        arvore.mostra();
		/*/

		/*/Questão 5
        Arvbin<Integer> arvore = new Arvbin<>(4);
        arvore.defineEsq(new Arvbin<>(2));
        arvore.defineDir(new Arvbin<>(6));
        arvore.getEsq().defineEsq(new Arvbin<>(1));
        arvore.getEsq().defineDir(new Arvbin<>(3));
        arvore.getDir().defineEsq(new Arvbin<>(5));
        arvore.getDir().defineDir(new Arvbin<>(7));

        // Impressão da árvore antes de chamar o método tornaRaiz
        System.out.println("Árvore antes de tornar o valor 5 a raiz:");
        arvore.mostra();

        // Chamada do método tornaRaiz para tornar o valor 5 a raiz
        arvore = arvore.tornaRaiz(5);

        // Impressão da árvore após chamar o método tornaRaiz
        System.out.println("\nÁrvore após tornar o valor 5 a raiz:");
        arvore.mostra();
		/*/

		/*/Questão 6
        Arvbin<Integer> raiz = new Arvbin<>(1);
        raiz.defineEsq(new Arvbin<>(2));
        raiz.defineDir(new Arvbin<>(3));
        raiz.retornaEsq().defineEsq(new Arvbin<>(4));
        raiz.retornaEsq().defineDir(new Arvbin<>(5));
        raiz.retornaDir().defineEsq(new Arvbin<>(6));
        raiz.retornaDir().defineDir(new Arvbin<>(7));

        // Teste do método eBalanceada()
        boolean balanceada = raiz.eBalanceada();
		raiz.mostra();
        System.out.println("A árvore é balanceada? " + balanceada);
		/*/
	}

}
