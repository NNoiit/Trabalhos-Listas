public class Teste {

	public static void main(String args[])
	{
		/*/Questão 1
		Conj conjunto = new Conj();
        
        conjunto.insere(5);
        conjunto.insere(2);
        conjunto.insere(9);
        conjunto.insere(1);
        conjunto.insere(7);

        
        conjunto.imprime();

       
        int menor = conjunto.getMenor();
        int maior = conjunto.getMaior();
        System.out.println("Menor elemento: " + menor);
        System.out.println("Maior elemento: " + maior);

       
        conjunto.remove(2);
        conjunto.remove(9);

        conjunto.imprime();

       
        menor = conjunto.getMenor();
        maior = conjunto.getMaior();
        System.out.println("Menor elemento: " + menor);
        System.out.println("Maior elemento: " + maior);
		/*/

		/*/Questão 2
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

       
        conjunto1.insere(1);
        conjunto1.insere(2);
        conjunto1.insere(3);

        conjunto2.insere(1);
        conjunto2.insere(2);
        conjunto2.insere(3);

        // test 1
        boolean saoIguais = conjunto1.eIgual(conjunto2);
        System.out.println("Os conjuntos são iguais? " + saoIguais);

        
        conjunto2.remove(3);
        conjunto2.insere(4);

        // test 2
        saoIguais = conjunto1.eIgual(conjunto2);
        System.out.println("Os conjuntos são iguais? " + saoIguais);
		/*/

		/*/Questão 3
		ConjGenerico<Integer> conjuntoCorrente = new ConjGenerico<>();
        conjuntoCorrente.insere(1);
        conjuntoCorrente.insere(3);
        conjuntoCorrente.insere(5);

        ConjGenerico<Integer> universo = new ConjGenerico<>();
        universo.insere(1);
        universo.insere(2);
        universo.insere(3);
        universo.insere(4);
        universo.insere(5);

        try {
            ConjGenerico<Integer> complemento = conjuntoCorrente.complementar(universo);
            complemento.imprime();
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção: " + e.getMessage());
        }

		/*/

		/*/Quetão 4
		ConjGenerico<Integer> conjuntoCorrente = new ConjGenerico<>();
        conjuntoCorrente.insere(1);
        conjuntoCorrente.insere(3);
        conjuntoCorrente.insere(5);

        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        conj2.insere(1);
        conj2.insere(2);
        conj2.insere(3);
        conj2.insere(4);
        conj2.insere(5);

        System.out.println("Conjunto corrente: ");
        conjuntoCorrente.imprime();

        System.out.println("Conjunto conj2: ");
        conj2.imprime();

        boolean eSubconjunto = conjuntoCorrente.eSubconjunto(conj2);
        System.out.println("O conjunto corrente é subconjunto de conj2? " + eSubconjunto);
		/*/

		/*/questão 5
		ConjGenerico<Integer> conjuntoCorrente = new ConjGenerico<>();
        conjuntoCorrente.insere(1);
        conjuntoCorrente.insere(2);
        conjuntoCorrente.insere(3);
        conjuntoCorrente.insere(4);
        conjuntoCorrente.insere(5);

        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();
        conjunto2.insere(3);
        conjunto2.insere(4);

        ConjGenerico<Integer> diferenca = conjuntoCorrente.diferenca(conjunto2);
        diferenca.imprime();
		/*/

		ConjGenerico<Integer> universo = new ConjGenerico<>();
        universo.insere(1);
        universo.insere(2);
        universo.insere(3);
        universo.insere(4);
        universo.insere(5);

        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        conj1.insere(1);
        conj1.insere(2);
        conj1.insere(3);

        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        conj2.insere(3);
        conj2.insere(4);
        conj2.insere(5);

        ConjGenerico<Integer> resultado = aplicaDeMorgan(universo, conj1, conj2);
        resultado.imprime();
    }

    public static <T extends Comparable<T>> ConjGenerico<T> aplicaDeMorgan(ConjGenerico<T> universo, ConjGenerico<T> conj1, ConjGenerico<T> conj2) {
        ConjGenerico<T> complementoConj1 = conj1.complementar(universo);
        ConjGenerico<T> complementoConj2 = conj2.complementar(universo);
        ConjGenerico<T> intersecao = complementoConj1.intersecao(complementoConj2);
        return intersecao;
    }
}