package listaDuplamente;

public class Main
{
	public static void main(String[] args)
	{
		/*/ Exercicio 1 - Complexidade O(n*m)
		System.out.println("Questão 1");
		ListaDuplamente l1 = new ListaDuplamente();

		l1.insere(1);
		l1.insere(3);
		l1.insere(6);
		l1.insere(9);

		ListaDuplamente l2 = new ListaDuplamente();

		l2.insere(3);
		l2.insere(6);

		ListaDuplamente l3 = new ListaDuplamente();
		l3 = l3.intersecao(l1,l2);
		l3.imprime();
		System.out.println("----------------------------");
		/*/

		//Questão 2 e 3 na pasta e listaSingular

		/*/Exercicio 4 - Complexidade é O(n)
		System.out.println("Questão 4");
		ListaDuplamente lista = new ListaDuplamente();

		
		lista.insere(10);
		lista.insere(20);
		lista.insere(30);
		lista.insere(40);
		lista.insere(50);

		lista.trocaElos(1, 3);

		System.out.println("Lista após a troca:");
		lista.imprime();
		System.out.println("----------------------------");
		/*/

		/*/Exercicio 5 - Complexidade é O(n)
		System.out.println("Questão 5");
		ListaDuplamente lista1 = new ListaDuplamente();
		lista1.insere(10);
		lista1.insere(20);
		lista1.insere(30);
	
		ListaDuplamente lista2 = new ListaDuplamente();
		lista2.insere(10);
		lista2.insere(20);
		lista2.insere(30);
	
		ListaDuplamente lista3 = new ListaDuplamente();
		lista3.insere(10);
		lista3.insere(30);
		lista3.insere(20);
	
		System.out.println("Lista 1 é igual à Lista 2: " + lista1.verificaIgualdade(lista2)); 
		System.out.println("Lista 1 é igual à Lista 3: " + lista1.verificaIgualdade(lista3));
		System.out.println("----------------------------");
		/*/
		
		/*/Exercicio 6 - Complexidade O(n) para enfileirar, O(1) para dsebfileirar e O(n) para unprimir
		System.out.println("Questão 6");
		FilaPrioridade<Chamada> fila = new FilaPrioridade<>();

        
        Chamada chamada1 = new Chamada("Chamada 1", 10);
        Chamada chamada2 = new Chamada("Chamada 2", 5);
        Chamada chamada3 = new Chamada("Chamada 3", 7);
        Chamada chamada4 = new Chamada("Chamada 4", 5);

        fila.enfileirar(chamada1);
        fila.enfileirar(chamada2);
        fila.enfileirar(chamada3);
        fila.enfileirar(chamada4);

        
        fila.imprimirFila();

       
        Chamada chamadaAtendida1 = fila.desenfileirar();
        Chamada chamadaAtendida2 = fila.desenfileirar();

        System.out.println("Chamada atendida: " + chamadaAtendida1);
        System.out.println("Chamada atendida: " + chamadaAtendida2);

        fila.imprimirFila();
		System.out.println("----------------------------");
		/*/

	}
}