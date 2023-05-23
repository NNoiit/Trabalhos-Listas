package listaSingular;

import java.util.Iterator;

public class ListaInimigos {
    private Elo prim;

    private class Elo {
        private Inimigo inimigo;
        private Elo prox;

        public Elo(Inimigo inimigo) {
            this.inimigo = inimigo;
            this.prox = null;
        }
    }

    public void inserir(Inimigo inimigo) {
        Elo novoElo = new Elo(inimigo);
        if (prim == null) {
            prim = novoElo;
        } else {
            Elo atual = prim;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = novoElo;
        }
    }

    public Inimigo localizar(Inimigo inimigo) {
        Elo atual = prim;
        while (atual != null) {
            if (atual.inimigo.equals(inimigo)) {
                return atual.inimigo;
            }
            atual = atual.prox;
        }
        return null;
    }

    public int efetuarDano(Inimigo inimigo, double dano) {
        Elo anterior = null;
        Elo atual = prim;
        while (atual != null) {
            if (atual.inimigo.equals(inimigo)) {
                inimigo.setVida(inimigo.getVida() - (int) dano);
                if (inimigo.getVida() <= 0) {
                    if (anterior == null) {
                        prim = atual.prox;
                    } else {
                        anterior.prox = atual.prox;
                    }
                    return 0; // Inimigo derrotado
                }
                return inimigo.getVida(); // Inimigo ainda tem vida restante
            }
            anterior = atual;
            atual = atual.prox;
        }
        return -1; // Inimigo não encontrado na lista
    }
}
