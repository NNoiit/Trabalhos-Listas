package Exercicio6;

public class Diretorio extends Arquivo {
    ListaGenerica<Arquivo> arquivos = new ListaGenerica<>();

    Diretorio(String nome) {
        super(nome);
    }

    public void insere(Arquivo arquivo) {
        arquivos.insere(arquivo);
    }

    @Override
    public void imprime(int profundidade) {
        super.imprime(profundidade);
        if (arquivos.tamanho() == 0) {
            System.out.println("\t".repeat(profundidade + 1) + "(Pasta Vazia)");
            return;
        }
        for(var p = arquivos.prim; p != null; p = p.prox) {
            p.dado.imprime(profundidade + 1);
        }
    }
}