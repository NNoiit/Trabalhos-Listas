package Exercicio7;

public class Exercicio7 {
    /*
    A complexidade da questão é O(1).
    */
    public static void main(String[] args) {
        ListaInimigos lista = new ListaInimigos();
        Inimigo primeiroInimigo = new Inimigo(10);
        Inimigo segundoInimigo = new Inimigo(15);
        Inimigo terceiroInimigo = new Inimigo(25);
        Inimigo quartoInimigo = new Inimigo(50);

        lista.insere(primeiroInimigo);
        lista.insere(segundoInimigo);
        lista.insere(terceiroInimigo);
        lista.insere(quartoInimigo);

        lista.efetuarDano(primeiroInimigo, 5);
        lista.efetuarDano(segundoInimigo, 20);
        lista.efetuarDano(terceiroInimigo, 30);

        lista.imprime();
    }
}