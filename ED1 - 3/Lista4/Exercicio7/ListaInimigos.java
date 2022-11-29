package Exercicio7;

public class ListaInimigos extends ListaGenerica<Inimigo> {     
   
    public Inimigo localizar(Inimigo inimigo) {
        boolean existeInimigo = super.busca(inimigo);
        if (existeInimigo) return inimigo;
        return null;
    }

    public int efetuarDano(Inimigo inimigo, int dano) {
        if (super.busca(inimigo)) {
            inimigo.setVida(inimigo.getVida() - dano);
            if (inimigo.getVida() <= 0) {
                super.remove(inimigo);
            }
        }
        return 0;
    }     
}
