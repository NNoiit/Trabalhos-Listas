package Exercicio3;

public class ListaGenericaOrdenada<T extends Comparable> {
    /* Referência para primeiro elemento */
    protected Elo<T> prim;
    protected int tam = 0;

    protected class Elo <T extends Comparable>{
        protected T dado;
        protected Elo prox;

        public Elo() {
            prox= null;
        }
        public Elo(T elem) {
            dado= elem;
            prox= null;

        }
        public Elo(T elem, Elo proxElem) {
            dado= elem;
            prox= proxElem;
        }
    }

    public ListaGenericaOrdenada() {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Verifica se um determinado elemento está na lista. */
    public boolean busca(T elem) {
        Elo p;
        for(p =prim; p != null; p= p.prox){
            if(p.dado.equals(elem)){
                return true;
            }
        }
        return false;
    }
   
    /* Imprime todos os elementos da lista. */
    public void imprime() {
    	Elo p;
	System.out.println("Elementos da lista:");
		
	for(p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
	}
	System.out.println();
    }

    public int tamanho() {
        int tam = 0;
        Elo p = prim;
        while(p != null){
            tam++;
            p = p.prox;
        }
        return tam;
    }

     /*insere um elemento na lista ordenadamente*/
    public void insere(T novoDado) {
        Elo novoElo = new Elo(novoDado);

        if (prim == null) {
            prim = novoElo;
            return;
        }
        if (novoDado.compareTo(prim.dado) < 0) {
            novoElo.prox = prim;
            prim = novoElo;
            return;
        }

        Elo pontoInsercao;
        for (pontoInsercao = prim; pontoInsercao.prox != null ; pontoInsercao = pontoInsercao.prox) {
            if (novoDado.compareTo(pontoInsercao.prox.dado) < 0) {
                break;
            }
        }
        novoElo.prox = pontoInsercao.prox;
        pontoInsercao.prox = novoElo;
    }

    public boolean remove(T elem) {
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;
            if ((p == null) || (p.dado != elem))
                return false;
            if (p == prim)
                prim = prim.prox;
            else
                ant.prox = p.prox;
        p = null;
        return true;
    }
}