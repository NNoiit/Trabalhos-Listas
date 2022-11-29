package Exercicio4;

public class ListaGenerica<T> {
    /* Referência para primeiro elemento */
    protected Elo<T> prim;
    protected int tam = 0;

    protected class Elo <T>{

        protected T dado;
        protected Elo<T> prox;

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

    public ListaGenerica() {
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

     /*insere um elemento na lista*/
    public void insere(T novo) {
        Elo p, q;
        Elo ant = null;
        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado != novo)); p = p.prox)
            ant = p;
        if (ant == null)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
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