package listaSingular;

import java.util.Iterator;

public class ListaNova<T>{
    protected Elo prim;
    

    protected class Elo<T> {
        protected T token;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(T token) {
            this.token = token;
            prox = null;
        }

        public Elo(T token, Elo proxElem) {
            this.token = token;
            prox = proxElem;
        }
    }

    public ListaNova() {
        prim = null;
    }

    public boolean vazia() {
        return prim == null;
    }

    public <T> void insere(T novo) {
        Elo p = new Elo(novo);
        if (prim == null) {
            prim = p;
        } else {
            Elo temp = prim;
            prim = p;
            p.prox = temp;
        }
    }

    public void imprime() {
        Elo p;

        System.out.println("Elementos da lista:");

        for (p = prim; p != null; p = p.prox) {
            System.out.print(p.token + " ");
        }

        System.out.println();
    }

    public String getFrase() {
        StringBuilder sb = new StringBuilder();

        Elo current = prim;
        while (current != null) {
            sb.insert(0, current.token);
            sb.insert(0, " ");
            current = current.prox;
        }
    
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
    
        return sb.toString();
    }

    public void inverterFrase() {
        Elo p = prim;
        ListaNova listaInvertida = new ListaNova();
    
        while (p != null) {
            String palavra = (String) p.token;
            StringBuilder palavraInvertida = new StringBuilder();
    
            for (int i = palavra.length() - 1; i >= 0; i--) {
                palavraInvertida.append(palavra.charAt(i));
            }
    
            listaInvertida.insere(palavraInvertida.toString());
            p = p.prox;
        }
    
        prim = listaInvertida.prim;
    }
}
