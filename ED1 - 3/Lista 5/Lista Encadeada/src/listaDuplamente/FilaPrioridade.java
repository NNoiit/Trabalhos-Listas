package listaDuplamente;

import java.util.NoSuchElementException;
public class FilaPrioridade<T extends Comparable<T>> {
    private Elo<T> prim;

    private class Elo<E extends Comparable<E>> {
        private E dado;
        private Elo<E> prox;
        private Elo<E> ant;

        public Elo(E dado) {
            this.dado = dado;
            this.prox = null;
            this.ant = null;
        }
    }

    public void enfileirar(T elemento) {
        Elo<T> novoElo = new Elo<T>(elemento);

        if (prim == null) {
            prim = novoElo;
        } else {
            Elo<T> atual = prim;
            Elo<T> anterior = null;

            while (atual != null && atual.dado.compareTo(elemento) <= 0) {
                anterior = atual;
                atual = atual.prox;
            }

            if (anterior == null) {
                prim = novoElo;
            } else {
                anterior.prox = novoElo;
            }

            novoElo.prox = atual;
            novoElo.ant = anterior;

            if (atual != null) {
                atual.ant = novoElo;
            }
        }
    }

    public T desenfileirar() {
        if (prim == null) {
            throw new NoSuchElementException("A fila está vazia.");
        }

        T elemento = prim.dado;
        prim = prim.prox;

        if (prim != null) {
            prim.ant = null;
        }

        return elemento;
    }

    public void imprimirFila() {
        Elo<T> atual = prim;

        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.prox;
        }

        System.out.println();
    }
}
