package Exercicio6;

public class Arquivo {
    protected String nome;
		
    public Arquivo(String nome) {
        this.nome = nome;
    }

    public void imprime(int profundidade) {
        System.out.println("\t".repeat(profundidade) + nome);
    }
}
