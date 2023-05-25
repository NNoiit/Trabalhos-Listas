public class Teste {

	public static void main(String args[])
	{
		Conj c1, c2, c3;
		
		c1 = new Conj();
		c2 = new Conj();

		c1.insere(1);
		c1.insere(3);
		c1.insere(5);
		c1.insere(2);
		c1.insere(4);

		System.out.println("Imprimindo c1");
		c1.imprime();

		c2.insere(4);
		c2.insere(5);
		c2.insere(7);
		c2.insere(6);
		c2.insere(8);
		c2.insere(9);

		System.out.println("Imprimindo c2");
		c2.imprime();

		c2.remove(9);

		System.out.println("Imprimindo c2 apos remocao de 9");
		c2.imprime();

		System.out.println("Imprimindo uniao");
		c3 = c1.uniao(c2);
		c3.imprime();
		
		System.out.println("Imprimindo da intersecao");
		c3 = c1.intersecao(c2);
		c3.imprime();
	}
}