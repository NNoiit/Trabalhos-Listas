package Exercicio6;

public class Exercicio6 {
    /*
    A complexidade da questão é O(n).
    */
    public static void main(String[] args) {
        Diretorio root = new Diretorio("root");

        Diretorio jogos = new Diretorio("Jogos");
        jogos.insere(new Arquivo("Campo Minado"));
        jogos.insere(new Arquivo("Paciencia"));
        jogos.insere(new Arquivo("World of Warcraft"));
        root.insere(jogos);

        Diretorio faculdade = new Diretorio("Faculdade");
        faculdade.insere(new Arquivo("EDD1"));
        faculdade.insere(new Arquivo("EDD2"));
        faculdade.insere(new Arquivo("AA"));

        Diretorio aces = new Diretorio("ACEs");
        aces.insere(new Arquivo("ACE1"));
        aces.insere(new Arquivo("ACE2"));
        aces.insere(new Arquivo("ACE3"));
        faculdade.insere(aces);

        faculdade.insere(new Arquivo("TPD"));
        root.insere(faculdade);

        Diretorio filmes = new Diretorio("Filmes");
        Diretorio superHeroicos = new Diretorio("Super-heroicos");
        Diretorio marvel = new Diretorio("Marvel");
        marvel.insere(new Arquivo("Vingadores"));
        marvel.insere(new Arquivo("Homem-Aranha"));
        superHeroicos.insere(marvel);
        Diretorio dc = new Diretorio("DC");
        dc.insere(new Arquivo("Superman"));
        superHeroicos.insere(dc);
        filmes.insere(superHeroicos);
        Diretorio drama = new Diretorio("Drama");
        drama.insere(new Arquivo("Brilho Eterno de Uma Mente sem Lembrancas"));
        filmes.insere(drama);
        Diretorio comediasRomanticas = new Diretorio("Comedias Romanticas");
        filmes.insere(comediasRomanticas);
        root.insere(filmes);

        root.imprime(0);
    }
}