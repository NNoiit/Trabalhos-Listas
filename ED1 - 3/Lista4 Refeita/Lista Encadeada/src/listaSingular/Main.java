package listaSingular;

public class Main
{
	public static void main(String[] args)
	{
		/*/Exercicio 2 - Complexidade O(n+m), pois ambas as listas serão percoridas
		ListaOrdenada lista1 = new ListaOrdenada();
		ListaOrdenada lista2 = new ListaOrdenada();

		lista1.insere(1);
		lista1.insere(3);
		lista1.insere(7);

		lista2.insere(2);
		lista2.insere(4);
		lista2.insere(8);
		lista2.insere(10);

		System.out.println(ListaOrdenada.intercalaLista(lista1, lista2));
		/*/
		

		/*/ Exercicio 3 - Complexidade O(n) pois cada vez que um novo nome for adicionado, a lista sera percorrida

		ListaOrdenadaGenerica listaDeNomes = new ListaOrdenadaGenerica();

		listaDeNomes.insere("Carlos");
		listaDeNomes.insere("Julio");
		listaDeNomes.insere("Dener");
		listaDeNomes.insere("Alice");
	

		listaDeNomes.imprime();
		 /*/

		
		 /*/ Exercicio 4 - Complexidade O(n+m) poiss a impressão e correção da frase ira almentar a complexidade na hora de percorrer a lista 
		ListaNova listaNova= new ListaNova();

        listaNova.insere("Esta");
        listaNova.insere("é");
        listaNova.insere("uma");
        listaNova.insere("frase");
        listaNova.insere("de");
        listaNova.insere("exemplo");

        String frase = listaNova.getFrase();
        System.out.println(frase);
		/*/

		/*/Exercicio 5 
		ListaNova lista = new ListaNova();
		lista.insere("Esta");
		lista.insere("é");
		lista.insere("uma");
		lista.insere("frase");
		lista.insere("de");
		lista.insere("exemplo");

		lista.inverterFrase();

		System.out.println("Frase invertida:");
		lista.imprime();
		/*/

		/*/ Questão 7 - Complexiade metodo inserir é O(n), método localizar é O(n) e a do método efetuarDano é O(n) também.
		
		// Criação dos inimigos
        Inimigo inimigo1 = new Inimigo();
        inimigo1.setVida(100);
        inimigo1.setDanoPorSegundo(10.0);

        Inimigo inimigo2 = new Inimigo();
        inimigo2.setVida(150);
        inimigo2.setDanoPorSegundo(8.0);

        // Criação da lista de inimigos
        ListaInimigos listaInimigos = new ListaInimigos();

        // Inserção dos inimigos na lista
        listaInimigos.inserir(inimigo1);
        listaInimigos.inserir(inimigo2);

        // Localização de um inimigo na lista
        Inimigo inimigoEncontrado = listaInimigos.localizar(inimigo1);
        if (inimigoEncontrado != null) {
            System.out.println("Inimigo encontrado!");
            System.out.println("Vida do inimigo: " + inimigoEncontrado.getVida());
        } else {
            System.out.println("Inimigo não encontrado!");
        }

        // Efetuar dano em um inimigo
        int vidaRestante = listaInimigos.efetuarDano(inimigo1, 20.0);
        if (vidaRestante >= 0) {
            System.out.println("Dano efetuado!");
            System.out.println("Vida restante do inimigo: " + vidaRestante);
        } else {
            System.out.println("Inimigo não encontrado!");
        }
		/*/
	}
}