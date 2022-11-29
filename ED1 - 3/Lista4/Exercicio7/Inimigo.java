package Exercicio7;

public class Inimigo {
    private int vida;
    private double danoPorSegundo;

    public Inimigo(int vida) {
        this.vida = vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return vida;
    }
    public void setDanoPorSegundo(double danoPorSegundo){
        this.danoPorSegundo = danoPorSegundo;
    }
    public double getDanoPorSegundo(){
        return danoPorSegundo;
    }
}
