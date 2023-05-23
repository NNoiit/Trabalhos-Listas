package listaDuplamente;

public class Chamada implements Comparable<Chamada> {
    private String nome;
    private int custo;

    public Chamada(String nome, int custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    @Override
    public int compareTo(Chamada outraChamada) {
        // Comparação com base no custo das chamadas
        if (this.custo < outraChamada.custo) {
            return -1;
        } else if (this.custo > outraChamada.custo) {
            return 1;
        } else {
            // Em caso de empate no custo, respeita a ordem de chegada
            return 0;
        }
    }

    @Override
    public String toString() {
        return nome + " (Custo: " + custo + ")";
    }
}
