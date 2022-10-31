package Exercicio8;
import java.util.Vector;

public class PilhaGenerica<T>
{
	private int n;
	private Vector<T> vetor;
	private int topo;
	
	public PilhaGenerica(int tamanho)
	{		
		n = tamanho;
		vetor = new Vector<T>(tamanho);
		topo = -1;
	}

	public boolean vazia()
	{
		return topo == -1 ? true : false; 
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public T pop()
	{
		T elemento;
		
		if (!this.vazia())
		{
			elemento = vetor.get(topo--);
			return elemento;
		}
		else
		{
			return null;
		}
	}
	
	public boolean push(T elemento)
	{
		if (!this.cheia())
		{
			vetor.add(++topo, elemento);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean retornaTopo(T elemento)
	{
	     if(!this.vazia()){
	        elemento = vetor.get(topo);         
	        return true;
	     }
	     else
	    	 return false;
	}

	//Exercicio8
	public static void ParesUnicos(int numN) {
        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(numN);
        String paresOrdem= ""; 
        int pares1 = 0, pares2 = 0;
        //Criando a equencia
        for (int x = 1; x <= numN; x++){
            pilha.push(x);
        }
        //Atribuindo o pares unicos em uma string
        for (int x = 1; x < numN; x++){
            pares1 = pilha.pop();
            pares2 = pilha.pop();
            paresOrdem += ")" + Integer.toString(pares2);
            paresOrdem += " ," + Integer.toString(pares1) + "(";
            pilha.push(pares2);
        }
        //Ordenando os pares do menor para o maior
        for(int x = paresOrdem.length()-1; x != -1; x--){
            System.out.print(paresOrdem.charAt(x));
        }
        System.out.print("\n");
    }
	
	
}