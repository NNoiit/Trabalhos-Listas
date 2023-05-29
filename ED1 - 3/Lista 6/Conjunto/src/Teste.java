public class Teste {

	public static void main(String args[])
	{
		//Questão 3 - Complexidade O(n+m)
		ConjGenerico c1, c2, c3;
		
		c1 = new ConjGenerico();
		c2 = new ConjGenerico();

		c1.insere(1);
		c1.insere(2);
		c1.insere(3);
		c1.insere(4);
		c1.insere(5);
		c1.insere(6);
		c1.insere(7);
		c1.insere(8);
		c1.insere(9);

		c2.insere(3);
		c2.insere(6);
		c2.insere(9);
		
		c3 = c2.complementar(c1);
		c3.imprime();
	}
}