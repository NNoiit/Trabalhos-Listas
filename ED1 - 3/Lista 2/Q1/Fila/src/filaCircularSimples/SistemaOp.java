package filaCircularSimples;

public class SistemaOp extends Fila
{
	Fila fila_processo = new Fila(20);

    public boolean inclui_precesso(String processo){
        if(!fila_processo.cheia()){
            fila_processo.add(processo);
            return true;
        }
        return false;
    }

    public boolean remove_processo(){
        if(!fila_processo.vazia()){
            fila_processo.remove();
            return true;
        }
        return false;
    }

    public void imprime_processo(){
        int i = 0;
        while(!fila_processo.vazia()){
            if(!fila_processo.vazia()){
                System.out.print(i + ": " +fila_processo.remove());
            }
        }
    }
}